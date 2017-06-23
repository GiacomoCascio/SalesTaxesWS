package it.reply.sales.ws.operation.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "goods", "price" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "goodsResponse")
public class GoodsResponse {

	@XmlElement(name = "GOODS")
	private String goods;
	
	@XmlElement(name = "PRICE")
	private double price;
	
	public GoodsResponse() {
	}

	public GoodsResponse(String goods, double price) {
		super();
		this.goods = goods;
		this.price = price;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsResponse [");
		builder.append("goods=");
		builder.append(goods);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}