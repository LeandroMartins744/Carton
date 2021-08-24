package com.apresentacao.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apresentacao.entity.SaleEntity;

public class SaleRequest implements Serializable {
	
	private static final long serialVersionUID = -641832857978643236L;
	
	private int id;
	private ClientRequest client;
	private CartonRequest carton;
	private ProductRequest product;
	private Double value;
	private Integer partion;
	private Boolean approved;
	
	public SaleRequest() {
		super();
	}
	
	
	public SaleRequest(SaleEntity sale) {
		super();
		this.id = sale.getId();
		this.value = sale.getValue();
		this.partion = sale.getPartion();
		this.approved = sale.getApproved();
	}
	
	
	public List<SaleRequest> SaleMapperRequest(List<SaleEntity> sale) {
		List<SaleRequest> obj = new ArrayList<SaleRequest>();
		
		for (SaleEntity saleEntity : sale)
			obj.add(new SaleRequest(saleEntity));

		return obj;
	}
	
	public SaleRequest(int id, ClientRequest client, CartonRequest carton, ProductRequest product, Double value,
			Integer partion, Boolean approved) {
		super();
		this.id = id;
		this.client = client;
		this.carton = carton;
		this.product = product;
		this.value = value;
		this.partion = partion;
		this.approved = approved;
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
	public CartonRequest getCarton() {
		return carton;
	}
	public void setCarton(CartonRequest carton) {
		this.carton = carton;
	}
	public ProductRequest getProduct() {
		return product;
	}
	public void setProduct(ProductRequest product) {
		this.product = product;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getPartion() {
		return partion;
	}
	public void setPartion(Integer partion) {
		this.partion = partion;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	
}
