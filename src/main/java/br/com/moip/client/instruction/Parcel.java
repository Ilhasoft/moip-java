package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Parcelamento")
public class Parcel {

	@XStreamAlias("MinimoParcelas")
	private String minimumParcels;
	
	@XStreamAlias("MaximoParcelas")
	private String maximumParcels;

	@XStreamAlias("Recebimento")
	private String receptionType;
	
	@XStreamAlias("Juros")
	private String interest;
	
	@XStreamAlias("Repassar")
	private String transfer;

	public Parcel withMinimumParcels(final String minimoParcelas) {
		this.minimumParcels = minimoParcelas;
		return this;
	}
	
	public Parcel withMaximumParcels(final String maximoParcelas) {
		this.maximumParcels = maximoParcelas;
		return this;
	}

	public Parcel withReceptionType(final String recebimento) {
		this.receptionType = recebimento;
		return this;
	}

	public Parcel withInterest(final String juros) {
		this.interest = juros;
		return this;
	}

	public Parcel withTransfer(final String repassar) {
		this.transfer = repassar;
		return this;
	}

	public String getMinimumParcels() {
		return minimumParcels;
	}

	public String getMaximumParcels() {
		return maximumParcels;
	}

	public String getReceptionType() {
		return receptionType;
	}

	public String getInterest() {
		return interest;
	}

	public String getTransfer() {
		return transfer;
	}
	
}
