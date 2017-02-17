package com.hsp.jms;

import java.util.Map;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;


@Service("listener")
public class Listener {

	@JmsListener(destination="amqMessageQueue")
	public void messageReceived(Map<String, Object> message) throws Exception {

		String said = (String) message.get("said");
		System.out.println( "Listener: " + said);
	}
}
