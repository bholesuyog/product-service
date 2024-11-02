package com.app.messaging;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class Event {

	@Default
	protected UUID id = UUID.randomUUID();
	
	@Default
	protected LocalDateTime createdWhen = LocalDateTime.now();
	
	public abstract Queue getQueue();
}
