package br.com.moip.client.exception;

public class MoipClientException extends RuntimeException {

	private static final long serialVersionUID = 4254719822440156101L;
	
	private int statusCode = 200;

	public MoipClientException() {
		super();
	}

	public MoipClientException(final int statusCode, final Throwable cause) {
		super(cause);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
