package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PagamentoDireto")
public class DirectPayment {

	@XStreamAlias("Forma")
	private String paymentForm;

	@XStreamAlias("Instituicao")
	private String institution;

	@XStreamAlias("CartaoCredito")
	private CreditCard creditCard;

	@XStreamAlias("Parcelamento")
	private Parcel parcel;

	public DirectPayment withPaymentForm(final String forma) {
		this.paymentForm = forma;
		return this;
	}

	public DirectPayment withInstitution(final String instituicao) {
		this.institution = instituicao;
		return this;
	}

	public DirectPayment withCreditCard(final CreditCard cartaoCredito) {
		this.creditCard = cartaoCredito;
		return this;
	}

	public DirectPayment withParcel(final Parcel parcelamento) {
		this.parcel = parcelamento;
		return this;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public String getInstitution() {
		return institution;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public Parcel getParcel() {
		return parcel;
	}
	
}
