package com.topsec.dataanalyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.topsec.dataanalyze.datasource.DataSource;
import com.topsec.dataanalyze.datasource.impl.CenterZoneAssetsDataSource;
import com.topsec.dataanalyze.datasource.impl.NABHAssetsDataSource;
import com.topsec.dataanalyze.datasource.impl.Login4ADataSource;
import com.topsec.dataanalyze.datasource.impl.NabhlogDataSource;
import com.topsec.dataanalyze.datasource.impl.SyslogDataSource;
import com.topsec.dataanalyze.entity.DataEntity;
import com.topsec.dataanalyze.entity.BypassEntity;
import com.topsec.dataanalyze.entity.Login4ALogDataEntity;
import com.topsec.dataanalyze.entity.NabhlogDataEntity;
import com.topsec.dataanalyze.entity.SyslogDataEntity;

public class Log4ADataAnalyze implements DataAnalyze {
	//定义数据源
	DataSource DS_ZoneAssets=new CenterZoneAssetsDataSource();/*核心域资产数据源*/
	DataSource DS_NABHAssets=new NABHAssetsDataSource();/*4A资产数据源*/
	DataSource DS_Login4A=new Login4ADataSource();/*堡垒机数据源*/
	DataSource DS_Syslog=new SyslogDataSource();/*Syslog数据源*/
	DataSource DS_Anbhlog=new NabhlogDataSource();/*Syslog数据源*/
	
	//定义数据源保存实体结构
	List<BypassEntity> LogList=new ArrayList<BypassEntity>();
	/*
	 * 构造函数存放需要初始化的内容
	 * */
	public void Log4ADataAnalyze(){
		Analyze4ABypass();
	}
	@Override
	public List<BypassEntity> getData() {
		// TODO Auto-generated method stub
		return LogList;
	}
	
	private List<SyslogDataEntity> MergeLogList(List<SyslogDataEntity> origLogList){
		List<SyslogDataEntity> returnList = new ArrayList<SyslogDataEntity>();
		int hitTimes = 0;
		int j = 0;
		for (int i = 0; i < origLogList.size(); i++){
			hitTimes = 0;
			for (j = i + 1; j < origLogList.size(); j++){
				if ((origLogList.get(i)).timeequals(origLogList.get(j))){
					hitTimes++;
				} else {
					break;
				}
			}
			if (hitTimes >= 8){
				returnList.add((SyslogDataEntity)origLogList.get(i));
				i = j;
			}
		}

		return returnList;
	}
	
	private void anylazeNabhFromSyslog(List<SyslogDataEntity> sysLogList, boolean isFailedPass){
		for (int q = 0; q < sysLogList.size(); q++) {
			SyslogDataEntity SyslogInfo;
			SyslogInfo = (SyslogDataEntity)sysLogList.get(q);
			String sourceIp = SyslogInfo.getClientip();
			if (null != DS_NABHAssets.getDataFromList("devIP", sourceIp)){
				continue;
			}
			/* 在4A堡垒机日志中，查找刚才提取出来的IP，如果能匹配目的IP，则认为是命中一条，库名："4Alog"，字段名："serverip"。*/

			List<DataEntity> NABHList = DS_Login4A.getDataFromList("dstip", sourceIp);

			/* 常规绕行 */
			if (0 == NABHList.size()){
				BypassEntity EntityInfo = new BypassEntity();
				EntityInfo.setAbnormalBehaviorWarning("绕行4A");
				if (isFailedPass == true){
					EntityInfo.setAbnormalBehaviorSub("绕行后高频访问");
				} else {
					EntityInfo.setAbnormalBehaviorSub("常规绕行4A行为");
				}
				EntityInfo.setBehaviorSourceIp(SyslogInfo.getSender());
				EntityInfo.setPrimaryAccount(SyslogInfo.getUser());
				EntityInfo.setAddress4A("");
				EntityInfo.setProxyAddress(SyslogInfo.getSender());
				EntityInfo.setTargetIp(SyslogInfo.getClientip());
				EntityInfo.setActionType("登陆");
				EntityInfo.setMinorAccount(SyslogInfo.getUser());
				EntityInfo.setSeverity("严重");
				EntityInfo.setActionTime(SyslogInfo.getTimestamp());
				if(!this.LogList.contains(EntityInfo)){ 
					this.LogList.add(EntityInfo);
				}
			} else {
				/* 常规绕行 */
				for (int i = 0; i < NABHList.size(); i++){
					Login4ALogDataEntity NABHInfo = (Login4ALogDataEntity)NABHList.get(i);
					BypassEntity EntityInfo = new BypassEntity();
					EntityInfo.setAbnormalBehaviorWarning("绕行4A");
					if (isFailedPass == true){
						EntityInfo.setAbnormalBehaviorSub("绕行后高频访问");
					} else {
						EntityInfo.setAbnormalBehaviorSub("非常规绕行4A行为");
					}
					EntityInfo.setBehaviorSourceIp(NABHInfo.getSrcip());
					EntityInfo.setPrimaryAccount(NABHInfo.getMaster());
					List<DataEntity> NABHlogList = DS_Anbhlog.getDataFromList("sessionid", NABHInfo.getSessionid());
					if (NABHlogList.size() != 0){
						EntityInfo.setAddress4A(((NabhlogDataEntity)(NABHlogList.get(0))).getNabh());
					} else {
						EntityInfo.setAddress4A("未记录");
					}
					EntityInfo.setProxyAddress(NABHInfo.getDstip());
					EntityInfo.setTargetIp(SyslogInfo.getSender());
					EntityInfo.setActionType("登陆");
					EntityInfo.setMinorAccount(NABHInfo.getLoginuser());
					EntityInfo.setSeverity("严重");
					EntityInfo.setActionTime(NABHInfo.getTime());
					if(!this.LogList.contains(EntityInfo)){ 
						this.LogList.add(EntityInfo);
					}
				}
			}
		}
	}
	
	private void Analyze4ABypass(){
		List<DataEntity> LogList = DS_Syslog.getDataFromList("result", "Accepted password");
		List<SyslogDataEntity> acceptSyslogList = new ArrayList<SyslogDataEntity>();
		for (int j = 0; j < LogList.size(); j++){
			acceptSyslogList.add((SyslogDataEntity)LogList.get(j));
		}
		anylazeNabhFromSyslog(acceptSyslogList, false);
		
		List<DataEntity> FailedLogList = DS_Syslog.getDataFromList("result", "Failed password");
		List<SyslogDataEntity> newFailedLogList = new ArrayList<SyslogDataEntity>();
		for (int i = 0; i < FailedLogList.size(); i++){
			newFailedLogList.add((SyslogDataEntity)FailedLogList.get(i));
		}

		Collections.sort(newFailedLogList, new Comparator<SyslogDataEntity>() {
			@Override
			public int compare(SyslogDataEntity o1, SyslogDataEntity o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		anylazeNabhFromSyslog(MergeLogList(newFailedLogList), true);
	}
}
