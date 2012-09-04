package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa o recebedor de um pagamento.
 * <br>XML: Elemento &lt;Recebedor&gt;
 *
 */
@XStreamAlias("Recebedor")
public class Receiver {

	@XStreamAlias("LoginMoIP")
	private String loginMoIP;

	@XStreamAlias("Apelido")
	private String nickname;

	/**
	 * Define o login Moip deste recebedor.
	 * <br>XML: Elemento &lt;LoginMoIP&gt;
	 * @param loginMoIP
	 * @return
	 */
	public Receiver withMoipLogin(final String loginMoIP) {
		this.loginMoIP = loginMoIP;
		return this;
	}

	/**
	 * Define o apelido deste recebedor.
	 * <br>XML: Elemento &lt;Apelido&gt;
	 * @param apelido
	 * @return
	 */
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
