package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PagamentoDireto")
public class DirectPayment {

	@XStreamAlias("Forma")
	private String forma;

	@XStreamAlias("Instituicao")
	private String instituicao;

	@XStreamAlias("CartaoCredito")
	private CreditCard cartaoCredito;

	@XStreamAlias("Parcelamento")
	private Parcel parcelamento;

	public static DirectPayment directPayment() {
		return new DirectPayment();
	}

	public DirectPayment withPaymentForm(final String forma) {
		this.forma = forma;
		return this;
	}

	public DirectPayment withInstitution(final String instituicao) {
		this.instituicao = instituicao;
		return this;
	}

	public DirectPayment withCreditCard(final CreditCard cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
		return this;
	}

	public DirectPayment withParcel(final Parcel parcelamento) {
		this.parcelamento = parcelamento;
		return this;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(final String forma) {
		this.forma = forma;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(final String instituicao) {
		this.instituicao = instituicao;
	}

	public CreditCard getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(final CreditCard cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Parcel getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(final Parcel parcelamento) {
		this.parcelamento = parcelamento;
	}

}
