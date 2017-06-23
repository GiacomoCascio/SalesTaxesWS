package it.reply.sales.ws.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;
import it.reply.sales.ws.operation.data.GoodsResponse;


public class Utilities {

	public double checkSalesTaxes(boolean taxes, boolean imported ) {
		double salesTaxes = 0.00;
		if (taxes)
			salesTaxes = salesTaxes + 10.00;
		
		if (imported)
			salesTaxes = salesTaxes + 5.00;
		
		return salesTaxes;
	}

	
		
	public GoodsFullResponse checkGoods(List<GoodsRequest> listRequest) throws Exception {
		
		GoodsFullResponse responseFull = new GoodsFullResponse(); 
		List<GoodsResponse> listGoodsResponse = new ArrayList<GoodsResponse>();
		
		GoodsResponse response;
		String goods ="";
		double price = 0.00;
		double percTaxes = 0.00;
		double salesTaxes = 0.00;
		double totSalesTaxes = 0.00;
		double total = 0.00;
		
		for (GoodsRequest request : listRequest){
			
			goods = request.getGoods();
			percTaxes = checkSalesTaxes(request.isTaxes(), request.isImported());			
			salesTaxes = ((request.getPrice()/100) * percTaxes);
			
			price = request.getPrice() + salesTaxes;
			totSalesTaxes +=salesTaxes;
			total += price;
			//response = new GoodsResponse(goods, (Math.round(price * 20.0) / 20.0));
			response = new GoodsResponse(goods, (Math.round(price * 100 + 0.005) / 100.0));
			listGoodsResponse.add(response);
		}
		
		responseFull.setListGoods(listGoodsResponse);
		//responseFull.setTaxes((Math.round(totSalesTaxes * 20.0) / 20.0));
		//responseFull.setTaxes((Math.round(totSalesTaxes * 100 + 0.005) / 100.0));
		
		BigDecimal bdSales = new BigDecimal(totSalesTaxes);
		bdSales = bdSales.round(new MathContext(2, RoundingMode.CEILING));
		//bdSales = bdSales.setScale(2, BigDecimal.ROUND_HALF_UP);
		responseFull.setTaxes(Double.parseDouble(bdSales.toString()));		
		
		responseFull.setTotal((Math.round(total * 20.0) / 20.0));
		//responseFull.setTotal((Math.round(total * 100 + 0.005) / 100.0));
				
		return responseFull;
	}


}
