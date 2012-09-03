package br.com.moip.client.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ns1:ChecarValoresParcelamentoResponse")
public class CheckParcelValuesResponse {

	@XStreamAlias("Resposta")
	private ParcelValuesResponse response;
	
	public String getXML() {
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		return stream.toXML(this);
	}
	
	public ParcelValuesResponse getResponse() {
		return response;
	}
}
