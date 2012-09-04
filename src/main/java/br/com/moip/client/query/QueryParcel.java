package br.com.moip.client.query;

import br.com.moip.client.exception.InstructionValidationException;

/**
 * Classe usada para efetuar uma consulta de parcelamento no Moip.
 *
 */
public class QueryParcel {

	private String login;
	private String maxParcel;
	private String interest;
	private String value;
	
	/**
	 * Cria uma consulta com o login Moip, máximo de parcelas, juros e valor informados.
	 * Todos os campos são obrigatórios.
	 * @param login
	 * @param maxParcel
	 * @param interest
	 * @param value
	 */
	public QueryParcel(String login, String maxParcel, String interest,
			String value) {
		super();
		this.login = login;
		this.maxParcel = maxParcel;
		this.interest = interest;
		this.value = value;
	}

	/**
	 * Valida esta consulta, lançando uma exceção que lista os campos faltantes.
	 * Esta validação sempre é invocada antes da instrução ser enviada.
	 * @throws InstructionValidationException
	 */
	public void validate() throws InstructionValidationException {
		String fields = "";
		if (this.getLogin() == null) fields += "Moip login,";
		if (this.getMaxParcel() == null) fields += "max parcels,";
		if (this.getInterest() == null) fields += "interest,";
		if (this.getValue() == null) fields += "value,";
		
		if (!"".equals(fields))
			throw new InstructionValidationException("You must inform: " + fields.substring(0, fields.length()-1));
	}
	
	/**
	 * Devolve o caminho para onde esta instrução será mandada no Moip.
	 * @return
	 */
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
