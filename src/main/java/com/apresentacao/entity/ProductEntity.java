package com.apresentacao.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.apresentacao.model.request.ProductRequest;

@Entity
@Table(name ="tbProduct")
public class ProductEntity {
	@Id
	@SequenceGenerator(name = "product", sequenceName = "sq_tb_product", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product")
	@Column(name = "idProduct")
	private int id;
	
	@OneToMany(mappedBy = "product")
	private List<SaleEntity> sale;

	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "description", nullable = true, length = 200)
	private String description;
	
	@Column(name = "value", nullable = false)
	private Double value;
	
	@Column(name = "inventory", nullable = false)
	private Integer inventory;
	
	@Column(name = "dt_Insert")
	@CreationTimestamp
	private Calendar dateInsert;

	@Column(name = "dt_Update")
	@UpdateTimestamp
	private Calendar dateUpdate;
	
	public ProductEntity() {
		super();
	}

	
	public ProductEntity(String name, String description, Double value, Integer inventory) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
		this.inventory = inventory;
	}

	public ProductEntity(ProductRequest product) {
		super();
		if(product.getId() != 0)
			this.id = product.getId();
		
		this.name = product.getName();
		this.description = product.getDescription();
		this.value = product.getValue();
		this.inventory = product.getInventory();
	}

	public ProductEntity(int id, List<SaleEntity> sale, String name, String description, Double value,
			Integer inventory) {
		super();
		this.id = id;
		this.sale = sale;
		this.name = name;
		this.description = description;
		this.value = value;
		this.inventory = inventory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<SaleEntity> getSale() {
		return sale;
	}

	public void setSale(List<SaleEntity> sale) {
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
	
	public Calendar getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Calendar dateInsert) {
		this.dateInsert = dateInsert;
	}

	public Calendar getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Calendar dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
}
