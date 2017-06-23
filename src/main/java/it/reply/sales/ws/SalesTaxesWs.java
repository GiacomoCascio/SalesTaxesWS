package it.reply.sales.ws;

import java.util.List;

import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;

public interface SalesTaxesWs {

	public GoodsFullResponse getInfoGoods(List<GoodsRequest> request) throws Exception;

}
