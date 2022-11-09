package com.test.payment.controller;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.payment.entity.Payment;
import com.test.payment.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		
		return paymentService.doPayment(payment);
	}
	
	@GetMapping("/{orderId}")
	public Payment findPayrmentHistoryByOrderId(@PathVariable int orderId) {
		return paymentService.findPayrmentHistoryByOrderId(orderId);
	}

}
