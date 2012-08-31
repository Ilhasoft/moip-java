package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Portador")
public class Holder {

	@XStreamAlias("Nome")
	private String nome;

	@XStreamAlias("Identidade")
	private String identidade;

	@XStreamAsAttribute
	@XStreamAlias("Tipo")
	private String tipoDocumento = "CPF";

	@XStreamAlias("Telefone")
	private String telefone;

	@XStreamAlias("DataNascimento")
	private String dataNascimento;

	public static Holder holder() {
		return new Holder();
	}

	public Holder withName(final String nome) {
		this.nome = nome;
		return this;
	}

	public Holder withIdentity(final String identidade) {
		this.identidade = identidade;
		return this;
	}

	public Holder withDocumentType(final String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
		return this;
	}

	public Holder withPhone(final String telefone) {
		this.telefone = telefone;
		return this;
	}

	public Holder withBirthDate(final String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(final String identidade) {
		this.identidade = identidade;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(final String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
