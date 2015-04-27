package com.topsec.dataanalyze.datasource.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.topsec.dataanalyze.datasource.DataSource;
import com.topsec.dataanalyze.datasource.GlobalData;
import com.topsec.dataanalyze.entity.DataEntity;
import com.topsec.dataanalyze.entity.Login4ALogDataEntity;

public class Login4ADataSource implements DataSource {
	String serverAdd = "http://49.4.162.69/async/eslog/";
	/*
	 * 	在4A堡垒机日志中提取日志
	 * */
	@Override
	public String getData(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataEntity> getDataFromList(String Table, String Message){
		List<Login4ALogDataEntity> nabhEntity = GlobalData.Login4ALogDataList;
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		
		for (int i = 0; i < nabhEntity.size(); i++){
			try {
				if ((nabhEntity.get(i)).getClass().getField(Table).get(nabhEntity.get(i)).equals(Message)){
					if(!returnEntity.contains(nabhEntity.get(i))){ 
						returnEntity.add(nabhEntity.get(i));
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
		List<Login4ALogDataEntity> nabhEntity = new ArrayList<Login4ALogDataEntity>();
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		int startsize = 0;
		String searchString;
		String sr;
		int pageSize = 1000;
		while (true) {
			searchString = "auth_name=superman&auth_pwd=superman&querystring=oem_name:topsec AND topsec_logtype:4alogin AND " + Table + ":" + Message + " AND action:login successful&size=" + pageSize + "&sortby=received_at&sortorder=desc&start=" + startsize + "&field=srcip&field=master&field=dstip&field=loginuser&field=time&field=sessionid";
			sr = http.sendPost(serverAdd, searchString);
			if (sr.equals("[]") == true){
				break;
			}
	        startsize += pageSize;
	        List<Login4ALogDataEntity> list = JSON.parseObject(sr, new TypeReference<List<Login4ALogDataEntity>>() {});
	        nabhEntity.addAll(list);
		}
		for (int i = 0; i < nabhEntity.size(); i++){
			if(!returnEntity.contains(nabhEntity.get(i))){ 
				returnEntity.add(nabhEntity.get(i));
			}
		}
		return returnEntity;
	}
}
