package it.reply.sales.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.reply.sales.ws.manager.SalesTaxesManager;
import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;

@WebService
@SOAPBinding
public class SalesTaxesWsImpl implements SalesTaxesWs {

	private static final Logger log = Logger.getLogger(SalesTaxesWsImpl.class);
	
	@Autowired
	private SalesTaxesManager salesTaxesManager;

	@Override
	@WebMethod(action = "getInfoGoods")
	@WebResult(name = "infoGoods")
	public GoodsFullResponse getInfoGoods(@XmlElement(required = true) @WebParam(name = "goodsRequest") List<GoodsRequest> listRequest)
			throws Exception {
		GoodsFullResponse responseFull = new GoodsFullResponse();
		try {
				log.info("callGetGoodsInfo : [..............]");
				responseFull = salesTaxesManager.callGetGoodsInfo(listRequest);
				
				/**
				 * salva sul db su una tabella di log le request
				 */
				for (GoodsRequest request : listRequest){
					salesTaxesManager.insertGoodsLog(request.getGoods(), request.getPrice(), request.isTaxes(), request.isImported());
				}				
				
		} catch (Exception e) {
			log.error("an error occuring during call", e);
		}
		return responseFull;
	}

}
