package com.apresentacao.model.response;

import java.io.Serializable;
import java.util.List;

import com.apresentacao.model.request.PartionRequest;
import com.apresentacao.model.request.SaleRequest;

public class SaleResponse implements Serializable {

	private static final long serialVersionUID = -2536375667834734926L;
	
	private SaleRequest sale;
	private List<PartionRequest> partion;
	
	public SaleResponse() {
		super();
	}
	
	public SaleResponse(SaleRequest sale, List<PartionRequest> partion) {
		super();
		this.sale = sale;
		this.partion = partion;
	}
	
	public SaleRequest getSale() {
		return sale;
	}
	public void setSale(SaleRequest sale) {
		this.sale = sale;
	}
	public List<PartionRequest> getPartion() {
		return partion;
	}
	public void setPartion(List<PartionRequest> partion) {
		this.partion = partion;
	}
	
	
}
