package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa o valor de um pagamento.
 * <br>XML: Elemento &lt;Valores&gt;
 *
 */
@XStreamAlias("Valores")
public class Values {

	@XStreamAlias("Valor")
	private String value;

	/**
	 * Define a quantia deste valor.
	 * <br>XML: Elemento &lt;Valor&gt;
	 * @param valor
	 * @return
	 */
	public Values withValue(final String valor) {
		this.value = valor;
		return this;
	}

	public String getValue() {
		return value;
	}

}
