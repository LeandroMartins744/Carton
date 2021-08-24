package com.apresentacao.bussiness;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.apresentacao.dao.SaleDao;
import com.apresentacao.entity.SaleEntity;
import com.apresentacao.model.request.PartionRequest;
import com.apresentacao.model.request.SaleRequest;
import com.apresentacao.model.response.ProtocolResponse;
import com.apresentacao.model.response.SaleResponse;
import com.apresentacao.util.Validations;

@Component
public class SaleBussiness extends GenericBussiness {
	
	@Autowired
	private SaleDao saleDao;

	@Autowired
	private CartonBussiness cartonBussiness;
	
	@Autowired
	private ProductBussiness productBussiness;
	
	@Autowired
	private ClientBussiness clientBussiness;
	
	private List<PartionRequest> partionList;
	private Double rest = 0.0;
	private Double valueSale = 0.0;
	private SaleEntity entity;
	
	public SaleBussiness() {
		partionList = new ArrayList<PartionRequest>();
	}
	
	public ProtocolResponse Insert(SaleRequest obj) throws Exception{
		try {
			obj.setValue(obj.getProduct().getValue());
			entity = new SaleEntity(obj);
			
			this.Sale();
			return this.response(200, this.Result(obj));
		}
		catch (Exception e) {
			return this.response(500, e);
		}
	}
	
	private void SaleSave(Boolean approved) throws Exception {
		entity.setApproved(approved);
		saleDao.Cadastrar(entity);
	}
	
	private void Sale() throws Exception {
		try {
			cartonBussiness.LimitCarton(entity.getCarton().getId(), entity.getValue());
			this.entity.setClient(clientBussiness.ClientFind(entity.getClient().getId()));
			this.entity.setProduct(productBussiness.ProductFind(entity.getProduct().getId()));
			this.DivisorRest(entity.getProduct().getValue(), entity.getPartion());
			this.Divisor(entity.getProduct().getValue(), entity.getPartion());
			this.SaleSave(true);
		}
		catch (Exception e) {
			this.SaleSave(false);
		}
	}
	
	private SaleResponse Result(SaleRequest obj) {
		return new SaleResponse(obj, partionList);
	}

	private void DivisorRest(Double value, Integer partion) {
		valueSale = value / partion;
		String valueNew = Validations.FormatDouble(2, valueSale);
	    valueSale = Double.parseDouble(valueNew.replace(".", "").replace(",", "."));
	    rest = value - (valueSale * partion);
	}
	
	private void Divisor(Double value, Integer partion) {
		partionList.clear();
		for (int i = 1; i < (partion + 1); i++) {
			valueSale = i == partion ? (valueSale + rest) : valueSale;
			partionList.add(new PartionRequest(valueSale, i));
		}
	}
}
