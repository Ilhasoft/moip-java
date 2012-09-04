package br.com.moip.client.send;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import br.com.moip.client.exception.MoipClientException;
import br.com.moip.client.instruction.SendInstruction;
import br.com.moip.client.query.QueryParcel;
import br.com.moip.client.response.CheckParcelValuesResponse;
import br.com.moip.client.response.SendSingleInstructionResponse;

import com.thoughtworks.xstream.XStream;

/**
 * Classe que possui as funcionalidades para enviar os requests para o Moip e abstrair os parâmetros
 * e os retornos.
 *
 */
public abstract class SendToMoip {

	private String token;

	private String key;

	public SendToMoip() {
	}

	/**
	 * Cria um enviador com token e chave definidos.
	 * @param token
	 * @param key
	 */
	public SendToMoip(final String token, final String key) {
		this.token = token;
		this.key = key;
	}

	/**
	 * Define para qual ambiente os requests serão enviados.
	 * @return
	 */
	public abstract String getEnviroment();

	/**
	 * Define o token usado na autenticação.
	 * @param token
	 * @return
	 */
	public SendToMoip withToken(final String token) {
		this.token = token;
		return this;
	}

	/**
	 * Define a chave usada na autenticação.
	 * @param key
	 * @return
	 */
	public SendToMoip withKey(final String key) {
		this.key = key;
		return this;
	}

	/**
	 * Envia uma instrução para o ambiente definido por este enviador.
	 * @param enviarInstrucao instrução a ser enviada.
	 * @return SendSingleInstructionResponse com os dados da resposta do Moip
	 * @throws MoipClientException mediante algum problema na comunicação com o Moip.
	 */
	public SendSingleInstructionResponse send(
			final SendInstruction enviarInstrucao) {
		enviarInstrucao.validate();
		
		HttpClient client = new HttpClient();
		
		PostMethod post = new PostMethod(getEnviroment() + enviarInstrucao.getPath());

		createAuthHeader(post);

		String body = enviarInstrucao.getXML();

		int status = 200;
		try {

			RequestEntity requestEntity = new StringRequestEntity(body,
					"application/x-www-formurlencoded", "UTF-8");
			post.setRequestEntity(requestEntity);

			status = client.executeMethod(post);

			XStream xstream = new XStream();
			xstream.processAnnotations(SendSingleInstructionResponse.class);

			return (SendSingleInstructionResponse) xstream.fromXML(post
					.getResponseBodyAsString());
		} catch (Exception e) {

			throw new MoipClientException(status, e);
		} finally {
			post.releaseConnection();
		}
	}

	/**
	 * Envia uma consulta de parcelamento para o ambiente definido por este enviador.
	 * @param query consulta a ser enviada.
	 * @return CheckParcelValuesResponse com os dados da resposta do Moip
	 * @throws MoipClientException mediante algum problema na comunicação com o Moip.
	 */
	public CheckParcelValuesResponse send (QueryParcel query) {
		query.validate();
		
		HttpClient client = new HttpClient();
		
		String url = getEnviroment() + query.getPath() + "/" + query.getLogin() 
				+ "/" + query.getMaxParcel() + "/" + query.getInterest() + "/" + query.getValue();
		
		GetMethod get = new GetMethod(url);

		createAuthHeader(get);

		int status = 200;
		try {
			status = client.executeMethod(get);
			
			XStream xstream = new XStream();
			xstream.processAnnotations(CheckParcelValuesResponse.class);
			
			return (CheckParcelValuesResponse) xstream.fromXML(get
					.getResponseBodyAsString());
		} catch (Exception e) {

			throw new MoipClientException(status, e);
		} finally {
			get.releaseConnection();
		}
	}
	
	/**
	 * Cria o header de autorização para o método passado como parâmetro.
	 * @param method
	 */
	private void createAuthHeader(HttpMethod method) {
		String authHeader = token + ":" + key;
		String hash = new String(Base64.encodeBase64(authHeader.getBytes()));
		String encoded = "Basic " + hash;

		method.setRequestHeader("Authorization", encoded);
		method.setDoAuthentication(true);
	}

}
