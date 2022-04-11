package com.gestion.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.gym.modelo.DetalleCategoria;
import com.gestion.gym.modelo.DetalleCategoriaPK;

@Repository
public interface DetalleCategoriaRepository  extends JpaRepository<DetalleCategoria, DetalleCategoriaPK>{
	
	/**
	 * Elminar un registro mediante su clave primary compuesta.
	 * Para los metodos Query DML y DDL , es necesario @Modifing, 
	 * @param detallePrimaryKey
	 */
	@Modifying
	@Query("delete from DetalleCategoria dt  where dt.detalleCategoriaPK =:detallePrimary")
	void deleteByCustomId(@Param("detallePrimary") DetalleCategoriaPK detallePrimaryKey);
	
	/**
	 * Método para actualizar la categoria a la que pertenece un ejercicio en {@link DetalleCategoria} 
	 * @param detallePrimaryKey
	 */
	@Modifying
	@Query("update DetalleCategoria dt set dt.detalleCategoriaPK.idCategoria=:idCategoria  where dt.detalleCategoriaPK =:detallePrimary")
	void updateDetalleCategoria(@Param("idCategoria") Integer idCategoria,
								@Param("detallePrimary") DetalleCategoriaPK detallePrimaryKey);
	
}
