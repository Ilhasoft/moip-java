package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa um comissionamento.
 * <br>XML: Elemento &lt;Comissionamento&gt;
 *
 */
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

	/**
	 * Define a razão deste comissionamento.
	 * <br>XML: Elemento &lt;Razao&gt;
	 * @param razao
	 * @return
	 */
	public Comissioning withReason(final String razao) {
		this.razao = razao;
		return this;
	}

	/**
	 * Define o valor percentual deste comissionamento.
	 * <br>XML: Elemento &lt;ValorPercentual&gt;
	 * @param valor
	 * @return
	 */
	public Comissioning withPercentValue(final String valor) {
		this.percentValue = valor;
		return this;
	}
	
	/**
	 * Define um valor fixo para este comissionamento.
	 * <br>XML: Elemento &lt;ValorFixo&gt;
	 * @param valor
	 * @return
	 */
	public Comissioning withFixedValue(final String valor) {
		this.fixedValue = valor;
		return this;
	}

	/**
	 * Define o comissionado deste comissionamento.
	 * <br>XML: Elemento &lt;Comissionado&gt;
	 * @param comissionado
	 * @return
	 */
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
