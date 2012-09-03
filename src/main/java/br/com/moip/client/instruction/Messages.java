package br.com.moip.client.instruction;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Mensagem")
public class Messages {

	@XStreamImplicit(itemFieldName = "Mensagem")
	@XStreamAlias("Mensagem")
	private List<String> messages;

	public Messages addMessage(final String mensagem) {

		if (this.messages == null) {
			this.messages = new ArrayList<String>();
		}
		messages.add(mensagem);
		return this;
	}

}
