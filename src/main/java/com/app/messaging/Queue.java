package com.app.messaging;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@Getter
@AllArgsConstructor
public enum Queue {

	CREATE_PRODUCT(QueueNames.CREATE_PRODUCT), UPDATE_PRODUCT(QueueNames.UPDATE_PRODUCT);

	private static final List<String> PATTERN_FOR_DUPLICATES = List.of("must be unique", "unique constraint");

	final String name;

	public String getName() {
		return name;
	}

	public boolean isDuplicate(final Exception exception) {
		return PATTERN_FOR_DUPLICATES.stream().anyMatch(pattern -> exceptionContains(exception, pattern));

	}

	private boolean exceptionContains(final Exception exception, final String pattern) {
		final var exceptionMessage = exception.getMessage();
		if(exceptionMessage == null) {
			return false;
		}
		final var stackTrace = getStackTrace(exception);
		return exceptionMessage.contains(pattern) || stackTrace.contains(pattern);
	}

	@UtilityClass
	public static class QueueNames {
		public static final String CREATE_PRODUCT = "productservice.create.product";
		public static final String UPDATE_PRODUCT = "productservice.update.product";
	}

}
