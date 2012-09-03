import static br.com.moip.client.instruction.SingleInstruction.singleInstruction;
import br.com.moip.client.instruction.Address;
import br.com.moip.client.instruction.Comissioned;
import br.com.moip.client.instruction.Comissioning;
import br.com.moip.client.instruction.Parcel;
import br.com.moip.client.instruction.Payer;
import br.com.moip.client.instruction.Receiver;
import br.com.moip.client.instruction.SendInstruction;
import br.com.moip.client.instruction.Values;
import br.com.moip.client.response.SendSingleInstructionResponse;
import br.com.moip.client.send.SandboxMoip;

public class Test {

	public static void main(final String[] args) {

		SendInstruction enviarInstrucao = new SendInstruction()
				.withSingleInstruction(singleInstruction()
						.withTransparentValidation()
						.withReason("Uma motivo pela compra")
						.withUniqueId("teste2")
						.with(Payer.payer()
								.withName("Breno Oliveira")
								.withEmail("breno26@gmail.com")
								.withPayerID("BRENOID")
//								.withIdentity("222.222.222-22")
//								.withCellphone("(61)9999-9999")
								.withBillingAddress(
										Address.billingAdress()
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
//						.with(billet().withDaysToExpire("5"))
						.with(Values.values().withValue("15.00"))
						.with(Receiver.receiver().withMoipLogin("teste").withNickname("tt"))
						.with(Comissioning.comissioning()
										.withComissioned(
												Comissioned.comissioned().comissioned(
														"likestore"))
										.withPercentValue("2")
										.withFixedValue("0.39")
										.withReason("Percentual LikeStore")
								)
//						.with(commissioning()
//										.withCommissioned(
//												commissioned().comissioned(
//														"febpetroni"))
//										.withPercentValue("6")
//										.withFixedValue("0.93")
//										.withReason("Cacildis"))
						.with(Parcel.parcel()
								.withMinimumParcels("1")
								.withMaximumParcels("3")
								.withInterest("1.0")
								.withReceptionType("AVista")
								.withTransfer("true")
						)
//						.with(parcel()
//								.withMinimumParcels("4")
//								.withMaximumParcels("6")
//								.withInterest("2.0")
//								.withReceptionType("AVista")
//								.withTransfer("false"))
						.withNotificationURL("http://meu.site.com/nasp")
						.withReturnURL("http://meu.site.com/retorno")
						);

		enviarInstrucao.validate();
		System.out.println(enviarInstrucao.getXML());

		System.out.println("--------------------------------");
		
		 SendSingleInstructionResponse response = new SandboxMoip()
		 	.withToken("AVINJJDLJ6OOJOLR1ZUE3CZXISIE0JIH")
		 	.withKey("QLP9LUVYJ7Q5TQCV3T7LFB4AOXUDM5Z7MZJNTEFJ").send(enviarInstrucao);
		
		 System.out.println(response);
		 
//		CheckParcelValuesResponse response = new SandboxMoip()
//		 	.withToken("AVINJJDLJ6OOJOLR1ZUE3CZXISIE0JIH")
//		 	.withKey("QLP9LUVYJ7Q5TQCV3T7LFB4AOXUDM5Z7MZJNTEFJ").send(
//	 			new QueryParcel("febpetroni", "12", "1.99", "120.00"));
//	 	
//		System.out.println(response.getXML());
	}
}
