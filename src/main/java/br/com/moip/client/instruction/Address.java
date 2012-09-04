package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Representa um endereço, tanto de cobrança quanto de entrega.
 * <br>XML: Elemento &lt;Endereco&gt;
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
     * <br>XML: Elemento &lt;Logradouro&gt;
     * @param logradouro
     * @return
     */
    public Address withAddress(final String logradouro) {
        this.address = logradouro;
        return this;
    }

    /**
     * Define o número deste endereço.
     * <br>XML: Elemento &lt;Numero&gt;
     * @param numero
     * @return
     */
    public Address withNumber(final String numero) {
        this.number = numero;
        return this;
    }

    /**
     * Define o complemento deste endereço.
     * <br>XML: Elemento &lt;Complemento&gt;
     * @param complemento
     * @return
     */
    public Address withComplement(final String complemento) {
        this.complement = complemento;
        return this;
    }

    /**
     * Define o bairro deste endereço.
     * <br>XML: Elemento &lt;Bairro&gt;
     * @param bairro
     * @return
     */
    public Address withNeighborhood(final String bairro) {
        this.neighborhood = bairro;
        return this;
    }

    /**
     * Define a cidade deste endereço.
     * <br>XML: Elemento &lt;Cidade&gt;
     * @param cidade
     * @return
     */
    public Address withCity(final String cidade) {
        this.city = cidade;
        return this;
    }

    /**
     * Define o estado deste endereço.
     * <br>XML: Elemento &lt;Estado&gt;
     * @param estado
     * @return
     */
    public Address withState(final String estado) {
        this.state = estado;
        return this;
    }

    /**
     * Define o país deste endereço.
     * <br>XML: Elemento &lt;Pais&gt;
     * @param pais
     * @return
     */
    public Address withCountry(final String pais) {
        this.country = pais;
        return this;
    }

    /**
     * Define o CEP deste endereço.
     * <br>XML: Elemento &lt;CEP&gt;
     * @param cep
     * @return
     */
    public Address withZipCode(final String cep) {
        this.zipCode = cep;
        return this;
    }

    /**
     * Define o telefone fixo deste endereço.
     * <br>XML: Elemento &lt;TelefoneFixo&gt;
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
