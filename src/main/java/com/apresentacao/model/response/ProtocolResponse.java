package com.apresentacao.model.response;

import java.io.Serializable;

public class ProtocolResponse implements Serializable {

	private static final long serialVersionUID = -8807640466862448596L;
	
	private Integer status;
	private Object data;
	
	public ProtocolResponse() {
		super();
	}
	
	public ProtocolResponse(Integer status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}
