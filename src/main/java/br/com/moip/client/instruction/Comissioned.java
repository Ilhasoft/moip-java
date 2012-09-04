package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa um comissionado.
 *
 */
@XStreamAlias("Comissionado")
public class Comissioned {

	@XStreamAlias("LoginMoIP")
	private String loginMoIP;

	/**
	 * Cria um comissionado com um login Moip.
	 * @param loginMoip
	 * @return
	 */
	public Comissioned comissioned(final String loginMoip) {
		this.loginMoIP = loginMoip;
		return this;
	}

	public String getLoginMoIP() {
		return loginMoIP;
	}

	/**
	 * Define o login Moip do comissionado.
	 * @param loginMoIP
	 */
	public void setLoginMoIP(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
	}

}
