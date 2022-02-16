package com.curso.domain.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaOneToOne {

	
	public static void main(String[] args) {
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			//Crear un Record
//			Record rec = new Record(1,"Record Uno");
//			em.persist(rec);
//			
//			//Crear un Cliente
//			Customer cliente = new Customer(1,"Luis Ramos");
//			cliente.setRecord(rec);
//			em.persist(cliente);
//			
//			em.getTransaction().commit();
//		
//		}catch(Exception e ){
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		}
		
		//buscar un cliente para ver sus datos y datos de su record
//		Customer cliente = em.find(Customer.class, 1);
//		
//		System.out.printf("El cliente id %d es %s y tiene un registo %s. %n"
//				, cliente.getId()
//				, cliente.getCustomerName()
//				, cliente.getRecord().getRecordName());
//		
		
		// ANOTACION AÑADO PERSISTIR EN CASCADA Y PRUEBO
		
		try {
			em.getTransaction().begin();
			//Crear un Record
			Record rec = new Record(2,"Record Dos");
			//YA NO HAGO PERSIST
			
			//Crear un Cliente y record
			Customer cliente = new Customer(3,"Maria");
			cliente.setRecord(rec);
			em.persist(cliente);
			
			em.getTransaction().commit();
		
		}catch(Exception e ){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
	}//fin main
}
