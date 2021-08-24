package com.apresentacao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.apresentacao.model.request.StreetRequest;

@Entity
@Table(name ="tbStreet")
public class StreetEntity {
	@Id
	@SequenceGenerator(name = "street", sequenceName = "sq_tb_street", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street")
	@Column(name = "idStreet")
	private int id;
	
	@OneToOne(mappedBy = "street")
	private ClientEntity client;

	@Column(name = "cep", nullable = false, length = 9)
	private String cep;
	
	@Column(name = "street", nullable = false, length = 200)
	private String street;
	
	@Column(name = "number", nullable = false)
	private Integer number;
	
	@Column(name = "complement", nullable = true, length = 20)
	private String complement;
	
	@Column(name = "district", nullable = false, length = 30)
	private String district;
	
	@Column(name = "city", nullable = false, length = 30)
	private String city;
	
	@Column(name = "state", nullable = false, length = 2)
	private String state;
	
	public StreetEntity() {
		super();
	}

	public StreetEntity(String cep, String street, Integer number, String complement, String district, String city,
			String state) {
		super();
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
	}

	public StreetEntity(StreetRequest street) {
		super();
		this.cep = street.getCep();
		this.street = street.getStreet();
		this.number = street.getNumber();
		this.complement = street.getComplement();
		this.district = street.getDistrict();
		this.city = street.getCity();
		this.state = street.getState();
	}


	public StreetEntity(int id, ClientEntity client, String cep, String street, Integer number, String complement,
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

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
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
