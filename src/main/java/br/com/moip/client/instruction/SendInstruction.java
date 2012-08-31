package br.com.moip.client.instruction;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("EnviarInstrucao")
public class SendInstruction {

	@XStreamAlias("InstrucaoUnica")
	private SingleInstruction instrucaoUnica;

	public SingleInstruction instrucaoUnica() {
		if (this.instrucaoUnica == null) {
			this.instrucaoUnica = new SingleInstruction();
		}
		return this.instrucaoUnica;
	}

	public SendInstruction withSingleInstruction(final SingleInstruction instrucaoUnica) {
		this.instrucaoUnica = instrucaoUnica;
		return this;
	}

	public SingleInstruction getInstrucaoUnica() {
		return instrucaoUnica;
	}

	public void setInstrucaoUnica(final SingleInstruction instrucaoUnica) {
		this.instrucaoUnica = instrucaoUnica;
	}

	public void validate() throws InstructionValidationException {
		this.instrucaoUnica.validate();
	}
	
	public String getXML() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(this);		
	}
	
	public String getPath() {
		return "/EnviarInstrucao/Unica";
	}
	
	@Override
	public String toString() {
		return this.getXML();
	}
}
