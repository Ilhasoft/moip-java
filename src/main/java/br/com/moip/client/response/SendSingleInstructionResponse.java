package br.com.moip.client.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa a resposta ao cadastro de instrução única.
 *
 */
@XStreamAlias("ns1:EnviarInstrucaoUnicaResponse")
public class SendSingleInstructionResponse {

	@XStreamAlias("Resposta")
	private SendInstructionResponse response;

	/**
	 * Devolve a resposta ao cadastro de instrução única.
	 * @return
	 */
	public SendInstructionResponse getResponse() {
		return response;
	}

	/**
	 * Devolve o XML do qual foi gerada esta resposta.
	 * @return
	 */
	public String getXML() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(this);		
	}
	
	@Override
	public String toString() {
		return this.getXML();
	}

	/**
	 * Método de conveniência que devolve true se este request foi bem sucedido.
	 * @return
	 */
	public boolean isSuccessful() {
		return (this.response != null && this.response.isSuccessful());
	}
}
