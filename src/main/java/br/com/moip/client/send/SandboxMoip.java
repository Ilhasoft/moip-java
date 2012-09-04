package br.com.moip.client.send;

/**
 * Enviador que manda os requests para o ambiente de Sandbox (testes) do Moip.
 *
 */
public class SandboxMoip extends SendToMoip {

	public SandboxMoip() {
	}

	/**
	 * Cria um enviador com token e chave definidos.
	 * @param token
	 * @param key
	 */
	public SandboxMoip(final String token, final String key) {
		super(token, key);
	}

	@Override
	public String getEnviroment() {
		return "https://desenvolvedor.moip.com.br/sandbox/ws/alpha";
	}

}
