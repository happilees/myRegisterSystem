package com.hsp.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.hsp.domain.Talk;


@Service("publisher")
public class Publisher {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	//发布
	public void sendTalk(String said) {
		
        Talk talk = new Talk(said);
		sendMessage(talk);
	}

	public void sendMessage(final Talk talk) {
        //内部类利用jmsTemplate创建session
		jmsTemplate.send(

			new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {

					MapMessage mapMessage = session.createMapMessage();
					mapMessage.setString("said", talk.getSaid());
					return mapMessage;
				}
			}
		);
		System.out.println("Publisher: " + talk.getSaid());
	}
}
