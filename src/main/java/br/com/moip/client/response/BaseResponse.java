package br.com.moip.client.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class BaseResponse {

	@XStreamAlias("ID")
	protected String id;
	@XStreamAlias("Status")
	protected String status;

	public BaseResponse() {
		super();
	}

	public String getId() {
	    return id;
	}

	public String getStatus() {
	    return status;
	}

	public boolean isSuccessful() {
		return "SUCESSO".equalsIgnoreCase(this.status);
	}
}