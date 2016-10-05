package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_GRUPO_ESTUDIANTE")
@IdClass(GrupoEstudiantePK.class)
public class GrupoEstudiante implements Serializable{

	@Id
	@ManyToOne(cascade={})
	@JoinColumn(name="ID_GRUPO", nullable=false)
	private Grupo grupo;

	@Id
	@Column(name="CEDULA_ESTUDIANTE", length=20, nullable=false)
	private String cedulaEstudiante;
	
	@Column(name="CODIGO_ESTUDIANTE", length=20, nullable=false)
	private String codigoEstudiante;
	
	@Column(name="CALIFICADO", length=1, nullable=false)
	private boolean calificado;

	/**
	 * @param grupo
	 * @param cedulaEstudiante
	 * @param codigoEstudiante
	 * @param calificado
	 */
	public GrupoEstudiante(Grupo grupo, String cedulaEstudiante, String codigoEstudiante, boolean calificado) {
		this.grupo = grupo;
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoEstudiante = codigoEstudiante;
		this.calificado = calificado;
	}

	/**
	 * 
	 */
	public GrupoEstudiante() {
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public boolean isCalificado() {
		return calificado;
	}

	public void setCalificado(boolean calificado) {
		this.calificado = calificado;
	}

	

	
	
}
