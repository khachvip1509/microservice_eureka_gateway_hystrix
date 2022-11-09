package com.test.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.payment.entity.Payment;
import com.test.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(@RequestBody Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionID(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	public String paymentProcessing() {
		//api should be 3rd party payment gateway(paypal, pay atm..)
		return new Random().nextBoolean()?"success":"false";
	}
	public Payment findPayrmentHistoryByOrderId(int orderId) {
		return paymentRepository.findByOrderId(orderId) ;
	}
	
}
