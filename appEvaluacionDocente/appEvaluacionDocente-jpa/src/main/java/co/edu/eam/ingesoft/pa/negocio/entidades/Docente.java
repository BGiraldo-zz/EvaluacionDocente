package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para el manejo del docente en general con sus datos
 * 
 * @author Giraldo
 */

@Entity
@Table(name = "T_DOCENTE")
public class Docente implements Serializable{

	/* Atributos */

	@Id
	@Column(name = "ID_DOCENTE", nullable = false, length = 45)
	private String id;

	@Column(name = "NOMBRE", nullable = false, length = 45)
	private String nombre;

	@Column(name = "APELLIDO", nullable = false, length = 45)
	private String apellido;

	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMA", nullable = false)
	private Programa programa;

	/* Constructor */

	public Docente(String id, String nombre, String apellido, Programa programa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.programa = programa;
	}
	
	public Docente(){
		
	}

	/* Getters y Setters */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	
	
}
