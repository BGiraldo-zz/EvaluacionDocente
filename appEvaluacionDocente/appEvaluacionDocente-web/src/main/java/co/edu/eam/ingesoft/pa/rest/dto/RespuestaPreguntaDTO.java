package co.edu.eam.ingesoft.pa.rest.dto;

import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

public class RespuestaPreguntaDTO {

	private Pregunta pregunta;
	
    private Respuesta respuesta;

    private Evaluacion evaluacion;
    
    private double calificacion;

	/**
	 * @param pregunta
	 * @param respuesta
	 * @param evaluacion
	 * @param calificacion
	 */
	public RespuestaPreguntaDTO(Pregunta pregunta, Respuesta respuesta, Evaluacion evaluacion, double calificacion) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.evaluacion = evaluacion;
		this.calificacion = calificacion;
	}

	/**
	 * 
	 */
	public RespuestaPreguntaDTO() {
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

    
    
    
	
}
