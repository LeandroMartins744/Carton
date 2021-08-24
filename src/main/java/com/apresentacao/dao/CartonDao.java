package com.apresentacao.dao;

import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.apresentacao.entity.CartonEntity;

@Repository
public class CartonDao extends GenericDao<CartonEntity, Integer> {

	public CartonDao() {
		this.em = Persistence.createEntityManagerFactory("apresentacao").createEntityManager();
	}
	
	public Boolean AlterLimit(Integer id, Double value) {
		try {
			this.em.getTransaction().begin();
			this.em.createQuery("update CartonEntity set limit = :value where id = :id")
				.setParameter("value", value)
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
