package com.apresentacao.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.apresentacao.model.request.CartonRequest;
import com.apresentacao.util.EnumFlag;

@Entity
@Table(name ="tbCarton")
public class CartonEntity {
	@Id
	@SequenceGenerator(name = "carton", sequenceName = "sq_tb_carton", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carton")
	@Column(name = "idCarton")
	private int id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idClient")
	private ClientEntity client;
	
	@OneToMany(mappedBy = "carton")
	private List<SaleEntity> sale;
	
	@Column(name = "flag")
	@Enumerated(EnumType.STRING)
	private EnumFlag flag;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "number", nullable = false, length = 16)
	private String number;
	
	@Column(name = "date", nullable = false, length = 5)
	private String date;
	
	@Column(name = "code", nullable = false, length = 3)
	private String code;
	
	@Column(name = "limit", nullable = false)
	private Double limit;
	
	@Column(name = "dt_Insert")
	@CreationTimestamp
	private Calendar dateInsert;

	@Column(name = "dt_Update")
	@UpdateTimestamp
	private Calendar dateUpdate;

	public CartonEntity() {
		super();
	}

	public CartonEntity(CartonRequest carton) {
		super();
		if(carton.getClient() != null)
			this.client = new ClientEntity(carton.getClient());
		if(carton.getId() != 0)
			this.id = carton.getId();
		this.flag = carton.getFlag();
		this.name = carton.getName();
		this.number = carton.getNumber();
		this.date = carton.getDate();
		this.code = carton.getCode();
		this.limit = carton.getLimit();
	}
	
	public CartonEntity(ClientEntity client, EnumFlag flag, String name, String number, String date, String code,
			Double limit) {
		super();
		this.client = client;
		this.flag = flag;
		this.name = name;
		this.number = number;
		this.date = date;
		this.code = code;
		this.limit = limit;
	}



	public CartonEntity(int id, ClientEntity client, List<SaleEntity> sale, EnumFlag flag, String name, String number,
			String date, String code, Double limit) {
		super();
		this.id = id;
		this.client = client;
		this.sale = sale;
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

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public List<SaleEntity> getSale() {
		return sale;
	}

	public void setSale(List<SaleEntity> sale) {
		this.sale = sale;
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
