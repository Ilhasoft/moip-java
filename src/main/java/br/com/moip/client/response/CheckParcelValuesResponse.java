package br.com.moip.client.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que modela a resposta de Consultar Parcelamento.
 *
 */
@XStreamAlias("ns1:ChecarValoresParcelamentoResponse")
public class CheckParcelValuesResponse {

	@XStreamAlias("Resposta")
	private ParcelValuesResponse response;
	
	/**
	 * Devolve o XML do qual esta resposta foi gerada.
	 * @return
	 */
	public String getXML() {
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		return stream.toXML(this);
	}
	
	/**
	 * Devolve a resposta do cálculo de parcelamento.
	 * @return
	 */
	public ParcelValuesResponse getResponse() {
		return response;
	}
	
	/**
	 * Método de conveniência que devolve true se o request foi bem-sucedido.
	 * @return
	 */
	public boolean isSuccessful() {
		return (this.response != null && this.response.isSuccessful());
	}
}
