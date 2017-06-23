package it.reply.sales.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.reply.sales.ws.dao.entity.Goods;
import it.reply.sales.ws.operation.data.GoodsRequest;
import it.reply.sales.ws.operation.data.GoodsResponse;

@Repository
@Transactional
public class GoodsDAO extends BaseDAO {

	@Autowired
	private DataSource dataSource;
	
	
	
	private static final String INS_GOODS_LOG = "INSERT INTO GOODS_LOG (GOODS_DESCR, PRICE, TAXES, IMPORTED) VALUES (?,?,?,?)";
	
	private static final String SELECT_QUERY = "SELECT GOODS_DESCR, PRICE FROM SALES_TAXES WHERE ID_GOODS is not null";
	
	/**
	 * serve per tracciare le operazioni effettuate sul DB
	 * */
	public void insertGoodsLog(String goodsDescr, double price, boolean taxes, boolean imported) throws SQLException {
		try (Connection conn = dataSource.getConnection(); PreparedStatement selectStat = conn.prepareStatement(INS_GOODS_LOG)) {
			selectStat.setString(1, goodsDescr);
			selectStat.setDouble(2, price);
			selectStat.setBoolean(3, taxes);
			selectStat.setBoolean(4, imported);
			try (ResultSet rs = selectStat.executeQuery()) {
			}
		}

	}
	
	public GoodsResponse checkGoods(GoodsRequest checkGoodsRequest) throws SQLException {
		GoodsResponse response;

		String goods = "";
		double price = 0.00;
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement selectStat = conn.prepareStatement(SELECT_QUERY)) {
			try (ResultSet rSet = selectStat.executeQuery()) {
				if (rSet.next()) {
					goods = rSet.getString("GOODS_DESCR");
					price = rSet.getDouble("PRICE");					
				} 
					/**
					 * non avendo DB da interrogare ho preso un'altra strada
					 * 
					 */
				response = new GoodsResponse(goods, price);
			}
		}

		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Goods> findAll() {
		return getCurrentSession().createQuery("from SALES_TAXES").list();
	}

	
}
