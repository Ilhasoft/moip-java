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
	private String razao;

	@XStreamAlias("IdProprio")
	private String IdProprio;

	@XStreamAlias("Pagador")
	private Payer pagador;

	@XStreamAlias("PagamentoDireto")
	private DirectPayment pagamentoDireto;

	@XStreamAlias("Boleto")
	private Billet boleto;

	@XStreamAlias("Valores")
	private Values valores;

	@XStreamAlias("URLNotificacao")
	private String urlNotificacao;

	@XStreamAlias("URLRetorno")
	private String urlRetorno;

	@XStreamAlias("Mensagens")
	private Messages mensagens;

	@XStreamAlias("Recebedor")
	private Receiver recebedor;

	@XStreamAlias("Comissoes")
	private List<Comissioning> comissoes;
	
	@XStreamAlias("Parcelamentos")
	private List<Parcel> parcelamentos;

	public static SingleInstruction singleInstruction() {
		return new SingleInstruction();
	}

	public SingleInstruction withTransparentValidation() {
		this.validationType = "Transparente";
		return this;
	}
	
	public SingleInstruction withReason(final String razao) {
		this.razao = razao;
		return this;
	}

	public SingleInstruction withUniqueId(final String id) {
		this.IdProprio = id;
		return this;
	}

	public SingleInstruction with(final DirectPayment pagamentoDireto) {
		this.pagamentoDireto = pagamentoDireto;
		return this;
	}

	public SingleInstruction with(final Payer pagador) {
		this.pagador = pagador;
		return this;
	}

	public SingleInstruction with(final Billet boleto) {
		this.boleto = boleto;
		return this;
	}

	public SingleInstruction with(final Values valores) {
		this.valores = valores;
		return this;
	}

	public SingleInstruction with(final Messages mensagens) {
		this.mensagens = mensagens;
		return this;
	}

	public SingleInstruction with(final Receiver recebedor) {
		this.recebedor = recebedor;
		return this;
	}

	public SingleInstruction with(Comissioning comissionamento) {
		if (this.comissoes == null)
			this.comissoes = new ArrayList<Comissioning>();
		this.comissoes.add(comissionamento);
		return this;
	}
	
	public SingleInstruction with(Parcel parcelamento) {
		if (this.parcelamentos == null)
			this.parcelamentos = new ArrayList<Parcel>();
		this.parcelamentos.add(parcelamento);
		return this;
	}
	
	public Payer payer() {
		if (pagador == null) {
			pagador = new Payer();
		}
		return pagador;
	}

	public DirectPayment directPayment() {
		if (pagamentoDireto == null) {
			pagamentoDireto = new DirectPayment();
		}
		return pagamentoDireto;
	}

	public Billet billet() {
		if (boleto == null) {
			boleto = new Billet();
		}
		return boleto;
	}

	public Values values() {
		if (valores == null) {
			valores = new Values();
		}
		return valores;
	}

	public Receiver receiver() {
		if (recebedor == null) {
			recebedor = new Receiver();
		}
		return recebedor;
	}

	public SingleInstruction withNotificationURL(final String urlNotificacao) {
		this.urlNotificacao = urlNotificacao;
		return this;
	}

	public SingleInstruction withReturnURL(final String urlRetorno) {
		this.urlRetorno = urlRetorno;
		return this;
	}

	public String getRazao() {
		return razao;
	}

	public String getIdProprio() {
		return IdProprio;
	}

	public Payer getPagador() {
		return pagador;
	}

	public void setRazao(final String razao) {
		this.razao = razao;
	}

	public void setIdProprio(final String idProprio) {
		IdProprio = idProprio;
	}

	public void setPagador(final Payer pagador) {
		this.pagador = pagador;
	}

	public DirectPayment getPagamentoDireto() {
		return pagamentoDireto;
	}

	public void setPagamentoDireto(final DirectPayment pagamentoDireto) {
		this.pagamentoDireto = pagamentoDireto;
	}

	public Billet getBoleto() {
		return boleto;
	}

	public void setBoleto(final Billet boleto) {
		this.boleto = boleto;
	}

	public Values getValores() {
		return valores;
	}

	public void setValores(final Values valores) {
		this.valores = valores;
	}

	public String getUrlNotificacao() {
		return urlNotificacao;
	}

	public void setUrlNotificacao(final String urlNotificacao) {
		this.urlNotificacao = urlNotificacao;
	}

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public void setUrlRetorno(final String urlRetorno) {
		this.urlRetorno = urlRetorno;
	}

	public Messages getMensagens() {
		return mensagens;
	}

	public void setMensagens(final Messages mensagens) {
		this.mensagens = mensagens;
	}

	public Receiver getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(final Receiver recebedor) {
		this.recebedor = recebedor;
	}

	public List<Comissioning> getComissoes() {
		return comissoes;
	}
	
	public void setComissoes(List<Comissioning> comissoes) {
		this.comissoes = comissoes;
	}

	public void validate() throws InstructionValidationException {
		String fields = "";
		if (this.getIdProprio() == null) fields += "uniqueID,";
		if (this.getRazao() == null) fields += "reason,";
		if (this.getValores() == null) fields += "value,";
		
		if ("Transparente".equals(this.validationType))
			fields += this.validateTransparent();
		
		if (!"".equals(fields))
			throw new InstructionValidationException("You must inform: " + fields.substring(0, fields.length()-1));
		
	}

	private String validateTransparent() {
		String fields = "";
		if (this.getPagador() == null) fields += "payer,";
		else {
			if (this.getPagador().getNome() == null) fields += "name,";
			if (this.getPagador().getEmail() == null) fields += "email,";
			if (this.getPagador().getPayerID() == null) fields += "payerID,";
			if (this.getPagador().getEnderecoCobranca() == null) fields += "billingAddress,";
			else {
				if (this.getPagador().getEnderecoCobranca().getLogradouro() == null) fields += "address,";
				if (this.getPagador().getEnderecoCobranca().getNumero() == null) fields += "numero,";
				if (this.getPagador().getEnderecoCobranca().getBairro() == null) fields += "neighborhood,";
				if (this.getPagador().getEnderecoCobranca().getCidade() == null) fields += "city,";
				if (this.getPagador().getEnderecoCobranca().getEstado() == null) fields += "state,";
				if (this.getPagador().getEnderecoCobranca().getPais() == null) fields += "country,";
				if (this.getPagador().getEnderecoCobranca().getCep() == null) fields += "cep,";
				if (this.getPagador().getEnderecoCobranca().getTelefoneFixo() == null) fields += "phone,";
			}
		}
		
		return fields;
	}
}
