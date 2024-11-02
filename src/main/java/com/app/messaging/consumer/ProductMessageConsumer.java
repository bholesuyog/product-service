package com.app.messaging.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.app.messaging.SystemMessage;

@Component
public class ProductMessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductMessageConsumer.class);
	
	@JmsListener(destination = "product.create.queue")
	public void messageListener(SystemMessage message) {
		LOGGER.info("Message received. {}", message);
		
		
	}
}
