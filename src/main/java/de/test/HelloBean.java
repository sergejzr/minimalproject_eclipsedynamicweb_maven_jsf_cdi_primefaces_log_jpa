package de.test;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



@ApplicationScoped
@Named
public class HelloBean {
	
	/*
	@PostConstruct
	public void initlogger() 
	{
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
	*/
	String greeting = "Hello, my friend!";
	private static final Logger logger = Logger.getLogger(HelloBean.class);
	public String getGreeting() {
		logger.info("Info about me");
		
		return greeting;
		
	}

	public void setGreeting(String greeting) {
		if(greeting==null||greeting.length()==0) {logger.fatal("Greeting not set!"); return;}
		if(greeting.length()<3) {logger.error("Greeting" +greeting+" too short!"); return;}
		logger.info("Set greetiong to "+greeting);
		logger.debug("Debug greetings lenght "+greeting.length());
		this.greeting = greeting;
	}

}