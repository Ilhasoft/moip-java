package br.com.moip.client.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Classe que representa um erro informado pelo Moip na resposta a requests.
 *
 */
@XStreamAlias("Erro")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class Error {

	@XStreamAsAttribute
	@XStreamAlias("Codigo")
	private String code;
	
	private String message;

	/**
	 * Devolve o código de erro associado a este erro.
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Devolve a mensagem associada a este erro.
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
}
