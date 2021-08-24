package com.apresentacao.model.request;

import java.io.Serializable;

public class PartionRequest  implements Serializable {

	private static final long serialVersionUID = -8968346637597876352L;
	
	private Double value;
	private Integer item;
	
	public PartionRequest() {
		super();
	}
	public PartionRequest(Double value, Integer item) {
		super();
		this.value = value;
		this.item = item;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	
	
}
