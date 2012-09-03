package br.com.moip.client;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.moip.client.exception.InstructionValidationException;
import br.com.moip.client.instruction.SendInstruction;
import br.com.moip.client.instruction.SingleInstruction;
import br.com.moip.client.instruction.Values;
import br.com.moip.client.send.SandboxMoip;

public class SingleInstructionTest {

	private SandboxMoip sandboxMoip;
	
	@Before
	public void setup() {
		sandboxMoip = new SandboxMoip("01010101010101010101010101010101",
				"ABABABABABABABABABABABABABABABABABABABAB");
	}
	
	@Test(expected = InstructionValidationException.class)
	public void shouldNotSendInstructionWithoutRequiredFields() {
		SendInstruction instruction = new SendInstruction().withSingleInstruction(
				new SingleInstruction());
		sandboxMoip.send(instruction);
	}
	
	@Test(expected = InstructionValidationException.class)
	public void shouldNotSendTransparentInstructionWithoutRequiredFields() {
		SendInstruction instruction = new SendInstruction().withSingleInstruction(
				new SingleInstruction()
				.withUniqueId("test" + new Date().getTime())
				.withReason("razão social")
				.with(new Values().withValue("12.34").withCurrency("BRL"))
				.withTransparentValidation());
		sandboxMoip.send(instruction);
	}
}
