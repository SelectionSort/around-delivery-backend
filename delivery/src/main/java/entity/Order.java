package entity;

import org.json.JSONObject;

public class Order {
	
	private String userId;
	private String senderAddress;
	private String recipentAddress;
	private String stationId;
	private String stationAddress;
	private String machineType;
	
	private Long orderCreateTime;
	private Long orderPickupTime;
	private Long orderDeliveryTime;
	
	//create setters for these attributes
	public String getUserId() {
		return userId;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public String getRecipentAddress() {
		return recipentAddress;
	}
	public String getStationId() {
		return stationId;
	}
	public String getStationAddress() {
		return stationAddress;
	}
	public String getMachineType() {
		return machineType;
	}
	public Long getOrderCreateTime() {
		return orderCreateTime;
	}
	public Long getOrderPickupTime() {
		return orderPickupTime;
	}
	public Long getOrderDeliveryTime() {
		return orderDeliveryTime;
	}
	
	
	//Convert order object to JSONObject instance
	public JSONObject toJSONObject() {
		JSONObject orderJSON = new JSONObject();
		
		orderJSON.put("userId", userId);
		orderJSON.put("senderAddress", senderAddress);
		orderJSON.put("recipentAddress", recipentAddress);
		orderJSON.put("stationId", stationId);
		orderJSON.put("stationAddress", stationAddress);
		orderJSON.put("machineType", machineType);
		orderJSON.put("orderCreateTime", orderCreateTime);
		orderJSON.put("orderPickupTime", orderPickupTime);
		orderJSON.put("orderDeliveryTime", orderDeliveryTime);
		
		
		return orderJSON;
	}
	
	
	//Builder pattern
	private Order(OrderBuilder builder) {
		this.userId = builder.userId;
		this.senderAddress = builder.senderAddress;
		this.recipentAddress = builder.recipentAddress;
		this.stationId = builder.stationId;
		this.stationAddress = builder.stationAddress;
		this.machineType = builder.machineType;
		this.orderCreateTime = builder.orderCreateTime;
		this.orderPickupTime = builder.orderPickupTime;
		this.orderDeliveryTime = builder.orderDeliveryTime;
	}
	
	//OrderBuilder class
	
	public static class OrderBuilder {
		private String userId;
		private String senderAddress;
		private String recipentAddress;
		private String stationId;
		private String stationAddress;
		private String machineType;
		
		private Long orderCreateTime;
		private Long orderPickupTime;
		private Long orderDeliveryTime;
		
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public void setSenderAddress(String senderAddress) {
			this.senderAddress = senderAddress;
		}
		public void setRecipentAddress(String recipentAddress) {
			this.recipentAddress = recipentAddress;
		}
		public void setStationId(String stationId) {
			this.stationId = stationId;
		}
		public void setStationAddress(String stationAddress) {
			this.stationAddress = stationAddress;
		}
		public void setMachineType(String machineType) {
			this.machineType = machineType;
		}
		public void setOrderCreateTime(Long orderCreateTime) {
			this.orderCreateTime = orderCreateTime;
		}
		public void setOrderPickupTime(Long orderPickupTime) {
			this.orderPickupTime = orderPickupTime;
		}
		public void setOrderDeliveryTime(Long orderDeliveryTime) {
			this.orderDeliveryTime = orderDeliveryTime;
		}
		
		public Order build() {
			return new Order(this);
		}
		
		
		
	}

}