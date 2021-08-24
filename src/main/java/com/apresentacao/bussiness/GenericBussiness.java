package com.apresentacao.bussiness;

import com.apresentacao.model.response.ProtocolResponse;

public class GenericBussiness {

	protected ProtocolResponse result;
	
	public GenericBussiness() {
		result = new ProtocolResponse();
	}
	
	protected ProtocolResponse response(Integer status, Object obj) {
		this.result.setStatus(status);
		this.result.setData(obj);
		
		return result;
	}
}
