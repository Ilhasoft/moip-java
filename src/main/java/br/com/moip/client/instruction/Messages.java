package br.com.moip.client.instruction;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Mensagem")
public class Messages {

	@XStreamImplicit(itemFieldName = "Mensagem")
	@XStreamAlias("Mensagem")
	private List<String> mensagens;

	public static Messages messages() {
		return new Messages();
	}

	public Messages addMessage(final String mensagem) {

		if (this.mensagens == null) {
			this.mensagens = new ArrayList<String>();
		}
		mensagens.add(mensagem);
		return this;
	}

}
