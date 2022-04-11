package com.gestion.gym.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * Clase que permite crear una clave primary compuesta.
 * Tenga en cuenta que @Embeddable simplemente permite crear  clave primary con varios campos.
 * 
 * Si la clave primary compuesta además son claves foraneas, debe especificar las anotaciones de relaciones
 * en las clase que consume esta clave compuesta, no en esta clase.
 * 
 * @author user
 *
 */

@Embeddable
public class DetalleCategoriaPK  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	@Column(name = "id_ejercicio")
	private Integer idEjercicio;
	
	public DetalleCategoriaPK() {}
	
	public DetalleCategoriaPK(Integer idCategoria, Integer idEjercicio) {
		
		this.idCategoria = idCategoria;
		this.idEjercicio = idEjercicio;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdEjercicio() {
		return idEjercicio;
	}
	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}
	@Override
	public String toString() {
		return "DetalleCategoriaPK [idCategoria=" + idCategoria + ", idEjercicio=" + idEjercicio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, idEjercicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCategoriaPK other = (DetalleCategoriaPK) obj;
		return Objects.equals(idCategoria, other.idCategoria) && Objects.equals(idEjercicio, other.idEjercicio);
	}
	
}
