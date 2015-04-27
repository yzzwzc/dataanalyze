package com.topsec.dataanalyze.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.topsec.dataanalyze.entity.Login4ALogDataEntity;
import com.topsec.dataanalyze.entity.NabhlogDataEntity;
import com.topsec.dataanalyze.entity.SyslogDataEntity;

public class GlobalData {
	public static List<Login4ALogDataEntity> Login4ALogDataList;
	public static List<NabhlogDataEntity> NabhlogList;
	public static List<SyslogDataEntity> SyslogList;
	
	public static void init(){
		Login4ALogDataList = new ArrayList<Login4ALogDataEntity>();
		NabhlogList = new ArrayList<NabhlogDataEntity>();
		SyslogList = new ArrayList<SyslogDataEntity>();
	}
	
	public static synchronized void storeSyslogAccept(String logStr){
		SyslogDataEntity logEntity = new SyslogDataEntity();
		int pos = logStr.indexOf(' ', logStr.indexOf(' ', logStr.indexOf(' ') + 1) + 1);
		String timeStamp = logStr.substring(0, pos);
		int pos1 = logStr.indexOf(' ', pos + 1);
		String sender = logStr.substring(pos+1, pos1);
		pos = logStr.indexOf("Accepted password for") + 22;
		pos1 = logStr.indexOf(' ', pos);
		String user = logStr.substring(pos, pos1);
		pos = pos1 + 6;
		pos1 = logStr.indexOf(' ', pos);
		String clientip = logStr.substring(pos, pos1);

		logEntity.setClientip(clientip);
		logEntity.setResult("Accepted password");
		logEntity.setSender(sender);
		logEntity.setTimestamp(timeStamp);
		logEntity.setUser(user);
		SyslogList.add(logEntity);
		return;
	}
	
	public static synchronized void storeSyslogFailed(String logStr){
		SyslogDataEntity logEntity = new SyslogDataEntity();
		int pos = logStr.indexOf(' ', logStr.indexOf(' ', logStr.indexOf(' ') + 1) + 1);
		String timeStamp = logStr.substring(0, pos);
		int pos1 = logStr.indexOf(' ', pos + 1);
		String sender = logStr.substring(pos+1, pos1);
		pos = logStr.indexOf("Failed password for invalid user");
		if (pos == -1){
			pos = logStr.indexOf("Failed password for") + 20;
		} else 
		{
			pos = pos + 33;
		}
		pos1 = logStr.indexOf(' ', pos);
		String user = logStr.substring(pos, pos1);
		pos = pos1 + 6;
		pos1 = logStr.indexOf(' ', pos);
		String clientip = logStr.substring(pos, pos1);
		logEntity.setClientip(clientip);
		logEntity.setResult("Failed password");
		logEntity.setSender(sender);
		logEntity.setTimestamp(timeStamp);
		logEntity.setUser(user);
		SyslogList.add(logEntity);
		System.out.println(logEntity);
		return;
	}
	
	public static synchronized void storeNABHLog(String NABHLogStr){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(NABHLogStr);
		String tmp = m.replaceAll("");
		NabhlogDataEntity nabhEntity = new NabhlogDataEntity();
		String[] sourceStrArray = tmp.split(",");
		nabhEntity.setAction(sourceStrArray[7]);
		nabhEntity.setDstip(sourceStrArray[6]);
		nabhEntity.setLoginuser(sourceStrArray[3]);
		nabhEntity.setMaster(sourceStrArray[2]);
		nabhEntity.setNabh(sourceStrArray[8]);
		nabhEntity.setSessionid(sourceStrArray[9]);
		nabhEntity.setSrcip(sourceStrArray[5]);
		nabhEntity.setTime(sourceStrArray[4]);
		NabhlogList.add(nabhEntity);
	}
	
	public static synchronized void storeLog4a(String Log4aStr){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(Log4aStr);
		String tmp = m.replaceAll("");
		Login4ALogDataEntity log4aEntity = new Login4ALogDataEntity();
		String[] sourceStrArray = tmp.split(",");
		log4aEntity.setAction(sourceStrArray[7]);
		log4aEntity.setDstip(sourceStrArray[5]);
		log4aEntity.setLoginuser(sourceStrArray[3]);
		log4aEntity.setMaster(sourceStrArray[2]);
		log4aEntity.setSessionid(sourceStrArray[8]);
		log4aEntity.setSrcip(sourceStrArray[4]);
		log4aEntity.setTime(sourceStrArray[6]);
		Login4ALogDataList.add(log4aEntity);
	}
}
