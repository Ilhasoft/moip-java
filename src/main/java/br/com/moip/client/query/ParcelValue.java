package br.com.moip.client.query;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("ValorDaParcela")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"parcel"})
public class ParcelValue {

	@XStreamAlias("Total")
	private String total;
	
	@XStreamAlias("Juros")
	private String interest;
	
	@XStreamAlias("Valor")
	private String value;
	
	private String parcel;

	public String getTotal() {
		return total;
	}

	public String getInterest() {
		return interest;
	}

	public String getValue() {
		return value;
	}

	public String getParcel() {
		return parcel;
	}

}
