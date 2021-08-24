package com.apresentacao.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apresentacao.entity.ProductEntity;

public class ProductRequest implements Serializable {
	
	private static final long serialVersionUID = -7493538605715327709L;
	
	private int id;
	private List<SaleRequest> sale;
	private String name;
	private String description;
	private Double value;
	private Integer inventory;
	
	public ProductRequest() {
		super();
	}
	public ProductRequest(int id, List<SaleRequest> sale, String name, String description, Double value,
			Integer inventory) {
		super();
		this.id = id;
		this.sale = sale;
		this.name = name;
		this.description = description;
		this.value = value;
		this.inventory = inventory;
	}
	
	public ProductRequest(ProductEntity obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
		this.value = obj.getValue();
		this.inventory = obj.getInventory();
	}
	
	public List<ProductRequest> ProductMapperRequest(List<ProductEntity> obj){
		List<ProductRequest> list = new ArrayList<ProductRequest>();
		
		for (ProductEntity productRequest : obj)
			list.add(new ProductRequest(productRequest));
		
		return list;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
}
