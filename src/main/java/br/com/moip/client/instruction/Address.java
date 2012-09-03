package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Endereco")
public class Address {

    @XStreamAlias("Logradouro")
    private String address;

    @XStreamAlias("Numero")
    private String number;

    @XStreamAlias("Complemento")
    private String complement;

    @XStreamAlias("Bairro")
    private String neighborhood;

    @XStreamAlias("Cidade")
    private String city;

    @XStreamAlias("Estado")
    private String state;

    @XStreamAlias("Pais")
    private String country;

    @XStreamAlias("CEP")
    private String zipCode;

    @XStreamAlias("TelefoneFixo")
    private String phone;

    public Address withAddress(final String logradouro) {
        this.address = logradouro;
        return this;
    }

    public Address withNumber(final String numero) {
        this.number = numero;
        return this;
    }

    public Address withComplement(final String complemento) {
        this.complement = complemento;
        return this;
    }

    public Address withNeighborhood(final String bairro) {
        this.neighborhood = bairro;
        return this;
    }

    public Address withCity(final String cidade) {
        this.city = cidade;
        return this;
    }

    public Address withState(final String estado) {
        this.state = estado;
        return this;
    }

    public Address withCountry(final String pais) {
        this.country = pais;
        return this;
    }

    public Address withZipCode(final String cep) {
        this.zipCode = cep;
        return this;
    }

    public Address withPhone(final String telefoneFixo) {
        this.phone = telefoneFixo;
        return this;
    }

	public String getAddress() {
		return address;
	}

	public String getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPhone() {
		return phone;
	}
    
}
