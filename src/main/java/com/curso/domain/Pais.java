package com.curso.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//atributos
	@Id
	@Column(name="COUNTRY_ID")
	private String codigoPais;  //PK
	@Column(name="COUNTRY_NAME")
	private String nombrePais;
	
	
	@Column(name="REGION_ID")
	private Integer idRegion;
	
	//const
	public Pais() {
		super();
	}

	public Pais(String codigoPais, String nombrePais, Integer idRegion) {
		super();
		this.codigoPais = codigoPais;
		this.nombrePais = nombrePais;
		this.idRegion = idRegion;
	}

	//gettes y settes
	
	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	// equals y hashcode

	@Override
	public int hashCode() {
		return Objects.hash(codigoPais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codigoPais, other.codigoPais);
	}

	@Override
	public String toString() {
		return "Pais [codigoPais=" + codigoPais + ", nombrePais=" + nombrePais + ", idRegion=" + idRegion + "]";
	}
	

}
