package br.com.moip.client.send;

/**
 * Enviador que manda os requests para o ambiente de produção do Moip.
 *
 */
public class ProductionMoip extends SendToMoip {

	public ProductionMoip() {
	}

	/**
	 * Cria um enviador com token e chave definidos.
	 * @param token
	 * @param key
	 */
	public ProductionMoip(final String token, final String key) {
		super(token, key);
	}

	@Override
	public String getEnviroment() {
		return "https://www.moip.com.br/ws/alpha";
	}

}
