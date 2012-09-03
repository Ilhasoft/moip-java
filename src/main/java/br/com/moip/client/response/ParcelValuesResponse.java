package br.com.moip.client.response;

import java.util.List;

import br.com.moip.client.query.ParcelValue;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ParcelValuesResponse extends BaseResponse {

	@XStreamImplicit(itemFieldName="ValorDaParcela")
    private List<ParcelValue> values;
	
	@XStreamImplicit(itemFieldName="Erro")
    private List<Error> errors;
	
	public List<ParcelValue> getValues() {
		return values;
	}
	
	public List<Error> getErrors() {
		return errors;
	}
}
