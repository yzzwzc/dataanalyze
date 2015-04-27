package com.topsec.datastore;

import com.topsec.dataanalyze.datasource.GlobalData;

public class SplitData implements Runnable{
	private String myString;
	public SplitData(String input){
		myString = input;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (myString.contains("Accepted password for")){
			GlobalData.storeSyslogAccept(myString);
		} else if (myString.contains("Failed password for")){
			GlobalData.storeSyslogFailed(myString);
		} else {
			String[] sourceStrArray = myString.split(",");
			if (0 != sourceStrArray.length){
				if (sourceStrArray[0].equals("4alogin")){
					GlobalData.storeLog4a(myString);
				} else if (sourceStrArray[0].equals("nabhlog")) {
					GlobalData.storeNABHLog(myString);
				} else {
					return;
				}
			}
		}
	}
}
