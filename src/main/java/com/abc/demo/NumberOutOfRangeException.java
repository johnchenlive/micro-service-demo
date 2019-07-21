package com.abc.demo;

/**
 * This exception is thrown when the input number is out of range.
 *
 */
public class NumberOutOfRangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumberOutOfRangeException() {

	}

	/**
	 * Constructor
	 * @param message
	 */
	public NumberOutOfRangeException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * @param cause
	 */
	public NumberOutOfRangeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 * @param message
	 * @param cause
	 */
	public NumberOutOfRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NumberOutOfRangeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
