package com.apresentacao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.apresentacao.entity.CartonEntity;
import com.apresentacao.entity.ClientEntity;
import com.apresentacao.entity.ProductEntity;
import com.apresentacao.entity.StreetEntity;
import com.apresentacao.util.EnumFlag;

public class SystemTest {

	public static void main(String[] args) {
		EntityManager factory = Persistence.createEntityManagerFactory("apresentacao").createEntityManager();
		
		//CreateMockTest(factory);
		
		factory.close();

	}
	
	private static void CreateMockTest(EntityManager factory) {
		StreetEntity street = new StreetEntity("09310000", "Rua Xyz", 123, "APTO01", "Centro", "São Paulo", "SP");
		ClientEntity client = new ClientEntity(street, "Leandro Silva", "11963636363", "11111111111");
		CartonEntity carton = new CartonEntity(client, EnumFlag.Mastercard, "Leandro S G Soares", "1234987685214321", "10/28", "123", 1352.00); 
		
		ProductEntity product1 = new ProductEntity("Produto 01", "Produto 01", 10.50, 100);
		ProductEntity product2 = new ProductEntity("Produto 02", "Produto 02", 2.95, 100);
		ProductEntity product3 = new ProductEntity("Produto 03", "Produto 03", 3.85, 100);
		ProductEntity product4 = new ProductEntity("Produto 04", "Produto 04", 22.99, 100);

		factory.persist(carton);
		
		factory.persist(product1);
		factory.persist(product2);
		factory.persist(product3);
		factory.persist(product4);
		
		factory.getTransaction().begin();
		factory.getTransaction().commit();
	}

}
