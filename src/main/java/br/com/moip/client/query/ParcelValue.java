package br.com.moip.client.query;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Classe que representa uma opção de parcelamento.
 * <br>XML: Elemento &lt;ValorDaParcela&gt;
 *
 */
@XStreamAlias("ValorDaParcela")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"parcel"})
public class ParcelValue {

	@XStreamAlias("Total")
	private String total;
	
	@XStreamAlias("Juros")
	private String interest;
	
	@XStreamAlias("Valor")
	private String value;
	
	private String parcel;

	/**
	 * Devolve o valor total pago pelo cliente através desta opção de parcelamento.
	 * <br>XML: Elemento &lt;Total&gt;
	 * @return
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * Devolve os juros pagos através desta opção de parcelamento.
	 * <br>XML: Elemento &lt;Juros&gt;
	 * @return
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Devolve o valor por parcela pago através desta opção de parcelamento.
	 * <br>XML: Elemento &lt;Valor&gt;
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Devolve o número de parcelas pagas atraveś desta opção de parcelamento.
	 * <br>XML: número dentro do elemento
	 * @return
	 */
	public String getParcel() {
		return parcel;
	}

}
