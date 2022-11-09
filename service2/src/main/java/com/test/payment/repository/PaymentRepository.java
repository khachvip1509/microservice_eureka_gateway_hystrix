package com.test.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
