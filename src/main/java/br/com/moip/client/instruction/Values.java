package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Valores")
public class Values {

	@XStreamAlias("Valor")
	private String value;

	@XStreamAsAttribute
	private String currency = "BRL";

	public static Values values() {
		return new Values();
	}

	public Values withValue(final String valor) {
		this.value = valor;
		return this;
	}

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
