package com.gestion.gym.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que permite crear un clave primary compuesta, pero además, esas clave primaria tambien son foraneas
 * @author user
 *
 */

@Embeddable
public class DetalleCategoriaPK_2  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Ejercicio ejercicio;
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, ejercicio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCategoriaPK_2 other = (DetalleCategoriaPK_2) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(ejercicio, other.ejercicio);
	}
	
	
}

