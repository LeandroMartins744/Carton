package com.apresentacao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import com.apresentacao.model.request.SaleRequest;

@Entity
@Table(name ="tbSale")
public class SaleEntity {
	@Id
	@SequenceGenerator(name = "sale", sequenceName = "sq_tb_sale", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale")
	@Column(name = "idSale")
	private int id;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private ClientEntity client;
	
	@ManyToOne
	@JoinColumn(name = "idCarton")
	private CartonEntity carton;
	
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private ProductEntity product;
	
	@Column(name = "value", nullable = false)
	private Double value;
	
	@Column(name = "partion", nullable = false, length = 200)
	private Integer partion;
	
	@Column(name = "approved", nullable = false)
	private Boolean approved;
	
	@Column(name = "dt_Insert")
	@CreationTimestamp
	private Calendar dateInsert;

	public SaleEntity() {
		super();
	}

	public SaleEntity(int id, ClientEntity client, CartonEntity carton, ProductEntity product, Double value,
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
	
	public SaleEntity(SaleRequest sale) {
		super();
		this.id = sale.getId();
		this.client = new ClientEntity(sale.getClient());
		this.carton = new CartonEntity(sale.getCarton());
		this.product = new ProductEntity(sale.getProduct());
		this.value = sale.getValue();
		this.partion = sale.getPartion();
		this.approved = sale.getApproved();
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

	public CartonEntity getCarton() {
		return carton;
	}

	public void setCarton(CartonEntity carton) {
		this.carton = carton;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
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
	public Calendar getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Calendar dateInsert) {
		this.dateInsert = dateInsert;
	}
}
