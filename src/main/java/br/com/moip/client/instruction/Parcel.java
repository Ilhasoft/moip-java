package br.com.moip.client.instruction;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Classe que representa uma regra de parcelamento.
 * <br>XML: Elemento &lt;Parcelamento&gt;
 *
 */
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

	/**
	 * Define o número mínimo de parcelas deste parcelamento.
	 * <br>XML: Elemento &lt;MinimoParcelas&gt;
	 * @param minimoParcelas
	 * @return
	 */
	public Parcel withMinimumParcels(final String minimoParcelas) {
		this.minimumParcels = minimoParcelas;
		return this;
	}
	
	/**
	 * Define o número máximo de parcelas deste parcelamento.
	 * <br>XML: Elemento &lt;MaximoParcelas&gt;
	 * @param maximoParcelas
	 * @return
	 */
	public Parcel withMaximumParcels(final String maximoParcelas) {
		this.maximumParcels = maximoParcelas;
		return this;
	}

	/**
	 * Define o tipo de recebimento deste parcelamento.
	 * <br>XML: Elemento &lt;Recebimento&gt;
	 * @param recebimento
	 * @return
	 */
	public Parcel withReceptionType(final String recebimento) {
		this.receptionType = recebimento;
		return this;
	}

	/**
	 * Define a taxa de juros deste parcelamento.
	 * <br>XML: Elemento &lt;Juros&gt;
	 * @param juros
	 * @return
	 */
	public Parcel withInterest(final String juros) {
		this.interest = juros;
		return this;
	}

	/**
	 * Define se os juros devem ser repassados pro cliente ou não.
	 * <br>XML: Elemento &lt;Repassar&gt;
	 * @param repassar
	 * @return
	 */
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
