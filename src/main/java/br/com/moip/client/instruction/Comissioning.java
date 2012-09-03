package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Comissionamento")
public class Comissioning {

	@XStreamAlias("ValorPercentual")
	private String percentValue;
	
	@XStreamAlias("ValorFixo")
	private String fixedValue;

	@XStreamAlias("Comissionado")
	private Comissioned comissioned;

	@XStreamAlias("Razao")
	private String razao;

	public Comissioning withReason(final String razao) {
		this.razao = razao;
		return this;
	}

	public Comissioning withPercentValue(final String valor) {
		this.percentValue = valor;
		return this;
	}
	
	public Comissioning withFixedValue(final String valor) {
		this.fixedValue = valor;
		return this;
	}

	public Comissioning withComissioned(final Comissioned comissionado) {
		this.comissioned = comissionado;
		return this;
	}

	public String getPercentValue() {
		return percentValue;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public Comissioned getComissioned() {
		return comissioned;
	}

	public String getRazao() {
		return razao;
	}

}
