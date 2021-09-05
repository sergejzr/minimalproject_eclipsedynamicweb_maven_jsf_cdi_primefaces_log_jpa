package mlog;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class LogInitListener extends org.apache.webbeans.servlet.WebBeansConfigurationListener {

    @Override
    public void contextInitialized(ServletContextEvent arg) {
        System.out.println("contextInitialized....");
        
        //remove the jsf root logger, avoid duplicated logging
        //try comment out this and see the different on the console
        //SLF4JBridgeHandler.removeHandlersForRootLogger();
        //SLF4JBridgeHandler.install();
        super.contextInitialized(arg);
        try {
			PropertyConfigurator.configure(new Properties() {
				private static final long serialVersionUID = 3522475775881727293L;
				{

					load(getClass().getClassLoader()
							.getResourceAsStream("log4j.properties"));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg) {
        System.out.println("contextDestroyed....");
        super.contextDestroyed(arg);

    }

}
