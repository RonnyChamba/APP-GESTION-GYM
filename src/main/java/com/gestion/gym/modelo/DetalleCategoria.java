package com.gestion.gym.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "DETALLE_CATEGORIAS")
public class DetalleCategoria {
	
	/**
	 * Embeber las clave primary compuesta
	 */
	@EmbeddedId
	private DetalleCategoriaPK detalleCategoriaPK;
	
	/**
	 * La definición insertable=false, updatable=false es útil cuando necesita asignar un campo más de una vez en una entidad, 
	 * por lo general:
	 *  * cuando se usa una clave compuesta
	 *  * cuando se usa una clave primaria compartida
	 *  * entre otras
	 *  * link {@link #https://stackoverflow.com/questions/3805584/please-explain-about-insertable-false-and-updatable-false-in-reference-to-the-jp}
	 * 
	 *  Con detalleCategoriaPK ya definimos clave primary compuesta de DetalleCategoria, pero en nuestro caso, deseamos que además sean claves foraneas, 
	 *  cada campo de clave primary compuesta debe relacionarse con una tabla, 'Categoria' y 'Ejercicio'. Necesitamos añadir el mapeo de relaciones. ;
	 * 
	 * Mapeamos normalmente, pero añadimos @JoinColumn y los atributos insertable y updatable en false, con el indicamos  a JPA que no cree 
	 * una nueva columna id_categoria en DetalleCategoria (ya existe, es parte de la clave primary), sino, indicamos que Categoria se relacionada 
	 * con id_categoria de DetalleCategoria( estamos conviertindo en clave foranea tambien). 
	 * 
	 * Lo mismo hacemos con Ejercicio.
	 * 
	 * Si no ubicamos insertable y updatable en false, JPA intentara crear una nueva column id_categoria en DetalleCategoria, por lo que dará
	 * un error, ya que id_categoria ya existe.
	 *  
	 */
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;
	
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "id_ejercicio", insertable = false, updatable = false)
	private Ejercicio ejercicio;
	
	public DetalleCategoria() {
		detalleCategoriaPK = new DetalleCategoriaPK();
	}
	
	public DetalleCategoriaPK getDetalleCategoriaPK() {
		
		return detalleCategoriaPK;
	}
	
	/*
	public void setDetalleCategoriaPK(DetalleCategoriaPK detalleCategoriaPK) {
		this.detalleCategoriaPK = detalleCategoriaPK;
	}*/
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public Ejercicio getEjercicio() {
		return ejercicio;
	}


	@Override
	public String toString() {
		return "DetalleCategoria [detalleCategoriaPK=" + detalleCategoriaPK + "]";
	}
	
	
	
	
}
