package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Recebedor")
public class Receiver {

	@XStreamAlias("LoginMoIP")
	private String loginMoIP;

	@XStreamAlias("Apelido")
	private String nickname;

	public static Receiver receiver() {
		return new Receiver();
	}

	public Receiver withMoipLogin(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
		return this;
	}

	public Receiver withNickname(final String apelido) {
		this.nickname = apelido;
		return this;
	}

	public String getLoginMoIP() {
		return loginMoIP;
	}

	public String getNickname() {
		return nickname;
	}

}
