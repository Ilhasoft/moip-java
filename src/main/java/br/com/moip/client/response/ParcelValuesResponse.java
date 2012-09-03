package br.com.moip.client.response;

import java.util.List;

import br.com.moip.client.query.ParcelValue;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ParcelValuesResponse extends BaseResponse {

	@XStreamImplicit(itemFieldName="ValorDaParcela")
    private List<ParcelValue> valores;
	
	public List<ParcelValue> getValores() {
		return valores;
	}
}
