package com.example.gatewayservice.filters;


import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class AddRequestIdFilter implements GlobalFilter {

	final org.slf4j.Logger logger = LoggerFactory.getLogger(AddRequestIdFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Global Pre Filter executed");
		return chain.filter(exchange);
	}
	
}
