package com.app.messaging.events;

import static com.app.messaging.Queue.UPDATE_PRODUCT;

import java.io.Serializable;

import com.app.dto.ProductDTO;
import com.app.messaging.Event;
import com.app.messaging.Queue;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
public class UpdateProductEvent extends Event implements Serializable {

	private static final long serialVersionUID = 1L;
	ProductDTO productDTO;

	@Override
	public Queue getQueue() {
		return UPDATE_PRODUCT;
	}
}
