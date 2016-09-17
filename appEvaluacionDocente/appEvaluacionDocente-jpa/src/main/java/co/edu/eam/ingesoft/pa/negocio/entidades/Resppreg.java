package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase intermedia para manejo  y 
 * control de respuestas 
 * @author Giraldo
 *
 */

//@Entity
@Table(name="T_RESPPREG")

public class Resppreg implements Serializable{

	/* Atributos */
	
	@Id
	@ManyToOne
	@JoinColumn(name="ID_RESPUESTA", nullable=false)
	private Respuesta respuesta;
	
	@Id
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="ID_PREGUNTA", referencedColumnName="ID_PREGUNTA"),
        @JoinColumn(name="ID_EVALUACION", referencedColumnName="ID_EVALUACION")
    })
    private Pregeval pregeval;
    
    @Column(name="CALIFICACION", nullable = false)
    private double calificacion;

    
    /* Constructor */
    
	public Resppreg(Respuesta respuesta, Pregeval pregeval, double calificacion) {
		super();
		this.respuesta = respuesta;
		this.pregeval = pregeval;
		this.calificacion = calificacion;
	}

	public Resppreg() {
	
	}

	/* Getters and Setters */
	
	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Pregeval getPregeval() {
		return pregeval;
	}

	public void setPregeval(Pregeval pregeval) {
		this.pregeval = pregeval;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	
}
