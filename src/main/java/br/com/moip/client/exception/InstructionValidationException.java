package br.com.moip.client.exception;

/**
 * Exceção que é lançada mediante erros de validação na instrução.
 *
 */
public class InstructionValidationException extends RuntimeException {

	private static final long serialVersionUID = -3994880278848143871L;

	public InstructionValidationException(String msg) {
		super(msg);
	}
}
