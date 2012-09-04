package br.com.moip.client.exception;

/**
 * Exceção lançada mediante problemas na comunicação com o serviço do Moip.
 *
 */
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

	/**
	 * Devolve o status HTTP obtido na comunicação com o Moip.
	 * @return
	 */
	public int getStatusCode() {
		return statusCode;
	}
}
