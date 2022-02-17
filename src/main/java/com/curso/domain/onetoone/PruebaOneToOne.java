package com.curso.domain.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		try {
		em.getTransaction().begin();
		
		//Crear un record
		
		Record rec =new Record(2,"Record Dos");
		//em.persist(rec);
		//Ya no hago persist
		
		//crear un cliente
		
		Customer cliente = new Customer(3,"Maria");
		cliente.setRecord(rec);
		em.persist(cliente);
		em.getTransaction().commit();
	}catch(Exception e) {
		em.getTransaction().rollback();
		e.printStackTrace();
	}
		
		//Buscar un cliente para ver sus datos y datos de su record
		//Customer cliente = em.find(Customer.class, 1);
		
		//System.out.printf("El cliente id %d es %s y tiene un registro %s. %n", cliente.getId(), cliente.getCustomerName(), cliente.getRecord().getRecordName());
		
	}

}
