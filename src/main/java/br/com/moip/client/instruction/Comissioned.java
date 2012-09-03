package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Comissionado")
public class Comissioned {

	@XStreamAlias("LoginMoIP")
	private String loginMoIP;

	public static Comissioned comissioned() {
		return new Comissioned();
	}

	public Comissioned comissioned(final String loginMoip) {
		this.loginMoIP = loginMoip;
		return this;
	}

	public String getLoginMoIP() {
		return loginMoIP;
	}

	public void setLoginMoIP(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
	}

}
