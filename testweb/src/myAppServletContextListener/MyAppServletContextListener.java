package myAppServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.topsec.dataanalyze.datasource.GlobalData;
import com.topsec.datastore.StoreData;

public class MyAppServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		GlobalData.init();
		Thread t = new Thread(new StoreData());
		t.start();		
	}

}
