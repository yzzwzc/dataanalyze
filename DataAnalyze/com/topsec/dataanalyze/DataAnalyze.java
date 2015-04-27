package com.topsec.dataanalyze;

import java.util.List;

import com.topsec.dataanalyze.entity.Log4AEntity;

/*
 * 	数据分析服务接口，为上层应用调用当前服务提供的接口
 * 
 * 其他接口根据需要添加
 * */
public interface DataAnalyze {
	/*
	 * 无条件获取所有数据
	 * */
	public List<Log4AEntity> getData();
}
