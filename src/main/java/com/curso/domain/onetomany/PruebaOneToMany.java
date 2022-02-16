package com.curso.domain.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaOneToMany {

	
	public static void main(String[] args) {
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();

		try {
			em.getTransaction().begin();
			
			//1. Crear varios pedidos para el cliente 1
			
			
			//2. buscar los pedidos del cliente 1
			
			//3. borrar el último pedido del cliente 1
			

			em.getTransaction().commit();
		
		}catch(Exception e ){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
	}//fin main
}
