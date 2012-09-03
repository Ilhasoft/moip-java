package br.com.moip.client.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("RespostaPagamentoDireto")
public class DirectPaymentResponse {

	@XStreamAlias("TotalPago")
	private String totalPaid;

	@XStreamAlias("TaxaMoIP")
	private String moipTax;

	@XStreamAlias("Status")
	private String status;

	@XStreamAlias("CodigoMoIP")
	private String moipCode;

	@XStreamAlias("Mensagem")
	private String message;

	@XStreamAlias("CodigoRetorno")
	private String returnCode;

	@XStreamAlias("CodigoAutorizacao")
	private String authorizationCode;

	public String getTotalPaid() {
		return totalPaid;
	}

	public String getMoipTax() {
		return moipTax;
	}

	public String getStatus() {
		return status;
	}

	public String getMoipCode() {
		return moipCode;
	}

	public String getMessage() {
		return message;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	@Override
	public String toString() {
		return "RespostaPagamentoDireto [totalPago=" + totalPaid
				+ ", taxaMoIP=" + moipTax + ", status=" + status
				+ ", codigoMoIP=" + moipCode + ", mensagem=" + message
				+ ", codigoRetorno=" + returnCode + "]";
	}

}
