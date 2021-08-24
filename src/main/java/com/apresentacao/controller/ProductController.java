package com.apresentacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apresentacao.bussiness.ProductBussiness;
import com.apresentacao.model.request.ProductRequest;
import com.apresentacao.model.response.ProtocolResponse;

@RestController
public class ProductController {

	@Autowired
	private ProductBussiness productBussiness;
	
	@RequestMapping(value = "product", produces = "application/json", method = RequestMethod.GET)
	public ProtocolResponse get() {
		ProtocolResponse cliente = productBussiness.List();
		return cliente;
	}
	
	@RequestMapping(value = "product", produces = "application/json", method = RequestMethod.POST)
	public ProtocolResponse post(@RequestBody ProductRequest obj) {
		ProtocolResponse cliente = productBussiness.Insert(obj);
		return cliente;
	}
}
