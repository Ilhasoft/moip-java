package br.com.moip.client.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Erro")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class Error {

	@XStreamAsAttribute
	@XStreamAlias("Codigo")
	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
