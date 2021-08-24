package com.apresentacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apresentacao.bussiness.SaleBussiness;
import com.apresentacao.model.request.SaleRequest;
import com.apresentacao.model.response.ProtocolResponse;

@RestController
public class SaleController {

	@Autowired
	private SaleBussiness saleBussiness;


	@RequestMapping(value = "sale", produces = "application/json", method = RequestMethod.POST)
	public ProtocolResponse post(@RequestBody SaleRequest obj) throws Exception {
		ProtocolResponse cliente = saleBussiness.Insert(obj);
		return cliente;
	}
}
