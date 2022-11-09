package com.test.orderservice.common;

import com.test.orderservice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	public TransactionResponse(Order order, double amoun, String transactionID, String msgString) {
		super();
		this.order = order;
		this.amoun = amoun;
		this.transactionID = transactionID;
		this.msgString = msgString;
	}
	private Order order;
	private double amoun; 
	private String  transactionID;
	private String msgString;
	
	public String getMsgString() {
		return msgString;
	}
	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmoun() {
		return amoun;
	}
	public void setAmoun(double amoun) {
		this.amoun = amoun;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	} 

}
