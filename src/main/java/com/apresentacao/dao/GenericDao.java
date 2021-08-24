package com.apresentacao.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T, K> {
	protected EntityManager em;
	private Class<T> clazz;
	
	private static String MSG_EXP_REMOVE = "Item não encontrado";
	private static String MSG_EXP_COMMIT = "Falha ao executar ação";
	private static String SQL_FROM = " from ";
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void Cadastrar(T entidade) throws Exception {
		em.persist(entidade);
		this.commit();
	}
	
	public void Alterar(T entidade) {
		em.merge(entidade);
	}
	
	public T Buscar(K chave) {
		return em.find(clazz, chave);
	}
	
	public void Remover(K chave) throws Exception {
		T entidade = this.Buscar(chave);
		if(entidade == null)
			throw new Exception(MSG_EXP_REMOVE);
		else
			em.remove(entidade);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> Lista() {
		return em.createQuery(SQL_FROM + clazz.getName()).getResultList();
	}
	
	public void commit() throws Exception{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}
		catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			
			throw new Exception(MSG_EXP_COMMIT);
		}
	}
}
