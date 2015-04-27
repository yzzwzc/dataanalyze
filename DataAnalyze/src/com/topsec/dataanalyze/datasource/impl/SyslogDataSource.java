package com.topsec.dataanalyze.datasource.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.topsec.dataanalyze.datasource.DataSource;
import com.topsec.dataanalyze.datasource.GlobalData;
import com.topsec.dataanalyze.entity.DataEntity;
import com.topsec.dataanalyze.entity.SyslogDataEntity;

public class SyslogDataSource implements DataSource {

	String serverAdd = "http://49.4.162.69/async/eslog/";
	/*
	 * 先在syslog日志中查询关键字，库名："hostlog"，字段名："message"，关键字："Accepted password for "
	 * 此处数据可以来自任意实体文件或者服务；
	 * */
	@Override
	public String getData(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataEntity> getDataFromList(String Table, String Message){
		List<SyslogDataEntity> syslogEntity = GlobalData.SyslogList;
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		
		for (int i = 0; i < syslogEntity.size(); i++){
			try {
				if ((syslogEntity.get(i)).getClass().getField(Table).get(syslogEntity.get(i)).equals(Message)){
					if(!returnEntity.contains(syslogEntity.get(i))){ 
						returnEntity.add(syslogEntity.get(i));
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return returnEntity;
	}	
	
	public List<DataEntity> getData(String Table, String Message) {
		// TODO Auto-generated method stub
		List<SyslogDataEntity> syslogEntity = new ArrayList<SyslogDataEntity>();
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		int startsize = 0;
		String searchString;
		String sr;
		int pageSize = 1000;
		while (true) {
			searchString = "auth_name=superman&auth_pwd=superman&querystring=oem_name:topsec AND " + Table + ":" + Message + "&size=" + pageSize + "&sortby=received_at&sortorder=desc&start=" + startsize + "&field=clientip&field=sender&field=user&field=timestamp";
			sr = http.sendPost(serverAdd, searchString);
			if (sr.equals("[]") == true){
				break;
			}
	        startsize += pageSize;
	        System.out.println(sr);
	        List<SyslogDataEntity> list = JSON.parseObject(sr, new TypeReference<List<SyslogDataEntity>>() {});
	        syslogEntity.addAll(list);
		}
		for (int i = 0; i < syslogEntity.size(); i++){
			if(!returnEntity.contains(syslogEntity.get(i))){ 
				returnEntity.add(syslogEntity.get(i));
			}
		}
		return returnEntity;
	}
}
