package it.reply.sales.ws.manager;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.reply.sales.ws.dao.GoodsDAO;
import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;
import it.reply.sales.ws.utils.Utilities;

@Service("ISalesTaxesManager")
public class SalesTaxesManager implements ISalesTaxesManager {

	@Autowired
	private GoodsDAO goodsDao;
	
	@Autowired
	private Utilities utils;

	public SalesTaxesManager() throws Exception {
		// super(log);
	}

	static {
	}

	@Override
	public GoodsFullResponse callGetGoodsInfo(List<GoodsRequest> listRequest) throws Exception {
		
		GoodsFullResponse response = utils.checkGoods(listRequest);

		return response;
	}
	
	@Override
	public void insertGoodsLog(String goodsDescr, double price, boolean taxes, boolean imported) throws SQLException {
		goodsDao.insertGoodsLog(goodsDescr, price, taxes, imported);
	}

	
}
