package com.curso.jpa;

import javax.persistence.*;

import com.curso.domain.Pais;

public class Application
{
	public static void main( String[] args ){
		
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		
		System.out.println("Buscar el pais con código FR");
		
		//SELECT POR PK
		Pais p = em.find(Pais.class, "FR");
		//p si esta sincronizado con la BD 
		//es el EntityMAnager em el que lo gestiona
		
		System.out.println(p);
		
		//INSERT UN NUEVO PAIS
		//Pais pNuevo = new Pais("JU","Jupiter",1);  
		//aqui objeto Pais desconectado de la BD (no sincronizado)
		
//		em.getTransaction().begin();
//		
//		em.persist(pNuevo);
//	
//		em.getTransaction().commit();
//		
		
		//DELETE
		em.getTransaction().begin();
		Pais pAborrar = em.find(Pais.class, "JU");
		// em obtien de la base de datos los datos del pais JU
		// me devuelve el objeto 
		// y sigue sincronizado cno la bd
		em.remove(pAborrar);
		
		em.getTransaction().commit();
		
		
		
		
		
		
		
		
		
		
	}//fin main
}