package com.topsec.dataanalyze;

import java.util.ArrayList;
import java.util.List;

import com.topsec.dataanalyze.datasource.GlobalData;
import com.topsec.dataanalyze.entity.BypassEntity;
import com.topsec.dataanalyze.entity.SyslogDataEntity;
import com.topsec.datastore.ReceiveData;
import com.topsec.datastore.SplitData;
import com.topsec.datastore.StoreData;

public class main {
	public static void main(String[] args) throws InterruptedException {
		GlobalData.init();
		Thread t = new Thread(new StoreData());
		t.start();

		while (true) {
			Log4ADataAnalyze abc = new Log4ADataAnalyze();
			abc.Log4ADataAnalyze();
//			System.out.println(abc.getData());
			Thread.sleep(5000);
		}
	}
}
