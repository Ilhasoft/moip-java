package br.com.moip.client;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Parcelamento")
public class Parcelamento {

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

	public static Parcelamento parcelamento() {
		return new Parcelamento();
	}

	public Parcelamento comMinimoParcelas(final String minimoParcelas) {
		this.minimoParcelas = minimoParcelas;
		return this;
	}
	
	public Parcelamento comMaximoParcelas(final String maximoParcelas) {
		this.maximoParcelas = maximoParcelas;
		return this;
	}

	public Parcelamento comRecebimento(final String recebimento) {
		this.recebimento = recebimento;
		return this;
	}

	public Parcelamento comJuros(final String juros) {
		this.juros = juros;
		return this;
	}

	public Parcelamento comRepasse(final String repassar) {
		this.repassar = repassar;
		return this;
	}
}
