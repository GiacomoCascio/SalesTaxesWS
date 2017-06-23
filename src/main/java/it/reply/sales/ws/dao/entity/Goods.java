package it.reply.sales.ws.dao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Component
@Table(name = "SALES_TAXES")
public class Goods implements Serializable {

	private static final long serialVersionUID = 273543321328882L;

	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_SEQ_GOODS")
	// @SequenceGenerator(name = "_SEQ_GOODS", sequenceName = "SEQ_GOODS", allocationSize = 1)
	@Id
	@Column(name = "ID_GOODS")
	private int idGoods;

	@Column(name = "GOODS_DESCR")
	private String goodsDescr;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "TAXES")
	private boolean taxes;
	
	@Column(name = "IMPORTED")
	private boolean imported;
		
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "goods")
	private Set<Goods> goods;
	
	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public int getIdGoods() {
		return idGoods;
	}

	public void setIdGoods(int idGoods) {
		this.idGoods = idGoods;
	}

	public String getGoodsDescr() {
		return goodsDescr;
	}

	public void setGoodsDescr(String goodsDescr) {
		this.goodsDescr = goodsDescr;
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

}
