package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="T_GRUPO_ESTUDIANTE")
public class GrupoEstudiante implements Serializable{

	@Id
	private Grupo grupo;
	
	private String idEstudiante;
	
	
	
	
	
}
