package co.edu.eam.ingesoft.pa.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para : Manejar los datos de los coordinadores
 * 
 * @author Giraldo
 */

@Entity
@Table(name = "T_COORDINADOR")
public class Coordinador extends Usuario {

	/* Atributos */

	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMA", nullable = false)
	private Programa programa;

	/* Constructor */

	public Coordinador() {

	}

	public Coordinador(int id, String nombre, String apellido, String usuario, String pass, Programa programa) {
		super(id, nombre, apellido, usuario, pass);
		this.programa = programa;
	}
	
	/* Getters y Setters */

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}	

}
