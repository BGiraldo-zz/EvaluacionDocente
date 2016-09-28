package co.edu.eam.ingesoft.pa.negocio.dto;

import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

public class RespuestaPreguntaDTO {

	private Pregunta pregunta;
    
    private double calificacion;

	/**
	 * @param pregunta
	 * @param calificacion
	 */
	public RespuestaPreguntaDTO(Pregunta pregunta, double calificacion) {
		this.pregunta = pregunta;
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

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

}
