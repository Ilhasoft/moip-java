package br.com.moip.client.instruction;

import java.util.ArrayList;
import java.util.List;

import br.com.moip.client.exception.InstructionValidationException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Classe que representa um pagamento por instrução única.
 * <br>XML: Elemento &lt;InstrucaoUnica&gt;
 *
 */
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

	@XStreamAlias("Boleto")
	private Billet billet;

	@XStreamAlias("Valores")
	private Values values;

	@XStreamAlias("URLNotificacao")
	private String notificationURL;

	@XStreamAlias("URLRetorno")
	private String returnURL;

	@XStreamAlias("Recebedor")
	private Receiver receiver;

	@XStreamAlias("Comissoes")
	private List<Comissioning> comissions;
	
	@XStreamAlias("Parcelamentos")
	private List<Parcel> parcels;

	/**
	 * Valida esta instrução, lançando uma exceção que lista os campos faltantes.
	 * @throws InstructionValidationException
	 */
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

	/**
	 * Valida os campos para uma instrução do tipo "Transparente".
	 * @return String com os campos faltantes concatenados por vírgula
	 */
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
	
	/**
	 * Define que deve ser usada a validação de tipo "Transparente" para esta instrução.
	 * <br>XML: atributo tipoValidacao="Transparente"
	 * @return
	 */
	public SingleInstruction withTransparentValidation() {
		this.validationType = "Transparente";
		return this;
	}
	
	/**
	 * Define a razão deste pagamento.
	 * <br>XML: Elemento &lt;Razao&gt;
	 * @param razao
	 * @return
	 */
	public SingleInstruction withReason(final String razao) {
		this.reason = razao;
		return this;
	}

	/**
	 * Define o ID próprio deste pagamento.
	 * <br>XML: Elemento &lt;IdProprio&gt;
	 * @param id
	 * @return
	 */
	public SingleInstruction withUniqueId(final String id) {
		this.uniqueId = id;
		return this;
	}

	/**
	 * Define o Pagador deste pagamento.
	 * <br>XML: Elemento &lt;Pagador&gt;
	 * @param pagador
	 * @return
	 */
	public SingleInstruction with(final Payer pagador) {
		this.payer = pagador;
		return this;
	}

	/**
	 * Define os dados do Boleto deste pagamento.
	 * <br>XML: Elemento &lt;Boleto&gt;
	 * @param boleto
	 * @return
	 */
	public SingleInstruction with(final Billet boleto) {
		this.billet = boleto;
		return this;
	}

	/**
	 * Define o Valor deste pagamento.
	 * <br>XML: Elemento &lt;Valores&gt;
	 * @param valores
	 * @return
	 */
	public SingleInstruction with(final Values valores) {
		this.values = valores;
		return this;
	}

	/**
	 * Define o Recebedor deste pagamento.
	 * <br>XML: Elemento &lt;Recebedor&gt;
	 * @param recebedor
	 * @return
	 */
	public SingleInstruction with(final Receiver recebedor) {
		this.receiver = recebedor;
		return this;
	}

	/**
	 * Define um comissionamento para este pagamento. Pode ser especificado mais de um.
	 * <br>XML: Elemento &lt;Comissionamento&gt;
	 * @param comissionamento
	 * @return
	 */
	public SingleInstruction with(Comissioning comissionamento) {
		if (this.comissions == null)
			this.comissions = new ArrayList<Comissioning>();
		this.comissions.add(comissionamento);
		return this;
	}
	
	/**
	 * Define uma regra de parcelamento para este pagamento. Pode ser especificada mais de uma.
	 * <br>XML: Elemento &lt;Parcelamento&gt;
	 * @param parcelamento
	 * @return
	 */
	public SingleInstruction with(Parcel parcelamento) {
		if (this.parcels == null)
			this.parcels = new ArrayList<Parcel>();
		this.parcels.add(parcelamento);
		return this;
	}
	
	/**
	 * Define a URL de Notificação para este pagamento.
	 * <br>XML: Elemento &lt;URLNotificacao&gt;
	 * @param urlNotificacao
	 * @return
	 */
	public SingleInstruction withNotificationURL(final String urlNotificacao) {
		this.notificationURL = urlNotificacao;
		return this;
	}

	/**
	 * Define a URL de Retorno para este pagamento.
	 * <br>XML: Elemento &lt;URLRetorno&gt;
	 * @param urlRetorno
	 * @return
	 */
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

	public Receiver getReceiver() {
		return receiver;
	}

	public List<Comissioning> getComissions() {
		return comissions;
	}

	public List<Parcel> getParcels() {
		return parcels;
	}
	
}
