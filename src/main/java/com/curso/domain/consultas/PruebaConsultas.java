package com.curso.domain.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.domain.*;
import com.curso.domain.onetomany.Orders;

public class PruebaConsultas {

	public static void main(String[] args) {
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = fc.createEntityManager();
	
		//JPA query
		
		
		//trabajan con entidades no con tablas
		//CreareQuery
		
//		//String consulta1= "SELECT p FROM Pais p";//Select * FROM COUNTRIES
//		String consulta1= "SELECT p FROM Pais p where p.idRegion= 1";//Select * FROM COUNTRIES
//		
//		Query q = em.createQuery(consulta1);
//		
//		List<Pais>paises=q.getResultList();
//		
//		for(Pais p:paises) {
//			System.out.println(p);
//		}
		
//		//CreateNamedQuery
//		Query nq = em.createNamedQuery("Pais.findAll");
//		List<Pais>otralista=nq.getResultList();
//		for(Pais p:otralista) {
//			System.out.println(p);
//		}
//		
		//(Otra)CreateNamedQuery
		Query nq = em.createNamedQuery("Pais.findByRegion");
		nq.setParameter("idReg", 1);
		List<Pais>otralista=nq.getResultList();
		for(Pais p:otralista) {
			System.out.println(p);
		}
		
		//nativequery
		Query consultaNativa=em.createNamedQuery("Select * FROM COUNTRIES");
		List <Object> resultado = consultaNativa.getResultList();
		
		//solo para que te devuelva uno, si devolviese 1   q.getSingleResult();
		
		
		
		//Cosultar los pedidos del cliente Luis Ramos
		Query nq1 = em.createNamedQuery("Orders.findByCustomer");
		nq.setParameter("idCus", 1);
		List<Orders>listaped=nq1.getResultList();
		for(Orders o:listaped) {
			System.out.println(o);
		}
		
		//consultar los clientes que no tienen pedido
		

	}//Main

}
