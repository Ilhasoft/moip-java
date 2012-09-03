package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CartaoCredito")
public class CreditCard {

	@XStreamAlias("Numero")
	private String number;

	@XStreamAlias("Expiracao")
	private String expiration;

	@XStreamAlias("CodigoSeguranca")
	private String PIN;

	@XStreamAlias("Portador")
	private Holder holder;

	public static CreditCard creditCard() {
		return new CreditCard();
	}

	public CreditCard withNumber(final String numero) {
		this.number = numero;
		return this;
	}

	public CreditCard withExpiration(final String expiracao) {
		this.expiration = expiracao;
		return this;
	}

	public CreditCard withHolder(final Holder portador) {
		this.holder = portador;
		return this;
	}

	public CreditCard withPIN(final String codigoSeguranca) {
		this.PIN = codigoSeguranca;
		return this;
	}

	public Holder withHolder() {
		if (this.holder == null) {
			this.holder = new Holder();
		}
		return this.holder;
	}

	public String getNumber() {
		return number;
	}

	public String getExpiration() {
		return expiration;
	}

	public String getPIN() {
		return PIN;
	}

	public Holder getHolder() {
		return holder;
	}
	
}
