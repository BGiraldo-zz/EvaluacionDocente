package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase para : controlar la entidad facultad
 * @author Giraldo
 */

@Entity
@Table(name="T_FACULTAD")
@NamedQueries({ @NamedQuery(name= Facultad.LISTAR_FACULTADES , query = "Select f from Facultad f")})
public class Facultad implements Serializable {

	/* Atributos */
	
	public static final String LISTAR_FACULTADES = "Facultad.listarTodos";
	
	@Id
	@Column(name="ID_FACULTAD", length = 45, nullable=false)
	private String id;
	
	@Column(name="NOMBRE", length = 45, nullable=false)
	private String nombre;

	/* Constructor */
	
	public Facultad(){
		
	}

	public Facultad(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return id + " - " + nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Facultad other = (Facultad) obj;
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
