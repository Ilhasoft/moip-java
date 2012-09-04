package br.com.moip.client.instruction;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe usada para o envio de instruções.
 *
 */
@XStreamAlias("EnviarInstrucao")
public class SendInstruction {

	@XStreamAlias("InstrucaoUnica")
	private SingleInstruction singleInstruction;

	/**
	 * Define a instrução única a ser enviada com esta instrução.
	 * @param instrucaoUnica
	 * @return
	 */
	public SendInstruction withSingleInstruction(final SingleInstruction instrucaoUnica) {
		this.singleInstruction = instrucaoUnica;
		return this;
	}
	
	public SingleInstruction getSingleInstruction() {
		return singleInstruction;
	}

	/**
	 * Valida esta instrução, lançando uma exceção que lista os campos faltantes.
	 * Esta validação sempre é invocada antes da instrução ser enviada.
	 * @throws InstructionValidationException
	 */
	public void validate() throws InstructionValidationException {
		this.singleInstruction.validate();
	}
	
	/**
	 * Devolve o XML que esta instrução gera. 
	 * @return
	 */
	public String getXML() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(this);		
	}
	
	/**
	 * Devolve o caminho para onde esta instrução será mandada no Moip.
	 * @return
	 */
	public String getPath() {
		return "/EnviarInstrucao/Unica";
	}
	
	@Override
	public String toString() {
		return this.getXML();
	}
}
