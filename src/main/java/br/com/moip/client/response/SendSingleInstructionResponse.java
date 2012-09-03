package br.com.moip.client.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ns1:EnviarInstrucaoUnicaResponse")
public class SendSingleInstructionResponse {

	@XStreamAlias("Resposta")
	private SendInstructionResponse response;

	public SendInstructionResponse getResponse() {
		return response;
	}

	public String getXML() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(this);		
	}
	
	@Override
	public String toString() {
		return this.getXML();
	}

	public boolean isSuccessful() {
		return (this.response != null && this.response.isSuccessful());
	}
}
