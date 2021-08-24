package com.apresentacao.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apresentacao.dao.ProductDao;
import com.apresentacao.entity.ProductEntity;
import com.apresentacao.model.request.ProductRequest;
import com.apresentacao.model.response.ProtocolResponse;

@Component
public class ProductBussiness extends GenericBussiness {
	
	@Autowired
	private ProductDao productDao;
	
	public ProtocolResponse Insert(ProductRequest obj) {
		try {
			ProductEntity entity = new ProductEntity(obj);
			productDao.Cadastrar(entity);
			return this.response(200, true);
		}
		catch (Exception e) {
			return this.response(500, e);
		}
	}
	
	public ProtocolResponse List() {
		try {
			List<ProductEntity> cliente = productDao.Lista();
			return this.response(200, new ProductRequest().ProductMapperRequest(cliente));
		}
		catch (Exception e) {
			return this.response(201, e);
		}
	}
	
	public ProductEntity ProductFind(Integer id) throws Exception {
		ProductEntity product = productDao.Buscar(id);
		if(product == null)
			throw new Exception("Produto não encontrado");
		else if(product.getInventory() > 0) {
			productDao.AlterInventory(product.getId(), product.getInventory() - 1);
			return product;
		}
		else
			throw new Exception("Produto sem estoque");
	}
}
