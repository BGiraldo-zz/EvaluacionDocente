package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

public class GrupoEstudiantePK implements Serializable{

	private String grupo;
	
	private String cedulaEstudiante;

	/**
	 * @param grupo
	 * @param cedulaEstudiante
	 */
	public GrupoEstudiantePK(String grupo, String cedulaEstudiante) {
		this.grupo = grupo;
		this.cedulaEstudiante = cedulaEstudiante;
	}

	/**
	 * 
	 */
	public GrupoEstudiantePK() {
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedulaEstudiante == null) ? 0 : cedulaEstudiante.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		GrupoEstudiantePK other = (GrupoEstudiantePK) obj;
		if (cedulaEstudiante == null) {
			if (other.cedulaEstudiante != null)
				return false;
		} else if (!cedulaEstudiante.equals(other.cedulaEstudiante))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}

	
	
}
