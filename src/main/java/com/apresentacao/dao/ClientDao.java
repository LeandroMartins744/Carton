package com.apresentacao.dao;

import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

import com.apresentacao.entity.ClientEntity;

@Repository
public class ClientDao extends GenericDao<ClientEntity, Integer> {

	public ClientDao() {
		this.em = Persistence.createEntityManagerFactory("apresentacao").createEntityManager();
	}
	
	public ClientEntity SearchCpf(String cpf) {
		return em.createQuery("from ClientEntity where cpf = :cpf ", ClientEntity.class)
				.setParameter("cpf", cpf)
				.getSingleResult();
	}
}
