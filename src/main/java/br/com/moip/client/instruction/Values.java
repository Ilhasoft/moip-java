package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Classe que representa o valor de um pagamento.
 *
 */
@XStreamAlias("Valores")
public class Values {

	@XStreamAlias("Valor")
	private String value;

	@XStreamAsAttribute
	private String currency = "BRL";

	/**
	 * Define a quantia deste valor.
	 * @param valor
	 * @return
	 */
	public Values withValue(final String valor) {
		this.value = valor;
		return this;
	}

	/**
	 * Define a moeda utilizada para representar este valor.
	 * @param moeda
	 * @return
	 */
	public Values withCurrency(final String moeda) {
		this.currency = moeda;
		return this;
	}

	public String getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

}
