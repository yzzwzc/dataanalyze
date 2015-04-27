package com.topsec.dataanalyze.datasource.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.topsec.dataanalyze.datasource.DataSource;
import com.topsec.dataanalyze.datasource.GlobalData;
import com.topsec.dataanalyze.entity.DataEntity;
import com.topsec.dataanalyze.entity.NabhlogDataEntity;

public class NabhlogDataSource implements DataSource {
	
	String serverAdd = "http://49.4.162.69/async/eslog/";

	@Override
	public String getData(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataEntity> getDataFromList(String Table, String Message){
		List<NabhlogDataEntity> nabhlogEntity = GlobalData.NabhlogList;
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		
		for (int i = 0; i < nabhlogEntity.size(); i++){
			try {
				if ((nabhlogEntity.get(i)).getClass().getField(Table).get(nabhlogEntity.get(i)).equals(Message)){
					if(!returnEntity.contains(nabhlogEntity.get(i))){ 
						returnEntity.add(nabhlogEntity.get(i));
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
	
	@Override
	public List<DataEntity> getData(String Table, String Message) {
		// TODO Auto-generated method stub
		List<NabhlogDataEntity> nabhEntity = new ArrayList<NabhlogDataEntity>();
		List<DataEntity> returnEntity = new ArrayList<DataEntity>();
		int startsize = 0;
		String searchString;
		String sr;
		int pageSize = 1000;
		while (true) {
			searchString = "auth_name=superman&auth_pwd=superman&querystring=oem_name:topsec AND topsec_logtype:nabhlog AND " + Table + ":" + Message + "&size=" + pageSize + "&sortby=received_at&sortorder=desc&start=" + startsize + "&field=master&field=loginuser&field=time&field=srcip&field=dstip&field=action&field=nabh&field=sessionid";
			System.out.println(searchString);
			sr = http.sendPost(serverAdd, searchString);
			if (sr.equals("[]") == true){
				break;
			}
	        startsize += pageSize;
	        List<NabhlogDataEntity> list = JSON.parseObject(sr, new TypeReference<List<NabhlogDataEntity>>() {});
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
