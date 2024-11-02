package com.app.subscriber;

import static com.app.messaging.Queue.QueueNames.UPDATE_PRODUCT;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.app.messaging.EventSubscriber;
import com.app.messaging.events.UpdateProductEvent;
import com.app.service.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductEventSubscriber implements EventSubscriber<UpdateProductEvent> {

	final ProductService productService;

	@Override
	@JmsListener(destination = UPDATE_PRODUCT)
	public void handleEvent(UpdateProductEvent event) {
		productService.updateProduct(event.getProductDTO().id(), event.getProductDTO());
	}

}
