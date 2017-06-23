package it.reply.sales.ws.operation.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "listGoods", "taxes", "total" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "goodsFullResponse")
public class GoodsFullResponse {

	@XmlElement(name = "LISTGOODS")
	private List<GoodsResponse> listGoods;
	
	@XmlElement(name = "TAXES")
	private double taxes;
	
	@XmlElement(name = "TOTAL")
	private double total;
	
	public GoodsFullResponse() {
	}

	public GoodsFullResponse(List<GoodsResponse> listGoods, double taxes, double total) {
		super();
		this.listGoods = listGoods;
		this.taxes = taxes;
		this.total = total;
	}
	
	public List<GoodsResponse> getListGoods() {
		return listGoods;
	}

	public void setListGoods(List<GoodsResponse> listGoods) {
		this.listGoods = listGoods;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsResponse [");
		builder.append("listGoods=");
		builder.append(listGoods);
		builder.append(", taxes=");
		builder.append(taxes);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

}