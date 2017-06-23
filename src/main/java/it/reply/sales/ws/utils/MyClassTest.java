package it.reply.sales.ws.utils;

import java.util.ArrayList;
import java.util.List;

import it.reply.sales.ws.operation.data.GoodsFullResponse;
import it.reply.sales.ws.operation.data.GoodsRequest;
import it.reply.sales.ws.operation.data.GoodsResponse;


public class MyClassTest {
	
	public static void main(String[] args) throws Exception {
		Utilities utils = new Utilities();
		List<GoodsRequest> listRequest = new ArrayList<GoodsRequest>();
		
/********************* TEST 1 ***********************
Input 1: 
	1 book at 12.49 
	1 music CD at 14.99 
	1 chocolate bar at 0.85 
Output 1: 
	1 book : 12.49 
	1 music CD: 16.49 
	1 chocolate bar: 0.85 
	Sales Taxes: 1.50 
	Total: 29.83 
*/			
		System.out.println("********************* TEST 1 - START ***********************");
		GoodsRequest request = new GoodsRequest();
		request.setGoods("book");
		request.setPrice(12.49);
		request.setTaxes(false);
		request.setImported(false);
		System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
		listRequest.add(request);
		
		request = new GoodsRequest();
		request.setGoods("music CD");
		request.setPrice(14.99);
		request.setTaxes(true);
		request.setImported(false);
		System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
		listRequest.add(request);
		
		request = new GoodsRequest();
		request.setGoods("chocolate bar");
		request.setPrice(0.85);
		request.setTaxes(false);
		request.setImported(false);
		System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
		listRequest.add(request);
		
		GoodsFullResponse response = utils.checkGoods(listRequest);
		
		for (GoodsResponse res:response.getListGoods()){
			System.out.println("Response da List: [" +  res.getGoods() + ": " + res.getPrice() + "]");
		}
		System.out.println("Response da Bean: [Sales Taxes: " +  response.getTaxes() + ", Total: " + response.getTotal() +"]");
		
		System.out.println("********************* TEST 1 - END ***********************");
		System.out.println("\n");
		
		
/********************* TEST 2 - START ***********************
Input 2: 
	1 imported box of chocolates at 10.00 
	1 imported bottle of perfume at 47.50
Output 2: 
	1 imported box of chocolates: 10.50 
	1 imported bottle of perfume: 54.65 
	Sales Taxes: 7.65 
	Total: 65.15 
*/		
		System.out.println("********************* TEST 2 - START ***********************");
		listRequest = new ArrayList<GoodsRequest>();
		request = new GoodsRequest();
		request.setGoods("imported box of chocolates");
		request.setPrice(10.00);
		request.setTaxes(false);
		request.setImported(true);
		System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
		listRequest.add(request);
		
		request = new GoodsRequest();
		request.setGoods("imported bottle of perfume");
		request.setPrice(47.50);
		request.setTaxes(true);
		request.setImported(true);
		System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
		listRequest.add(request);
		
		response = utils.checkGoods(listRequest);
		
		for (GoodsResponse res:response.getListGoods()){
			System.out.println("Response da List: [" +  res.getGoods() + ": " + res.getPrice() + "]");
		}
		System.out.println("Response da Bean: [Sales Taxes: " +  response.getTaxes() + ", Total: " + response.getTotal() +"]");
		
		System.out.println("********************* TEST 2 - END ***********************");
		System.out.println("\n");
		
/********************* TEST 3 - START ***********************
Input 2: 
	1 imported bottle of perfume at 27.99 
	1 bottle of perfume at 18.99 
	1 packet of headache pills at 9.75 
	1 box of imported chocolates at 11.25
Output 2: 
	1 imported bottle of perfume: 32.19 
	1 bottle of perfume: 20.89 
	1 packet of headache pills: 9.75 
	1 imported box of chocolates: 11.85 
	Sales Taxes: 6.70 
	Total: 74.68 
*/		
				System.out.println("********************* TEST 3 - START ***********************");
				listRequest = new ArrayList<GoodsRequest>();
				request = new GoodsRequest();
				request.setGoods("imported bottle of perfume");
				request.setPrice(27.99);
				request.setTaxes(true);
				request.setImported(true);
				System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
				listRequest.add(request);
				
				request = new GoodsRequest();
				request.setGoods("bottle of perfume");
				request.setPrice(18.99);
				request.setTaxes(true);
				request.setImported(false);
				System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
				listRequest.add(request);
				
				request = new GoodsRequest();
				request.setGoods("packet of headache pills");
				request.setPrice(9.75);
				request.setTaxes(false);
				request.setImported(false);
				System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
				listRequest.add(request);
				
				request = new GoodsRequest();
				request.setGoods("imported box of chocolates");
				request.setPrice(11.25);
				request.setTaxes(false);
				request.setImported(true);
				System.out.println("Request: [" +  request.getGoods() + "," + request.getPrice() + "," + request.isTaxes() + "," + request.isImported() +"]");
				listRequest.add(request);
				
				response = utils.checkGoods(listRequest);
				
				for (GoodsResponse res:response.getListGoods()){
					System.out.println("Response da List: [" +  res.getGoods() + ": " + res.getPrice() + "]");
				}
				System.out.println("Response da Bean: [Sales Taxes: " +  response.getTaxes() + ", Total: " + response.getTotal() +"]");
				
				
				System.out.println("********************* TEST 3 - END ***********************");
				System.out.println("\n");
		
	}
	
}
