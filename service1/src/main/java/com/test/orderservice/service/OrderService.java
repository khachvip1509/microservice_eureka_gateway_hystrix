package com.test.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.orderservice.common.Payment;
import com.test.orderservice.common.TransactionRequest;
import com.test.orderservice.common.TransactionResponse;
import com.test.orderservice.entity.Order;
import com.test.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;

	public TransactionResponse saveOrder(TransactionRequest request) {
		String response ="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmoun(order.getPrice());
		
		Payment paymentResponse =  template.postForObject("http://localhost:2222/payment/doPayment", payment, Payment.class);
		
		if (paymentResponse.getPaymentStatus().equals("success")) {
			response ="Payment proceessing successful ";
		}else {
			response = "Processing failue";
		}
		repository.save(order);
		return new TransactionResponse(order,paymentResponse.getAmoun(),paymentResponse.getTransactionID(), response) ;
	}
}
