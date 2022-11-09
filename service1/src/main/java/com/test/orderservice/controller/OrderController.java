package com.test.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.orderservice.common.Payment;
import com.test.orderservice.common.TransactionRequest;
import com.test.orderservice.common.TransactionResponse;
import com.test.orderservice.entity.Order;
import com.test.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request ) {
		return orderService.saveOrder(request);
	}
}
