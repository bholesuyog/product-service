package com.app.subscriber;

import static com.app.messaging.Queue.QueueNames.CREATE_PRODUCT;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.app.messaging.EventSubscriber;
import com.app.messaging.events.CreateProductEvent;
import com.app.service.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductEventSubscriber implements EventSubscriber<CreateProductEvent> {

	final ProductService productService;

	@Override
	@JmsListener(destination = CREATE_PRODUCT)
	public void handleEvent(CreateProductEvent event) {
		productService.createProduct(event.getProductDTO());
	}

}
