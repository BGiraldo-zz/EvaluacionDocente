package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * clase para el manejo de la asignatura 
 * con sus datos correspondientes
 * @author Giraldo
 *
 */

@Entity
@Table(name="T_ASIGNATURA")
public class Asignatura implements Serializable{

	/* Atributos */
	
	@Id
	@Column(name="ID_ASIGNATURA", length = 45, nullable = false)
	private String id;
	
	@Column(name="Nombre", length = 255, nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="ID_PROGRAMA", nullable = false)
	private Programa programa;

	/* Constructor */
	
	public Asignatura(String id, String nombre, Programa programa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.programa = programa;
	}
	
	public Asignatura(){
		
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

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
	
}
