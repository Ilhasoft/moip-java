package br.com.moip.client.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Classe que representa a resposta ao cadastro de instrução.
 *
 */
@XStreamAlias("Resposta")
public class SendInstructionResponse extends BaseResponse {

	@XStreamAlias("Token")
	private String token;

	@XStreamImplicit(itemFieldName = "Erro")
	private List<Error> errors;

	/**
	 * Devolve o token associado à instrução cadastrada, ou null se houveram erros.
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Devolve os erros, ou null se não houveram.
	 * @return
	 */
	public List<Error> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", status=" + status + ", token=" + token
				+ ", erro=" + errors + "]";
	}

}
