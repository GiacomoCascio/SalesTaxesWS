package it.reply.sales.ws.manager;

import java.sql.SQLException;
import java.util.List;

import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;

//@Local
public interface ISalesTaxesManager {

	public GoodsFullResponse callGetGoodsInfo(List<GoodsRequest> listRequest) throws Exception;

	public void insertGoodsLog(String goodsDescr, double price, boolean taxes, boolean imported) throws SQLException;


}
