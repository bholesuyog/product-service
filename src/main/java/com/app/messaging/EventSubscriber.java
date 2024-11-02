package com.app.messaging;

public interface EventSubscriber<T extends Event> {

	void handleEvent(final T event);
}
