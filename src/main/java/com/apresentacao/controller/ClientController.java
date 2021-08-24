package com.apresentacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apresentacao.bussiness.ClientBussiness;
import com.apresentacao.model.request.ClientRequest;
import com.apresentacao.model.response.ProtocolResponse;

@RestController
public class ClientController {

	@Autowired
	private ClientBussiness clientBussiness;
	
	@RequestMapping(value = "client", produces = "application/json", method = RequestMethod.GET)
	public ProtocolResponse get(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
		ProtocolResponse cliente = clientBussiness.SearchCpf(cpf);
		return cliente;
	}
	
	@RequestMapping(value = "clientlist", produces = "application/json", method = RequestMethod.GET)
	public ProtocolResponse get() {
		ProtocolResponse cliente = clientBussiness.List();
		return cliente;
	}
	
	@RequestMapping(value = "client", produces = "application/json", method = RequestMethod.POST)
	public ProtocolResponse post(@RequestBody ClientRequest obj) {
		ProtocolResponse cliente = clientBussiness.Insert(obj);
		return cliente;
	}
}
