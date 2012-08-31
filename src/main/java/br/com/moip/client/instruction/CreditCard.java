package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CartaoCredito")
public class CreditCard {

	@XStreamAlias("Numero")
	private String numero;

	@XStreamAlias("Expiracao")
	private String expiracao;

	@XStreamAlias("CodigoSeguranca")
	private String codigoSeguranca;

	@XStreamAlias("Portador")
	private Holder portador;

	public static CreditCard creditCard() {
		return new CreditCard();
	}

	public CreditCard withNumber(final String numero) {
		this.numero = numero;
		return this;
	}

	public CreditCard withExpiration(final String expiracao) {
		this.expiracao = expiracao;
		return this;
	}

	public CreditCard withHolder(final Holder portador) {
		this.portador = portador;
		return this;
	}

	public CreditCard withPIN(final String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
		return this;
	}

	public Holder withHolder() {
		if (this.portador == null) {
			this.portador = new Holder();
		}
		return this.portador;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(final String expiracao) {
		this.expiracao = expiracao;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(final String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Holder getPortador() {
		return portador;
	}

	public void setPortador(final Holder portador) {
		this.portador = portador;
	}

}
