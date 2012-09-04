package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Representa um endereço, tanto de cobrança quanto de entrega.
 *
 */
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

    /**
     * Define a rua deste endereço.
     * @param logradouro
     * @return
     */
    public Address withAddress(final String logradouro) {
        this.address = logradouro;
        return this;
    }

    /**
     * Define o número deste endereço.
     * @param numero
     * @return
     */
    public Address withNumber(final String numero) {
        this.number = numero;
        return this;
    }

    /**
     * Define o complemento deste endereço.
     * @param complemento
     * @return
     */
    public Address withComplement(final String complemento) {
        this.complement = complemento;
        return this;
    }

    /**
     * Define o bairro deste endereço.
     * @param bairro
     * @return
     */
    public Address withNeighborhood(final String bairro) {
        this.neighborhood = bairro;
        return this;
    }

    /**
     * Define a cidade deste endereço.
     * @param cidade
     * @return
     */
    public Address withCity(final String cidade) {
        this.city = cidade;
        return this;
    }

    /**
     * Define o estado deste endereço.
     * @param estado
     * @return
     */
    public Address withState(final String estado) {
        this.state = estado;
        return this;
    }

    /**
     * Define o país deste endereço.
     * @param pais
     * @return
     */
    public Address withCountry(final String pais) {
        this.country = pais;
        return this;
    }

    /**
     * Define o CEP deste endereço.
     * @param cep
     * @return
     */
    public Address withZipCode(final String cep) {
        this.zipCode = cep;
        return this;
    }

    /**
     * Define o telefone fixo deste endereço.
     * @param telefoneFixo
     * @return
     */
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
