package co.edu.eam.ingesoft.pa.rest.dto;

import java.util.List;

public class ResponderEvaluacionGrupoDTO {

	private List<RespuestaPreguntaDTO> preguntasRespondidas;
	
	private String codigoEst, cedulaEst;

	/**
	 * @param preguntasRespondidas
	 * @param codigoEst
	 * @param cedulaEst
	 */
	public ResponderEvaluacionGrupoDTO(List<RespuestaPreguntaDTO> preguntasRespondidas, String codigoEst,
			String cedulaEst) {
		this.preguntasRespondidas = preguntasRespondidas;
		this.codigoEst = codigoEst;
		this.cedulaEst = cedulaEst;
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

	
	
	
}
