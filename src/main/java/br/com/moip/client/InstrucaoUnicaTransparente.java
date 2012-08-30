package br.com.moip.client;

import br.com.moip.client.exception.InstrucaoValidationException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("InstrucaoUnicaTransparente")
public class InstrucaoUnicaTransparente extends InstrucaoUnica {

	@XStreamAsAttribute
	private final String TipoValidacao = "Transparente";
	
	public static InstrucaoUnicaTransparente instrucaoUnicaTransparente() {
		return new InstrucaoUnicaTransparente();
	}
	
	@Override
	public void validate() throws InstrucaoValidationException {
		
	}
}
