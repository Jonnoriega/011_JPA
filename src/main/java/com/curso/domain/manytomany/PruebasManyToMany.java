package com.curso.domain.manytomany;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebasManyToMany {

	public static void main(String[] args) {
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
		
		//1. crear un contacto
		em.getTransaction().begin();
		
//		Contacto luis = new Contacto();
//		luis.setNombre("Maria");
//		luis.setApellidos("Blanco");
//		luis.setEmail("mblanco@gmail.com");
//		luis.setFechaNac(new Date());
//		
//		em.persist(luis);
		//quiero meter el contacto 101 en los grupos 600 y 700
		
//		Grupo g1 = new Grupo(100,"red","VENTAS");
//
//		em.persist(g1);
//
//		Grupo g2 = new Grupo(200,"blue","COMUNICACIONES");
//
//		em.persist(g2);
		
		
		Contacto c = em.find(Contacto.class,101);
		Grupo g1 = em.find(Grupo.class, 100);
		Grupo g2 = em.find(Grupo.class, 200);
		
		c.getGrupoCollection().add(g1);
		c.getGrupoCollection().add(g2);
		
		
		
		em.getTransaction().commit();
	}//fin
	
}
