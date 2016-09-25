package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para el control de grupo
 * en general con sus datos
 * @author Giraldo
 */

@Entity
@Table(name="T_GRUPO")
public class Grupo implements Serializable{

	/* Atributos */
	
	@Id
	@Column(name="ID_GRUPO", length = 45, nullable = false)
	private String id;
	
	@Column(name="GRUPO", length = 45, nullable = false)
	private String grupo;
	
	@Column(name="ANHO", length = 45, nullable = true)
	private int anho;
	
	@Column(name="PERIODO", length = 45, nullable = true)
	private int periodo;
	
	@ManyToOne
	@JoinColumn(name="ID_ASIGNATURA", nullable = false)
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name="ID_DOCENTE" , nullable=false)
	private Docente docente;

	/**
	 * @param id
	 * @param grupo
	 * @param anho
	 * @param periodo
	 * @param asignatura
	 * @param docente
	 */
	public Grupo(String id, String grupo, int anho, int periodo, Asignatura asignatura, Docente docente) {
		this.id = id;
		this.grupo = grupo;
		this.anho = anho;
		this.periodo = periodo;
		this.asignatura = asignatura;
		this.docente = docente;
	}

	/**
	 * 
	 */
	public Grupo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/* Constructor */
	
	
}
