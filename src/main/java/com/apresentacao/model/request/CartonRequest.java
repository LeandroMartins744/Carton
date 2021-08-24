package com.apresentacao.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apresentacao.entity.CartonEntity;
import com.apresentacao.util.EnumFlag;

public class CartonRequest implements Serializable {
	
	private static final long serialVersionUID = -8990028207211802095L;
	private static final String AJUST_NUMBER = "****.****.****.%s";
	
	private int id;
	private ClientRequest client;
	private EnumFlag flag;
	private String name;
	private String number;
	private String date;
	private String code;
	private Double limit;
	
	public CartonRequest() {
		super();
	}
	
	private String AjustNumberCard(String number) {
		number = number.substring(number.length() - 4, number.length());
		return String.format(AJUST_NUMBER, number);
	}
	
	public CartonRequest(CartonEntity carton) {
		super();
		this.id = carton.getId();
		this.flag = carton.getFlag();
		this.name = carton.getName();
		this.number = this.AjustNumberCard(carton.getNumber());
		this.limit = carton.getLimit();
	}
	
	public List<CartonRequest> CartonMapperRequest(List<CartonEntity> carton) {
		List<CartonRequest> cartons = new ArrayList<CartonRequest>();
		
		for (CartonEntity cartonEntity : carton)
			cartons.add(new CartonRequest(cartonEntity));
		
		return cartons;
	}
	
	public CartonRequest(int id, ClientRequest client,  EnumFlag flag, String name,
			String number, String date, String code, Double limit) {
		super();
		this.id = id;
		this.client = client;
		this.flag = flag;
		this.name = name;
		this.number = number;
		this.date = date;
		this.code = code;
		this.limit = limit;
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
	public EnumFlag getFlag() {
		return flag;
	}
	public void setFlag(EnumFlag flag) {
		this.flag = flag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	
	
}
