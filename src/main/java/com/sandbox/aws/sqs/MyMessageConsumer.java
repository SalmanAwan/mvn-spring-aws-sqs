package com.sandbox.aws.sqs;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@Service("myMessageConsumerService")
public class MyMessageConsumer {
	
	final Logger logger = Logger.getLogger(MyMessageConsumer.class);
	
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void readMessage() throws JMSException {		
		logger.info("Reading message");
		
		Message msg = jmsTemplate.receive();
		
		logger.info("JMS Profile Received");
		
		if(msg instanceof TextMessage) {
			TextMessage txtMsg = (TextMessage) msg;
			logger.info(String.format("Receive text: %s", txtMsg.getText()));
		}
		
		logger.debug(msg.getClass());
		logger.info("Done");
		
	}

}
