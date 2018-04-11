package com.depromeet.exception;

public class UnprocessableEntityException extends RuntimeException {

	private static final long serialVersionUID = -4631484707872322978L;

	public UnprocessableEntityException() {
		super();
	}

	public UnprocessableEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnprocessableEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnprocessableEntityException(String message) {
		super(message);
	}

	public UnprocessableEntityException(Throwable cause) {
		super(cause);
	}
}
