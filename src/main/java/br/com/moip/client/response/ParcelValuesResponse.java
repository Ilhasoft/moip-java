package br.com.moip.client.response;

import java.util.List;

import br.com.moip.client.query.ParcelValue;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Classe que representa a resposta do cálculo de parcelamento.
 *
 */
public class ParcelValuesResponse extends BaseResponse {

	@XStreamImplicit(itemFieldName="ValorDaParcela")
    private List<ParcelValue> values;
	
	@XStreamImplicit(itemFieldName="Erro")
    private List<Error> errors;
	
	/**
	 * Devolve a lista de opções de parcelamento, ou null se houveram erros.
	 * @return
	 */
	public List<ParcelValue> getValues() {
		return values;
	}
	
	/**
	 * Devolve a lista de erros, ou null se não houveram.
	 * @return
	 */
	public List<Error> getErrors() {
		return errors;
	}
}
