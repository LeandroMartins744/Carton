package com.apresentacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apresentacao.bussiness.CartonBussiness;
import com.apresentacao.model.request.CartonRequest;
import com.apresentacao.model.response.ProtocolResponse;

@RestController
public class CartonController {

	@Autowired
	private CartonBussiness cartonBussiness;
	
	
	@RequestMapping(value = "carton", produces = "application/json", method = RequestMethod.POST)
	public ProtocolResponse post(@RequestBody CartonRequest obj) {
		return cartonBussiness.Insert(obj);
	}
}
