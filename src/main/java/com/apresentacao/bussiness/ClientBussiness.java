package com.apresentacao.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apresentacao.dao.ClientDao;
import com.apresentacao.entity.ClientEntity;
import com.apresentacao.model.request.ClientRequest;
import com.apresentacao.model.response.ProtocolResponse;
import java.util.List;

@Component
public class ClientBussiness extends GenericBussiness {
	
	@Autowired
	private ClientDao clientDao;
	
	public ProtocolResponse List() {
		try {
			List<ClientEntity> cliente = clientDao.Lista();
			return this.response(200, new ClientRequest().ClientMapperRequest(cliente));
		}
		catch (Exception e) {
			return this.response(201, e);
		}
	}
	
	public ProtocolResponse SearchCpf(String cpf) {
		try {
			ClientEntity cliente = clientDao.SearchCpf(cpf);
			return this.response(200, new ClientRequest(cliente));
		}
		catch (Exception e) {
			return this.response(201, e);
		}
	}
	
	public ProtocolResponse Insert(ClientRequest client) {
		try {
			ClientEntity entity = new ClientEntity(client);
			clientDao.Cadastrar(entity);
			return this.response(200, true);
		}
		catch (Exception e) {
			return this.response(500, e);
		}
	}
	
	public ClientEntity ClientFind(Integer id) throws Exception {
		ClientEntity client = clientDao.Buscar(id);
		if(client == null)
			throw new Exception("Cartão não encontrado");
		else 
			return client;
	}
}
