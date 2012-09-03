package br.com.moip.client;
import br.com.moip.client.instruction.Address;
import br.com.moip.client.instruction.Billet;
import br.com.moip.client.instruction.Comissioned;
import br.com.moip.client.instruction.Comissioning;
import br.com.moip.client.instruction.Parcel;
import br.com.moip.client.instruction.Payer;
import br.com.moip.client.instruction.Receiver;
import br.com.moip.client.instruction.SendInstruction;
import br.com.moip.client.instruction.SingleInstruction;
import br.com.moip.client.instruction.Values;
import br.com.moip.client.response.SendSingleInstructionResponse;
import br.com.moip.client.send.SandboxMoip;

public class Teste {

	public static void main(String[] args) {

		SendInstruction enviarInstrucao = new SendInstruction()
				.withSingleInstruction(new SingleInstruction()
						.withTransparentValidation()
						.withReason("Uma motivo pela compra")
						.withUniqueId("teste2")
						.with(new Payer()
								.withName("Breno Oliveira")
								.withEmail("breno26@gmail.com")
								.withPayerID("BRENOID")
								.withIdentity("222.222.222-22")
								.withCellphone("(61)9999-9999")
								.withBillingAddress(
										new Address()
												.withAddress("Rua Vergueiro")
												.withNumber("853")
												.withNeighborhood("Vila Mariano")
												.withZipCode("04600-021")
												.withCity("Sao Paulo")
												.withState("SP")
												.withCountry("BRA")
												.withPhone(
														"(22)2222-2222")
												)
								)
						.with(new Billet().withDaysToExpire("5"))
						.with(new Values().withValue("15.00"))
						.with(new Receiver().withMoipLogin("teste").withNickname("tt"))
						.with(new Comissioning()
										.withComissioned(
												new Comissioned().comissioned(
														"likestore"))
										.withPercentValue("2")
										.withFixedValue("0.39")
										.withReason("Percentual LikeStore")
								)
						.with(new Comissioning()
										.withComissioned(
												new Comissioned().comissioned(
														"febpetroni"))
										.withPercentValue("6")
										.withFixedValue("0.93")
										.withReason("Cacildis"))
						.with(new Parcel()
								.withMinimumParcels("1")
								.withMaximumParcels("3")
								.withInterest("1.0")
								.withReceptionType("AVista")
								.withTransfer("true")
						)
						.with(new Parcel()
								.withMinimumParcels("4")
								.withMaximumParcels("6")
								.withInterest("2.0")
								.withReceptionType("AVista")
								.withTransfer("false"))
						.withNotificationURL("http://meu.site.com/nasp")
						.withReturnURL("http://meu.site.com/retorno")
						);

		System.out.println(enviarInstrucao.getXML());

		System.out.println("--------------------------------");
		
		 SendSingleInstructionResponse response = new SandboxMoip()
		 	.withToken("01010101010101010101010101010101")
		 	.withKey("ABABABABABABABABABABABABABABABABABABABAB").send(enviarInstrucao);
		
		 System.out.println(response);
	}
}
