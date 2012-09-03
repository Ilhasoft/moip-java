package br.com.moip.client.exception;

public class InstructionValidationException extends RuntimeException {

	private static final long serialVersionUID = -3994880278848143871L;

	public InstructionValidationException(String msg) {
		super(msg);
	}
}
