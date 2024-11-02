package com.app.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
//@ExtensionMethod(TracerExtensions.class)
public class JmsEventPublisher implements EventPublisher {

	Logger LOGGER = LoggerFactory.getLogger(JmsEventPublisher.class);

	final JmsTemplate jmsTemplate;
	final JmsDlqPublisher jmsDlqPublisher;
//	final Tracer tracer;

	public JmsEventPublisher(JmsTemplate jmsTemplate, JmsDlqPublisher jmsDlqPublisher) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.jmsDlqPublisher = jmsDlqPublisher;
	}

	@Override
	public void publish(Event event) {
		final var queueName = event.getQueue().getName();
//		final var traceId = tracer.currentTraceId();
		try {
			jmsTemplate.convertAndSend(queueName, event
//				, getMessagePostProcessor(traceId)
			);
			LOGGER.info("Event {} was sent to queue: {}", event, queueName);
		} catch (JmsException e) {
			LOGGER.error("Error occured while sending message to queue: {}", e.getMessage());
			jmsDlqPublisher.publish(event, e);
			e.printStackTrace();
		}

	}

}
