package br.com.moip.client.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa a resposta base dos requests do Moip. 
 * Respostas mais específicas estendem esta classe.
 *
 */
public class BaseResponse {

	@XStreamAlias("ID")
	protected String id;
	@XStreamAlias("Status")
	protected String status;

	public BaseResponse() {
		super();
	}

	/**
	 * Método de conveniência que devolve true se o request foi bem-sucedido.
	 * @return
	 */
	public boolean isSuccessful() {
		return "SUCESSO".equalsIgnoreCase(this.status);
	}
	
	/**
	 * Devolve o ID gerado pelo Moip para este request.
	 * @return
	 */
	public String getId() {
	    return id;
	}

	/**
	 * Devolve o Status deste request.
	 * @return
	 */
	public String getStatus() {
	    return status;
	}

}