package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

public class RespregPK implements Serializable{

	private String respuesta;
	
	private PregevalPK pregeval;

	/**
	 * @param respuesta
	 * @param pregeval
	 */
	public RespregPK(String respuesta, PregevalPK pregeval) {
		this.respuesta = respuesta;
		this.pregeval = pregeval;
	}

	/**
	 * 
	 */
	public RespregPK() {
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public PregevalPK getPregeval() {
		return pregeval;
	}

	public void setPregeval(PregevalPK pregeval) {
		this.pregeval = pregeval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pregeval == null) ? 0 : pregeval.hashCode());
		result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
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
		RespregPK other = (RespregPK) obj;
		if (pregeval == null) {
			if (other.pregeval != null)
				return false;
		} else if (!pregeval.equals(other.pregeval))
			return false;
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		return true;
	}
	
	
	
}
