package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa um pagador.
 * <br>XML: Elemento &lt;Pagador&gt;
 *
 */
@XStreamAlias("Pagador")
public class Payer {

    @XStreamAlias("Nome")
    private String name;

    @XStreamAlias("Email")
    private String email;

    @XStreamAlias("IdPagador")
    private String payerID;
    
    @XStreamAlias("TelefoneCelular")
    private String cellphone;

    @XStreamAlias("Apelido")
    private String nickname;

    @XStreamAlias("Identidade")
    private String identity;

    @XStreamAlias("EnderecoCobranca")
    private Address billingAddress;

    @XStreamAlias("EnderecoEntrega")
    private Address deliveryAddress;

    /**
     * Define o nome deste pagador.
     * <br>XML: Elemento &lt;Nome&gt;
     * @param nome
     * @return
     */
    public Payer withName(final String nome) {
        this.name = nome;
        return this;
    }

    /**
     * Define o email deste pagador.
     * <br>XML: Elemento &lt;Email&gt;
     * @param email
     * @return
     */
    public Payer withEmail(final String email) {
        this.email = email;
        return this;
    }

    /**
     * Define o telefone celular deste pagador.
     * <br>XML: Elemento &lt;TelefoneCelular&gt;
     * @param telefoneCelular
     * @return
     */
    public Payer withCellphone(final String telefoneCelular) {
        this.cellphone = telefoneCelular;
        return this;
    }

    /**
     * Define o apelido deste pagador.
     * <br>XML: Elemento &lt;Apelido&gt;
     * @param apelido
     * @return
     */
    public Payer withNickname(final String apelido) {
        this.nickname = apelido;
        return this;
    }

    /**
     * Define a identidade (CPF) deste pagador.
     * <br>XML: Elemento &lt;Identidade&gt;
     * @param identidade
     * @return
     */
    public Payer withIdentity(final String identidade) {
        this.identity = identidade;
        return this;
    }

    /**
     * Define o endereço de cobrança deste pagador.
     * <br>XML: Elemento &lt;EnderecoCobranca&gt;
     * @param enderecoCobranca
     * @return
     */
    public Payer withBillingAddress(final Address enderecoCobranca) {
        this.billingAddress = enderecoCobranca;
        return this;
    }

    /**
     * Define o ID do pagador.
     * <br>XML: Elemento &lt;IdPagador&gt;
     * @param payerID
     * @return
     */
    public Payer withPayerID(final String payerID) {
        this.payerID = payerID;
        return this;
    }

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPayerID() {
		return payerID;
	}

	public String getCellphone() {
		return cellphone;
	}

	public String getNickname() {
		return nickname;
	}

	public String getIdentity() {
		return identity;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
    
}
