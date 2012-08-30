package br.com.moip.client;

import br.com.moip.client.exception.InstrucaoValidationException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("EnviarInstrucao")
public class EnviarInstrucao {

	@XStreamAlias("InstrucaoUnica")
	private InstrucaoUnica instrucaoUnica;

	public InstrucaoUnica instrucaoUnica() {
		if (this.instrucaoUnica == null) {
			this.instrucaoUnica = new InstrucaoUnica();
		}
		return this.instrucaoUnica;
	}

	public EnviarInstrucao comInstrucaoUnica(final InstrucaoUnica instrucaoUnica) {
		this.instrucaoUnica = instrucaoUnica;
		return this;
	}

	public InstrucaoUnica getInstrucaoUnica() {
		return instrucaoUnica;
	}

	public void setInstrucaoUnica(final InstrucaoUnica instrucaoUnica) {
		this.instrucaoUnica = instrucaoUnica;
	}

	public void validate() throws InstrucaoValidationException {
		this.instrucaoUnica.validate();
	}
	
	public String getXML() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(this);		
	}
	
	@Override
	public String toString() {
		return this.getXML();
	}
}
