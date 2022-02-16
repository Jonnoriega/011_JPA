package com.curso.domain.onetoonebidireccional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaOneToOne {

	
	public static void main(String[] args) {
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();

		// busco un record y muestro el nombre del cliente
		
		Record rec = em.find(Record.class, 2);
		System.out.printf("El cliente de record 2 es %s. " , 
				  rec.getCliente().getCustomerName());
			
		
	}//fin main
}
