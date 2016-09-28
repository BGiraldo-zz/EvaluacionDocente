package co.edu.eam.ingesoft.pa.negocio.dto;

import java.util.List;

import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

public class ResponderEvaluacionGrupoDTO {

	private List<RespuestaPreguntaDTO> preguntasRespondidas;
	
	private String codigoEst, cedulaEst;
	
	private Evaluacion evaluacion;
	
	private Respuesta respuesta;

	/**
	 * @param preguntasRespondidas
	 * @param codigoEst
	 * @param cedulaEst
	 * @param evaluacion
	 * @param respuesta
	 */
	public ResponderEvaluacionGrupoDTO(List<RespuestaPreguntaDTO> preguntasRespondidas, String codigoEst,
			String cedulaEst, Evaluacion evaluacion, Respuesta respuesta) {
		this.preguntasRespondidas = preguntasRespondidas;
		this.codigoEst = codigoEst;
		this.cedulaEst = cedulaEst;
		this.evaluacion = evaluacion;
		this.respuesta = respuesta;
	}

	/**
	 * 
	 */
	public ResponderEvaluacionGrupoDTO() {
	}

	public List<RespuestaPreguntaDTO> getPreguntasRespondidas() {
		return preguntasRespondidas;
	}

	public void setPreguntasRespondidas(List<RespuestaPreguntaDTO> preguntasRespondidas) {
		this.preguntasRespondidas = preguntasRespondidas;
	}

	public String getCodigoEst() {
		return codigoEst;
	}

	public void setCodigoEst(String codigoEst) {
		this.codigoEst = codigoEst;
	}

	public String getCedulaEst() {
		return cedulaEst;
	}

	public void setCedulaEst(String cedulaEst) {
		this.cedulaEst = cedulaEst;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}


	
	
}
