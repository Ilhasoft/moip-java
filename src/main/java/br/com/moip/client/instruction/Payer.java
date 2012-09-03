package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

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

    public Payer withName(final String nome) {
        this.name = nome;
        return this;
    }

    public Payer withEmail(final String email) {
        this.email = email;
        return this;
    }

    public Payer withCellphone(final String telefoneCelular) {
        this.cellphone = telefoneCelular;
        return this;
    }

    public Payer withNickname(final String apelido) {
        this.nickname = apelido;
        return this;
    }

    public Payer withIdentity(final String identidade) {
        this.identity = identidade;
        return this;
    }

    public Payer withBillingAddress(final Address enderecoCobranca) {
        this.billingAddress = enderecoCobranca;
        return this;
    }

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
