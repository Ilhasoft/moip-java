package br.com.moip.client.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Resposta")
public class SendInstructionResponse extends BaseResponse {

	@XStreamAlias("Token")
	private String token;

	@XStreamImplicit(itemFieldName = "Erro")
	private List<Error> errors;

	@XStreamAlias("RespostaPagamentoDireto")
	private DirectPaymentResponse directPaymentResponse;

	public String getToken() {
		return token;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public DirectPaymentResponse getDirectPaymentResponse() {
		return directPaymentResponse;
	}

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", status=" + status + ", token=" + token
				+ ", erro=" + errors + "]";
	}

}
