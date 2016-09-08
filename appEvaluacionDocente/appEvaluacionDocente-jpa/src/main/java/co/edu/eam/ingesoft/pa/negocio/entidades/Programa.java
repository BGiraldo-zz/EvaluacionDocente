package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * clase para el manejo de los datos 
 * de un programa
 * @author Giraldo
 */

@Entity
@Table(name="T_PROGRAMA")
@NamedQueries({ @NamedQuery(name= Programa.LISTAR_PROGRAMAS, query = "Select p from Programa p")})
public class Programa  implements Serializable{

	/* Atributos */
	
	public static final String LISTAR_PROGRAMAS = "Programa.listarTodos";
	
	@Id
	@Column(name="ID_PROGRAMA", length = 45, nullable=false)
	private String id;
	
	@Column(name="NOMBRE", length = 45, nullable=false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="ID_FACULTAD", nullable=false)
	private Facultad facultad;

	/* Constructor */

	public Programa(String id, String nombre, Facultad facultad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
	}
	
	public Programa(){
		
	}

	/* Getters And Setters */
	
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

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return id + " - " +nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultad == null) ? 0 : facultad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programa other = (Programa) obj;
		if (facultad == null) {
			if (other.facultad != null)
				return false;
		} else if (!facultad.equals(other.facultad))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	

}
