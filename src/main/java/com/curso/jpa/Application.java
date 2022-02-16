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
		if(pAborrar != null) {
			em.remove(pAborrar);
		}

		em.getTransaction().commit();
		
		//MODIFICAR
		
		//MODO 1  - find
		em.getTransaction().begin();
		//busco el pais a modificar  
		System.out.println(".... busco jp");
		Pais japon = em.find(Pais.class, "JP");
		System.out.println(".... busco jp otra vez");
		japon = em.find(Pais.class, "JP");
		System.out.println("modificar ");
		//cambio valores
		japon.setNombrePais("Es Japón2");
		//commit sincronizara los datos obj RAM con los datos TABLA
		em.getTransaction().commit();
	
		//MODO 2  - merge
		em.getTransaction().begin();
		Pais pModificar = new Pais("JP","Japan**",3);
		
		//modo find
		//Pais pBD = em.find(Pais.class, pModificar.getCodigoPais());
		//pBD.setIdRegion(pModificar.getIdRegion());
		//pBD.setNombrePais(pModificar.getNombrePais());
		//mas para todos los campos de la clase Pais
		
		Pais pBD  = em.merge(pModificar);
		// aqui pModificar sigue no sincronizado con la bd
		// aqui pBD esta gestionado por em y sincronizado con la bd
		
		pBD.setNombrePais("OTRO"); //si cambia bd
		
		pModificar.setNombrePais("OTRO"); // no cambia bd
		
		
		em.getTransaction().commit();
		
	
		
	
		
		
		
		
		
	}//fin main
}