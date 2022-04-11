package com.gestion.gym;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion.gym.admin.AdminCategoria;
import com.gestion.gym.admin.AdminDetalleCategoria;
import com.gestion.gym.admin.AdminEjercicio;

/**
 * Implementar CommandLineRunner para hacer una app de consola, sobrrescribir el
 * metodo run, equivalente al main, podemos utilizar cualquier modulo de spring,
 * obviamente, exepcto el web
 * 
 * @author user
 *
 */

@SpringBootApplication
public class DemoPrimarykeyApplication implements CommandLineRunner {

	@Autowired
	private AdminEjercicio adminEjercicio;
	
	@Autowired
	private AdminCategoria adminCategoria;
	
	@Autowired
	private AdminDetalleCategoria adminDetalle;

	public static void main(String[] args) {
		SpringApplication.run(DemoPrimarykeyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//crudEjercicio();
		//crudCategoria();
		
		crudDetalle();
	}

	public void crudEjercicio() {

		//adminEjercicio.agregar("CAMINADORA");

		// adminEjercicio.update(8, "CAMINADORAS");

		// adminEjercicio.delete(8);

		// adminEjercicio.listar();

		adminEjercicio.listarPorCategoria("BICEPS");
	}
	
	public void crudCategoria() {
		
		//adminCategoria.agregar("HOMBROS");
		
		//adminCategoria.update(6, "HOMBRO");
		
		//adminCategoria.delete(6);
		
		//adminCategoria.listar();
		
		adminCategoria.listarPorEjercicio("ESTIRADAS");
	}
	
	public void crudDetalle() {
		
		 //adminDetalle.agregar(2, 9);
		
		/*DetalleCategoria nuevo = new DetalleCategoria();
		nuevo.getDetalleCategoriaPK().setIdCategoria(2);
		nuevo.getDetalleCategoriaPK().setIdEjercicio(9);

		adminDetalle.update( nuevo, 8);
		
		*/
		//adminDetalle.delete(8, 9);
	
		adminDetalle.list();
	}
	
	

}
