package com.apresentacao.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.apresentacao.model.request.ClientRequest;

@Entity
@Table(name ="tbClient")
public class ClientEntity {
	@Id
	@SequenceGenerator(name = "client", sequenceName = "sq_tb_client", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client")
	@Column(name = "idClient")
	private int id;

	@OneToMany(mappedBy = "client")
	private List<CartonEntity> carton;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idStreet")
	private StreetEntity street;
	
	@OneToMany(mappedBy = "client")
	private List<SaleEntity> sale;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "dt_Insert")
	@CreationTimestamp
	private Calendar dateInsert;

	@Column(name = "dt_Update")
	@UpdateTimestamp
	private Calendar dateUpdate;
	
	public ClientEntity() {
		super();
	}
	
	public ClientEntity(StreetEntity street, String name, String phone, String cpf) {
		super();
		this.street = street;
		this.name = name;
		this.phone = phone;
		this.cpf = cpf;
	}

	public ClientEntity(ClientRequest client) {
		super();
		if(client.getId() != 0)
			this.id = client.getId();
		
		if(client.getStreet() != null)
			this.street = new StreetEntity(client.getStreet());
		
		this.name = client.getName();
		this.phone = client.getPhone();
		this.cpf = client.getCpf();
	}

	public ClientEntity(int id, List<CartonEntity> carton, StreetEntity street, List<SaleEntity> sale, String name,
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

	public List<CartonEntity> getCarton() {
		return carton;
	}

	public void setCarton(List<CartonEntity> carton) {
		this.carton = carton;
	}

	public StreetEntity getStreet() {
		return street;
	}

	public void setStreet(StreetEntity street) {
		this.street = street;
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