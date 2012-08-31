package br.com.moip.client.query;

public class QueryParcel {

	private String login;
	private String maxParcel;
	private String interest;
	private String value;
	
	public QueryParcel(String login, String maxParcel, String interest,
			String value) {
		super();
		this.login = login;
		this.maxParcel = maxParcel;
		this.interest = interest;
		this.value = value;
	}

	public String getPath() {
		return "/ChecarValoresParcelamento";
	}
	
	public String getLogin() {
		return login;
	}

	public String getMaxParcel() {
		return maxParcel;
	}

	public String getInterest() {
		return interest;
	}

	public String getValue() {
		return value;
	}
	
}
