package com.app.messaging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventSubscriberDlqAspect extends EventSubscriberAspect {

	Logger LOGGER = LoggerFactory.getLogger(EventSubscriberDlqAspect.class);

	JmsDlqPublisher jmsDlqPublisher;

	public EventSubscriberDlqAspect(JmsDlqPublisher jmsDlqPublisher) {
		super();
		this.jmsDlqPublisher = jmsDlqPublisher;
	}

	@Around(value = "inEventSubscriber(event)", argNames = "proceedingJoinPoint,event")
	@Order(2)
	public void handleMethod(final ProceedingJoinPoint proceedingJoinPoint, final Event event) throws Throwable {
		try {
			proceedingJoinPoint.proceed();
		} catch (final Exception exception) {
			jmsDlqPublisher.publish(event, exception);
		}
	}
}
