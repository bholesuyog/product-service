package com.app.messaging;

import org.aspectj.lang.annotation.Pointcut;

public class EventSubscriberAspect {

	@Pointcut("within(com.app.messaging.EventSubscriber+) "
			+ "&& @annotation(org.springframework.jms.annotation.JmsListener)" 
			+ "&& execution(public void handleEvent(com.app.messaging.Event+)) " 
			+ "&& args(event)")

	public <T extends Event> void inEventSubscriber(final T event) {

	}
}
