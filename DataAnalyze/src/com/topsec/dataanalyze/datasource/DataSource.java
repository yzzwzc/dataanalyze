package com.topsec.dataanalyze.datasource;

import java.util.List;

import com.topsec.dataanalyze.entity.DataEntity;;

/*
 *   获取数据的接口，用来实现从不同的数据源获取需要的数据
 *   
 *   暂定一个获取接口，如果有特殊需要，根据需要添加对应的接口
 * */
public interface DataSource {
	/*
	 * 根据制定条件获取数据
	 * */
	public String getData(String condition);
	public List<DataEntity> getData(String Table, String Message);
	public List<DataEntity> getDataFromList(String Table, String Message);
}
