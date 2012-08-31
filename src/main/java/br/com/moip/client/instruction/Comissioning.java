package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Comissionamento")
public class Comissioning {

	@XStreamAlias("ValorPercentual")
	private String valorPercentual;
	
	@XStreamAlias("ValorFixo")
	private String valorFixo;

	@XStreamAlias("Comissionado")
	private Comissioned comissionado;

	@XStreamAlias("Razao")
	private String razao;

	public static Comissioning commissioning() {
		return new Comissioning();
	}

	public Comissioning withReason(final String razao) {
		this.razao = razao;
		return this;
	}

	public Comissioning withPercentValue(final String valor) {
		this.valorPercentual = valor;
		return this;
	}
	
	public Comissioning withFixedValue(final String valor) {
		this.valorFixo = valor;
		return this;
	}

	public Comissioning withCommissioned(final Comissioned comissionado) {
		this.comissionado = comissionado;
		return this;
	}

	public Comissioned getComissionado() {
		return comissionado;
	}

	public void setComissionado(final Comissioned comissionado) {
		this.comissionado = comissionado;
	}

	public String getValorPercentual() {
		return valorPercentual;
	}

	public void setValorPercentual(final String valorPercentual) {
		this.valorPercentual = valorPercentual;
	}

	public String getValorFixo() {
		return valorFixo;
	}
	
	public void setValorFixo(String valorFixo) {
		this.valorFixo = valorFixo;
	}
	
	public String getRazao() {
		return razao;
	}

	public void setRazao(final String razao) {
		this.razao = razao;
	}

}
