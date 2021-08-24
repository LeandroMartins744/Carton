package com.apresentacao.dao;

import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import com.apresentacao.entity.SaleEntity;

@Repository
public class SaleDao extends GenericDao<SaleEntity, Integer> {

	public SaleDao() {
		this.em = Persistence.createEntityManagerFactory("apresentacao").createEntityManager();
	}
}
