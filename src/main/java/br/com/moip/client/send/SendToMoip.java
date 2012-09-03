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

public abstract class SendToMoip {

	private String token;

	private String key;

	private String hash;

	public SendToMoip() {
	}

	public SendToMoip(final String token, final String key) {
		this.token = token;
		this.key = key;
	}

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
	
	private void createAuthHeader(HttpMethod method) {
		String authHeader = token + ":" + key;
		String hash = this.hash;
		if (!hasHash()) {
			hash = new String(Base64.encodeBase64(authHeader.getBytes()));
		}
		String encoded = "Basic " + hash;

		method.setRequestHeader("Authorization", encoded);
		method.setDoAuthentication(true);
	}

	public abstract String getEnviroment();

	private boolean hasHash() {
		return hash != null && !"".equals(hash);
	}

	public SendToMoip withToken(final String token) {
		this.token = token;
		return this;
	}

	public SendToMoip withKey(final String key) {
		this.key = key;
		return this;
	}

	public SendToMoip withHash(final String hash) {
		this.hash = hash;
		return this;
	}

}
