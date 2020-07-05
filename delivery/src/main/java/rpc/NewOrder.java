package rpc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import entity.Order;
import entity.Order.OrderBuilder;

/**
 * Servlet implementation class NewOrder
 */
public class NewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//initialize attributes for newOrder
		String userId = "";
		String senderAddress = "";
		String recipentAddress = "";
		String stationId = "";
		String stationAddress = "";
		String machineType = "";
		
		Long orderCreateTime = null;
		Long orderPickupTime = null;
		Long orderDeliveryTime = null;
		
		
		// get order info from JSON object via HTTP reqeust
		JSONObject preOrderInfo = RpcHelper.readJSONObject(request);
		
		if (preOrderInfo.getString("userId") != null) {
			userId = preOrderInfo.getString("userId");
		}
		
		if (preOrderInfo.getString("senderAddress") != null) {
			senderAddress = preOrderInfo.getString("senderAddress");
		}
		
		if (preOrderInfo.getString("recipentAddress") != null) {
			senderAddress = preOrderInfo.getString("recipentAddress");
		}
		
		
		
		// create a new order via builder pattern
		OrderBuilder newOrder = new OrderBuilder();
		
		newOrder.setUserId(userId);
		newOrder.setSenderAddress(senderAddress);
		newOrder.setRecipentAddress(recipentAddress);
		newOrder.setOrderCreateTime(orderCreateTime);
		newOrder.setOrderDeliveryTime(orderDeliveryTime);
		
		Order order = newOrder.build(); // will be stored in DB
		
		String newOrderId = "55667788";
		
		// generate newOrderInfo for confirmation page
		JSONObject newOrderInfo = new JSONObject();
				
		//return newOrder to confirmation page
		if (newOrderId != "") {
			newOrderInfo.put("orderId", newOrderId);
			RpcHelper.writeJsonObject(response, newOrderInfo);
		}
				
			
	}

}
