package com.apresentacao.dao;

import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import com.apresentacao.entity.ProductEntity;

@Repository
public class ProductDao extends GenericDao<ProductEntity, Integer> {

	public ProductDao() {
		this.em = Persistence.createEntityManagerFactory("apresentacao").createEntityManager();
	}
	
	public Boolean AlterInventory(Integer id, Integer i) {
		try {
			this.em.getTransaction().begin();
			this.em.createQuery("update ProductEntity set inventory = :value where id = :id")
				.setParameter("value", i)
				.setParameter("id", id)
				.executeUpdate();
			
			this.em.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
