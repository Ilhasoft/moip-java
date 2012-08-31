package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Recebedor")
public class Receiver {

	@XStreamAlias("LoginMoIP")
	private String loginMoIP;

	@XStreamAlias("Apelido")
	private String apelido;

	public static Receiver receiver() {
		return new Receiver();
	}

	public Receiver withMoipLogin(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
		return this;
	}

	public Receiver withNickname(final String apelido) {
		this.apelido = apelido;
		return this;
	}

	public String getLoginMoIP() {
		return loginMoIP;
	}

	public void setLoginMoIP(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(final String apelido) {
		this.apelido = apelido;
	}

}
