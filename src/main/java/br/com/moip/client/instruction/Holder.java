package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Portador")
public class Holder {

	@XStreamAlias("Nome")
	private String name;

	@XStreamAlias("Identidade")
	private String identity;

	@XStreamAsAttribute
	@XStreamAlias("Tipo")
	private String documentType = "CPF";

	@XStreamAlias("Telefone")
	private String phone;

	@XStreamAlias("DataNascimento")
	private String birthDate;

	public Holder withName(final String nome) {
		this.name = nome;
		return this;
	}

	public Holder withIdentity(final String identidade) {
		this.identity = identidade;
		return this;
	}

	public Holder withDocumentType(final String tipoDocumento) {
		this.documentType = tipoDocumento;
		return this;
	}

	public Holder withPhone(final String telefone) {
		this.phone = telefone;
		return this;
	}

	public Holder withBirthDate(final String dataNascimento) {
		this.birthDate = dataNascimento;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getIdentity() {
		return identity;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirthDate() {
		return birthDate;
	}

}
