package br.com.moip.client.instruction;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("InstrucaoUnicaTransparente")
public class SingleInstructionTransparent extends SingleInstruction {

	@XStreamAsAttribute
	private final String TipoValidacao = "Transparente";
	
	public static SingleInstructionTransparent instrucaoUnicaTransparente() {
		return new SingleInstructionTransparent();
	}
	
	@Override
	public void validate() throws InstructionValidationException {
		
	}
}
