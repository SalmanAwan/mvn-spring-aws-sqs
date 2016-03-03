package com.sandbox.aws.sqs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.Logger;

import javax.jms.JMSException;


public class SpringMain {

	public static void main(String args[]) throws JMSException {

		final Logger logger = Logger.getLogger(SpringMain.class);

		// Build application context by reading spring-config.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
				
		/*
		 * Publish Message 
		 */

		// Get an instance of message provider
		MyMessageProvider prdSvc = (MyMessageProvider) ctx.getBean("myMessageProviderService");

		// Send message 
		prdSvc.sendMessage("This is a test");
		
		
		/*
		 * Consume Message 
		 */
		
		// Get an instance of message receiver
		MyMessageConsumer conSvc = (MyMessageConsumer) ctx.getBean("myMessageConsumerService");

		// Try to read one message
    	conSvc.readMessage();

	}

}
