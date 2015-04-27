package com.topsec.datastore;

import java.io.IOException;

public class StoreData implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ReceiveData rcv_data = new ReceiveData();
		try {
			rcv_data.receivedata();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
