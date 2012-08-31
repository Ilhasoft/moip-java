package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Parcelamento")
public class Parcel {

	@XStreamAlias("MinimoParcelas")
	private String minimoParcelas;
	
	@XStreamAlias("MaximoParcelas")
	private String maximoParcelas;

	@XStreamAlias("Recebimento")
	private String recebimento;
	
	@XStreamAlias("Juros")
	private String juros;
	
	@XStreamAlias("Repassar")
	private String repassar;

	public static Parcel parcel() {
		return new Parcel();
	}

	public Parcel withMinimumParcels(final String minimoParcelas) {
		this.minimoParcelas = minimoParcelas;
		return this;
	}
	
	public Parcel withMaximumParcels(final String maximoParcelas) {
		this.maximoParcelas = maximoParcelas;
		return this;
	}

	public Parcel withReceptionType(final String recebimento) {
		this.recebimento = recebimento;
		return this;
	}

	public Parcel withInterest(final String juros) {
		this.juros = juros;
		return this;
	}

	public Parcel withTransfer(final String repassar) {
		this.repassar = repassar;
		return this;
	}
}
