package it.reply.sales.ws.operation.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "goods", "price", "taxes", "imported" })
@XmlAccessorType(XmlAccessType.FIELD)
public class GoodsRequest {

	private String goods;
	private double price;
	private boolean taxes;
	private boolean imported;

	public GoodsRequest() {
	}

	public GoodsRequest(String goods, double price, boolean taxes, boolean imported) {
		super();
		this.goods = goods;
		this.price = price;
		this.taxes = taxes;
		this.imported = imported;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isTaxes() {
		return taxes;
	}

	public void setTaxes(boolean taxes) {
		this.taxes = taxes;
	}
	
	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsRequest [goods=");
		builder.append(goods);
		builder.append(", price=");
		builder.append(price);
		builder.append(", taxes=");
		builder.append(taxes);
		builder.append(", imported=");
		builder.append(imported);
		builder.append("]");
		return builder.toString();
	}
}
