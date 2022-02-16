package com.curso.domain.onetomany;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.domain.onetoone.Record;



public class PruebaOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		
	try {
		em.getTransaction().begin();
//		//1. crear varios pedidos para el cliente 1
//		Customer cliente = em.find(Customer.class, 1);
//		Orders or1 =new Orders(1);
//		or1.setDescription("iPhone");
//		or1.setCustomer(cliente);
//		em.persist(or1);
//		
//		
//		Orders or2 =new Orders(2);
//		or2.setDescription("Dell ordenador");
//		or2.setCustomer(cliente);
//		em.persist(or2);
//		
//		Orders or3 =new Orders(3);
//		or3.setDescription("Cascos Xiaomi");
//		or3.setCustomer(cliente);
//		em.persist(or3);
		

		
		//2. buscar los pedidos de cliente 1
		
		Customer cliente1 = em.find(Customer.class, 1);
		if(cliente1 ==null) {
			System.out.println("Cliente 1 no existe");
		}else {
			if(cliente1.getOrdersCollection().size()==0) {
				System.out.println("no tiene pedidos");
			}else {
			for(Orders o:cliente1.getOrdersCollection()) {
				System.out.println(o.getDescription());
				}
			}
		}
		
		
		
		//3 borrar el ultmo pedido de cliente1
		Customer cliente = em.find(Customer.class, 1);
		if(!cliente.getOrdersCollection().isEmpty()) {
			
			List<Orders> list = (List<Orders>) cliente.getOrdersCollection();
			Orders ultimo = list.get(cliente.getOrdersCollection().size()-1);
			em.remove(ultimo);
		}
		
		
		
		
		
		em.getTransaction().commit();
	}catch(Exception e) {
		
		em.getTransaction().rollback();
		e.printStackTrace();
		
	}
		
	}
}
