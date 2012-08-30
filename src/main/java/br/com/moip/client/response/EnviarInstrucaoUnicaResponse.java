package br.com.moip.client.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ns1:EnviarInstrucaoUnicaResponse")
public class EnviarInstrucaoUnicaResponse {

	@XStreamAlias("Resposta")
	private Resposta resposta;

	public Resposta getResposta() {
		return resposta;
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

}
