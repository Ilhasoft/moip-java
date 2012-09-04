package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe para configuração do Boleto.
 * <br>XML: Elemento &lt;Boleto&gt;
 *
 */
@XStreamAlias("Boleto")
public class Billet {

	@XStreamAlias("DiasExpiracao")
	private String daysToExpire;
	
	@XStreamAlias("Instrucao1")
	private String instruction1;
	
	@XStreamAlias("Instrucao2")
	private String instruction2;
	
	@XStreamAlias("Instrucao3")
	private String instruction3;
	
	@XStreamAlias("URLLogo")
	private String URLLogo;

	/**
	 * Define o número de dias para expiração do boleto.
	 * <br>XML: Elemento &lt;DiasExpiracao&gt;
	 * @param diasExpiracao
	 * @return
	 */
	public Billet withDaysToExpire(final String diasExpiracao) {
		this.daysToExpire = diasExpiracao;
		return this;
	}

	public Billet withInstruction1(final String instrucao1) {
		this.instruction1 = instrucao1;
		return this;
	}

	public Billet withInstruction2(final String instrucao2) {
		this.instruction2 = instrucao2;
		return this;
	}

	public Billet withInstruction3(final String instrucao3) {
		this.instruction3 = instrucao3;
		return this;
	}

	/**
	 * Define a URL do Logo do Boleto.
	 * <br>XML: Elemento &lt;URLLogo&gt;
	 * @param URLLogo
	 * @return
	 */
	public Billet withURLLogo(final String URLLogo) {
		this.URLLogo = URLLogo;
		return this;
	}

	public String getDaysToExpire() {
		return daysToExpire;
	}

	public String getInstruction1() {
		return instruction1;
	}

	public String getInstruction2() {
		return instruction2;
	}

	public String getInstruction3() {
		return instruction3;
	}

	public String getURLLogo() {
		return URLLogo;
	}

}
