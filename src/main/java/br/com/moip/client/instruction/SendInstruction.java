package br.com.moip.client.instruction;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("EnviarInstrucao")
public class SendInstruction {

	@XStreamAlias("InstrucaoUnica")
	private SingleInstruction singleInstruction;

	public SingleInstruction instrucaoUnica() {
		if (this.singleInstruction == null) {
			this.singleInstruction = new SingleInstruction();
		}
		return this.singleInstruction;
	}

	public SendInstruction withSingleInstruction(final SingleInstruction instrucaoUnica) {
		this.singleInstruction = instrucaoUnica;
		return this;
	}
	
	public SingleInstruction getSingleInstruction() {
		return singleInstruction;
	}

	public void validate() throws InstructionValidationException {
		this.singleInstruction.validate();
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
