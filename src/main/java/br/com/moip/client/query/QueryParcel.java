package br.com.moip.client.query;

import br.com.moip.client.exception.InstructionValidationException;

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
	
	public void validate() throws InstructionValidationException {
		String fields = "";
		if (this.getLogin() == null) fields += "Moip login,";
		if (this.getMaxParcel() == null) fields += "max parcels,";
		if (this.getInterest() == null) fields += "interest,";
		if (this.getValue() == null) fields += "value,";
		
		if (!"".equals(fields))
			throw new InstructionValidationException("You must inform: " + fields.substring(0, fields.length()-1));
	}
}
