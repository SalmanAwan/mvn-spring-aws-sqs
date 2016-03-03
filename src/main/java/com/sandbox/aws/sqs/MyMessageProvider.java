package com.sandbox.aws.sqs;

import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.apache.log4j.Logger;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


@Service("myMessageProviderService")
public class MyMessageProvider {
	
	final Logger logger = Logger.getLogger(MyMessageProvider.class);
	
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final String txt) {	
		final String fmtTxt = String.format("%s - %s", (new Date()).toString(), txt);
		
		logger.info(String.format("Sending message with txt: %s", fmtTxt));
		
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				final TextMessage msg = session.createTextMessage(fmtTxt);				
				return msg;
			}			
		});
	}

}
