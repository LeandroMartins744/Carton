package com.apresentacao.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apresentacao.entity.ClientEntity;

public class ClientRequest implements Serializable {
	
	private static final long serialVersionUID = 6276284124025352858L;
	
	private int id;
	private List<CartonRequest> carton;
	private StreetRequest street;
	private List<SaleRequest> sale;
	private String name;
	private String phone;
	private String cpf;
	
	public ClientRequest() {
		super();
	}
	
	public ClientRequest(ClientEntity client) {
		super();
		this.id = client.getId();
		this.carton = new CartonRequest().CartonMapperRequest(client.getCarton());
		if(client.getStreet() != null)
			this.street = new StreetRequest(client.getStreet());
		this.sale = new SaleRequest().SaleMapperRequest(client.getSale());
		this.name = client.getName();
		this.phone = client.getPhone();
		this.cpf = client.getCpf();
	}
	
	
	public List<ClientRequest> ClientMapperRequest(List<ClientEntity> client){
		List<ClientRequest> lista = new ArrayList<ClientRequest>();
		
		for (ClientEntity item : client)
			lista.add(new ClientRequest(item));
		
		return lista;
	}
	
	public ClientRequest(int id, List<CartonRequest> carton, StreetRequest street, List<SaleRequest> sale, String name,
			String phone, String cpf) {
		super();
		this.id = id;
		this.carton = carton;
		this.street = street;
		this.sale = sale;
		this.name = name;
		this.phone = phone;
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CartonRequest> getCarton() {
		return carton;
	}
	public void setCarton(List<CartonRequest> carton) {
		this.carton = carton;
	}
	public StreetRequest getStreet() {
		return street;
	}
	public void setStreet(StreetRequest street) {
		this.street = street;
	}
	public List<SaleRequest> getSale() {
		return sale;
	}
	public void setSale(List<SaleRequest> sale) {
		this.sale = sale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
