package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Pagador")
public class Payer {

    @XStreamAlias("Nome")
    private String nome;

    @XStreamAlias("LoginMoIP")
    private String loginMoIP;

    @XStreamAlias("Email")
    private String email;

    @XStreamAlias("TelefoneCelular")
    private String telefoneCelular;

    @XStreamAlias("Apelido")
    private String apelido;

    @XStreamAlias("Identidade")
    private String identidade;

    @XStreamAlias("EnderecoCobranca")
    private Address enderecoCobranca;

    @XStreamAlias("EnderecoEntrega")
    private Address enderecoEntrega;

    public static Payer payer() {
        return new Payer();
    }

    public Payer withName(final String nome) {
        this.nome = nome;
        return this;
    }

    public Payer withEmail(final String email) {
        this.email = email;
        return this;
    }

    public Payer withCellphone(final String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
        return this;
    }

    public Payer withNickname(final String apelido) {
        this.apelido = apelido;
        return this;
    }

    public Payer withIdentity(final String identidade) {
        this.identidade = identidade;
        return this;
    }

    public Payer withBillingAddress(final Address enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getLoginMoIP() {
        return loginMoIP;
    }

    public void setLoginMoIP(final String loginMoIP) {
        this.loginMoIP = loginMoIP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(final String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(final String apelido) {
        this.apelido = apelido;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(final String identidade) {
        this.identidade = identidade;
    }

    public Address getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(final Address enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public Address getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(final Address enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

}
