package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Boleto")
public class Billet {

	private String DiasExpiracao;
	private String Instrucao1;
	private String Instrucao2;
	private String Instrucao3;
	private String URLLogo;

	public static Billet billet() {
		return new Billet();
	}

	public Billet withDaysToExpire(final String diasExpiracao) {
		this.DiasExpiracao = diasExpiracao;
		return this;
	}

	public Billet withInstruction1(final String instrucao1) {
		this.Instrucao1 = instrucao1;
		return this;
	}

	public Billet withInstruction2(final String instrucao2) {
		this.Instrucao2 = instrucao2;
		return this;
	}

	public Billet withInstruction3(final String instrucao3) {
		this.Instrucao3 = instrucao3;
		return this;
	}

	public Billet withURLLogo(final String URLLogo) {
		this.URLLogo = URLLogo;
		return this;
	}

	public String getDiasExpiracao() {
		return DiasExpiracao;
	}

	public void setDiasExpiracao(final String diasExpiracao) {
		DiasExpiracao = diasExpiracao;
	}

	public String getInstrucao1() {
		return Instrucao1;
	}

	public void setInstrucao1(final String instrucao1) {
		Instrucao1 = instrucao1;
	}

	public String getInstrucao2() {
		return Instrucao2;
	}

	public void setInstrucao2(final String instrucao2) {
		Instrucao2 = instrucao2;
	}

	public String getInstrucao3() {
		return Instrucao3;
	}

	public void setInstrucao3(final String instrucao3) {
		Instrucao3 = instrucao3;
	}

	public String getURLLogo() {
		return URLLogo;
	}

	public void setURLLogo(final String uRLLogo) {
		URLLogo = uRLLogo;
	}

}
