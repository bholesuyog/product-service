package com.app.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JMSConfiguration {

	@Bean
	DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		
		jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
		jmsListenerContainerFactory.setConcurrency("5-10");
		
		return jmsListenerContainerFactory;
	}
}
