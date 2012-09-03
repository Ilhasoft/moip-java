package br.com.moip.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.moip.client.exception.InstructionValidationException;
import br.com.moip.client.query.QueryParcel;
import br.com.moip.client.response.CheckParcelValuesResponse;
import br.com.moip.client.send.SandboxMoip;

public class CheckQueryParcelValuesTest {

private SandboxMoip sandboxMoip;
	
	@Before
	public void setup() {
		sandboxMoip = new SandboxMoip("01010101010101010101010101010101",
				"ABABABABABABABABABABABABABABABABABABABAB");
	}
	
	@Test(expected = InstructionValidationException.class)
	public void shouldNotSendInstructionWithoutRequiredFields() {
		QueryParcel query = new QueryParcel(null, null, null, null);
		sandboxMoip.send(query);
	}
	
	@Test
	public void shouldFailForUnknownMoipLogin() {
		QueryParcel query = new QueryParcel("ISIFEHP98FH3AO8N3X8YBO82", "12", "1.99", "100.00");
		CheckParcelValuesResponse response = sandboxMoip.send(query);
		
		Assert.assertFalse(response.isSuccessful());
		Assert.assertNull(response.getResponse().getValues());
	}
	
	@Test
	public void shouldSucceedForValidMoipLogin() {
		QueryParcel query = new QueryParcel("integracao@labs.moip.com.br", "12", "1.99", "100.00");
		CheckParcelValuesResponse response = sandboxMoip.send(query);
		
		Assert.assertTrue(response.isSuccessful());
		Assert.assertTrue(response.getResponse().getValues().size() != 0);
	}
}
