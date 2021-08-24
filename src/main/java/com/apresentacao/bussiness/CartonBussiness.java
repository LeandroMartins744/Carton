package com.apresentacao.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apresentacao.dao.CartonDao;
import com.apresentacao.entity.CartonEntity;
import com.apresentacao.model.request.CartonRequest;
import com.apresentacao.model.response.ProtocolResponse;

@Component
public class CartonBussiness extends GenericBussiness {
	
	@Autowired
	private CartonDao cartonDao;
	
	public ProtocolResponse Insert(CartonRequest obj) {
		try {
			CartonEntity entity = new CartonEntity(obj);
			cartonDao.Cadastrar(entity);
			return this.response(200, true);
		}
		catch (Exception e) {
			return this.response(500, e);
		}
	}
	
	public void LimitCarton(Integer id, Double value) throws Exception {
		CartonEntity carton = cartonDao.Buscar(id);
		if(carton == null)
			throw new Exception("Cartão não encontrado");
		else if(carton.getLimit() <= value)
			throw new Exception("Saldo Insuficiente");
		else
			cartonDao.AlterLimit(carton.getId(), carton.getLimit() - value);
	}
}
