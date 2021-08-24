package com.apresentacao.model.request;

import java.io.Serializable;

import com.apresentacao.entity.StreetEntity;

public class StreetRequest implements Serializable {
	
	private static final long serialVersionUID = 5700007197055845329L;
	
	private int id;
	private ClientRequest client;
	private String cep;
	private String street;
	private Integer number;
	private String complement;
	private String district;
	private String city;
	private String state;
	
	public StreetRequest() {
		super();
	}
	
	public StreetRequest(StreetEntity street) {
		super();
		this.id = street.getId();
		this.cep = street.getCep();
		this.street = street.getStreet();
		this.number = street.getNumber();
		this.complement = street.getComplement();
		this.district = street.getDistrict();
		this.city = street.getCity();
		this.state = street.getState();
	}
	
	public StreetRequest(int id, ClientRequest client, String cep, String street, Integer number, String complement,
			String district, String city, String state) {
		super();
		this.id = id;
		this.client = client;
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClientRequest getClient() {
		return client;
	}
	public void setClient(ClientRequest client) {
		this.client = client;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
