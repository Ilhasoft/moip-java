package br.com.moip.client.instruction;

import java.util.ArrayList;
import java.util.List;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("InstrucaoUnica")
public class SingleInstruction {

	@XStreamAsAttribute
	@XStreamAlias("TipoValidacao")
	private String validationType;
	
	@XStreamAlias("Razao")
	private String reason;

	@XStreamAlias("IdProprio")
	private String uniqueId;

	@XStreamAlias("Pagador")
	private Payer payer;

	@XStreamAlias("PagamentoDireto")
	private DirectPayment directPayment;

	@XStreamAlias("Boleto")
	private Billet billet;

	@XStreamAlias("Valores")
	private Values values;

	@XStreamAlias("URLNotificacao")
	private String notificationURL;

	@XStreamAlias("URLRetorno")
	private String returnURL;

	@XStreamAlias("Mensagens")
	private Messages messages;

	@XStreamAlias("Recebedor")
	private Receiver receiver;

	@XStreamAlias("Comissoes")
	private List<Comissioning> comissions;
	
	@XStreamAlias("Parcelamentos")
	private List<Parcel> parcels;

	public static SingleInstruction singleInstruction() {
		return new SingleInstruction();
	}

	public SingleInstruction withTransparentValidation() {
		this.validationType = "Transparente";
		return this;
	}
	
	public SingleInstruction withReason(final String razao) {
		this.reason = razao;
		return this;
	}

	public SingleInstruction withUniqueId(final String id) {
		this.uniqueId = id;
		return this;
	}

	public SingleInstruction with(final DirectPayment pagamentoDireto) {
		this.directPayment = pagamentoDireto;
		return this;
	}

	public SingleInstruction with(final Payer pagador) {
		this.payer = pagador;
		return this;
	}

	public SingleInstruction with(final Billet boleto) {
		this.billet = boleto;
		return this;
	}

	public SingleInstruction with(final Values valores) {
		this.values = valores;
		return this;
	}

	public SingleInstruction with(final Messages mensagens) {
		this.messages = mensagens;
		return this;
	}

	public SingleInstruction with(final Receiver recebedor) {
		this.receiver = recebedor;
		return this;
	}

	public SingleInstruction with(Comissioning comissionamento) {
		if (this.comissions == null)
			this.comissions = new ArrayList<Comissioning>();
		this.comissions.add(comissionamento);
		return this;
	}
	
	public SingleInstruction with(Parcel parcelamento) {
		if (this.parcels == null)
			this.parcels = new ArrayList<Parcel>();
		this.parcels.add(parcelamento);
		return this;
	}
	
	public Payer payer() {
		if (payer == null) {
			payer = new Payer();
		}
		return payer;
	}

	public DirectPayment directPayment() {
		if (directPayment == null) {
			directPayment = new DirectPayment();
		}
		return directPayment;
	}

	public Billet billet() {
		if (billet == null) {
			billet = new Billet();
		}
		return billet;
	}

	public Values values() {
		if (values == null) {
			values = new Values();
		}
		return values;
	}

	public Receiver receiver() {
		if (receiver == null) {
			receiver = new Receiver();
		}
		return receiver;
	}

	public SingleInstruction withNotificationURL(final String urlNotificacao) {
		this.notificationURL = urlNotificacao;
		return this;
	}

	public SingleInstruction withReturnURL(final String urlRetorno) {
		this.returnURL = urlRetorno;
		return this;
	}

	public String getValidationType() {
		return validationType;
	}

	public String getReason() {
		return reason;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public Payer getPayer() {
		return payer;
	}

	public DirectPayment getDirectPayment() {
		return directPayment;
	}

	public Billet getBillet() {
		return billet;
	}

	public Values getValues() {
		return values;
	}

	public String getNotificationURL() {
		return notificationURL;
	}

	public String getReturnURL() {
		return returnURL;
	}

	public Messages getMessages() {
		return messages;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public List<Comissioning> getComissions() {
		return comissions;
	}

	public List<Parcel> getParcels() {
		return parcels;
	}

	public void validate() throws InstructionValidationException {
		String fields = "";
		if (this.getUniqueId() == null) fields += "uniqueID,";
		if (this.getReason() == null) fields += "reason,";
		if (this.getValues() == null) fields += "value,";
		
		if ("Transparente".equals(this.validationType))
			fields += this.validateTransparent();
		
		if (!"".equals(fields))
			throw new InstructionValidationException("You must inform: " + fields.substring(0, fields.length()-1));
		
	}

	private String validateTransparent() {
		String fields = "";
		if (this.getPayer() == null) fields += "payer,";
		else {
			if (this.getPayer().getName() == null) fields += "name,";
			if (this.getPayer().getEmail() == null) fields += "email,";
			if (this.getPayer().getPayerID() == null) fields += "payerID,";
			if (this.getPayer().getBillingAddress() == null) fields += "billingAddress,";
			else {
				if (this.getPayer().getBillingAddress().getAddress() == null) fields += "address,";
				if (this.getPayer().getBillingAddress().getNumber() == null) fields += "numero,";
				if (this.getPayer().getBillingAddress().getNeighborhood() == null) fields += "neighborhood,";
				if (this.getPayer().getBillingAddress().getCity() == null) fields += "city,";
				if (this.getPayer().getBillingAddress().getState() == null) fields += "state,";
				if (this.getPayer().getBillingAddress().getCountry() == null) fields += "country,";
				if (this.getPayer().getBillingAddress().getZipCode() == null) fields += "cep,";
				if (this.getPayer().getBillingAddress().getPhone() == null) fields += "phone,";
			}
		}
		
		return fields;
	}
}
