package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Clase para el manejo del usuario con sus datos basicos
 * 
 * @author Giraldo
 */

@Entity
@Table(name = "T_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name=Usuario.BUSCAR_POR_USERNAME, query="SELECT u FROM Usuario u WHERE u.usuario = ?1 ")})

public class Usuario implements Serializable {

	/* Atributos */
	
	public static final String BUSCAR_POR_USERNAME = "Usuario.buscarUser";

	@Id
	@Column(name = "ID_USUARIO", length = 12, nullable = false)
	protected int id;

	@Size(min = 3, max = 45, message = "La longitud del nombre es incorrecta")
	@Column(name = "NOMBRE", length = 45, nullable = false)
	protected String nombre;

	@Size(min = 3, max = 45, message = "La longitud del apellido es incorrecta")
	@Column(name = "APELLIDO", length = 45, nullable = false)
	protected String apellido;

	@Size(min = 3, max = 45, message = "La longitud del usuario es incorrecta")
	@Column(name = "USUARIO", length = 45, nullable = false, unique=true)
	protected String usuario;

	@Size(min = 3, max = 45, message = "La longitud del password es incorrecta")
	@Column(name = "PASS", length = 45, nullable = false)
	protected String pass;

	/* Constructor */

	public Usuario(int id, String nombre, String apellido, String usuario, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.pass = pass;
	}

	public Usuario() {

	}

	/* Getters y Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
