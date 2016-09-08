package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * maneja las respuestas dadas 
 * por cada usuario
 * @author Giraldo
 *
 */

@Entity
@Table(name="T_RESPUESTA")
public class Respuesta implements Serializable {

	
	/* Atributos */ 
	
	@Id
	@Column(name="ID_RESPUESTA", length = 45, nullable = false)
	private String id;
	
	@Column(name="FECHA_HORA", nullable = false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaHora;
	
	@Column(name = "COMENTARIO", nullable = true)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="ID_GRUPO", nullable = false)
	private Grupo grupo;

	/* Controladores */
	
	public Respuesta(String id, Date fecha_hora, String comentario, Grupo grupo) {
		super();
		this.id = id;
		this.fechaHora = fecha_hora;
		this.comentario = comentario;
		this.grupo = grupo;
	}

	public Respuesta() {

	}

	/* Getters y Setters */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha_hora() {
		return fechaHora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fechaHora = fecha_hora;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
