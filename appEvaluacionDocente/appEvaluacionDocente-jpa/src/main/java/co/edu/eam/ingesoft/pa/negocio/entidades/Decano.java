package co.edu.eam.ingesoft.pa.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para : controlar la clase decano con sus datos
 * @author Giraldo
 *
 */

@Entity
@Table(name = "T_DECANO")
public class Decano extends Usuario {

	/* Atributos */

	@ManyToOne
	@JoinColumn(name = "ID_FACULTAD", nullable = false)
	private Facultad facultad;

	/* Constructor */

	public Decano(int id, String nombre, String apellido, String usuario, String pass, Facultad facultad) {
		super(id, nombre, apellido, usuario, pass);
		this.facultad = facultad;
	}


	public Decano() {

	}

	/* Getters y Setters */
	
	
	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

}
