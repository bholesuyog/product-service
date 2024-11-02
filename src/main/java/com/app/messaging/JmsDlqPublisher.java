package com.app.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod(TracerExtension.class)
public class JmsDlqPublisher {

	Logger LOGGER = LoggerFactory.getLogger(JmsDlqPublisher.class);

	final JmsTemplate jmsTemplate;
//	final Tracer tracer;

	public JmsDlqPublisher(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	public void publish(final Event event, final Exception exception) {
		if (!event.getQueue().isDuplicate(exception)) {
			final var dlqName = event.getQueue().getName() + ".dlq";
//			final var traceId = tracer.currentTraceId();

			try {
				jmsTemplate.convertAndSend(dlqName, event
//					,getMassagePostProcessor(traceId, exception)
				);
				final var queueName = event.getQueue().getName();
				LOGGER.warn("Event : {} was resent from {} to {}", event, queueName, dlqName);
			} catch (JmsException e) {
				LOGGER.error("Error occured while sending message to DLQ {} : {}", dlqName, e.getMessage());
				e.printStackTrace();
			}

		}
	}

}
