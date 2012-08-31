package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Valores")
public class Values {

	@XStreamAlias("Valor")
	private String valor;

	@XStreamAsAttribute
	private String moeda = "BRL";

	public static Values values() {
		return new Values();
	}

	public Values withValue(final String valor) {
		this.valor = valor;
		return this;
	}

	public Values comTipoMoeda(final String moeda) {
		this.moeda = moeda;
		return this;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(final String valor) {
		this.valor = valor;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(final String moeda) {
		this.moeda = moeda;
	}

}
