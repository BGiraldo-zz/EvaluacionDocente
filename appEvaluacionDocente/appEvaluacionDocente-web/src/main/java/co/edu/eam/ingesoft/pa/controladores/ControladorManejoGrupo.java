package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa.interceptores.ExceptionLogger;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;

@Named("ControladorManejoGrupo")
@ViewScoped
@ExceptionLogger
public class ControladorManejoGrupo implements Serializable {

	@Inject
	private SesionBean sesion;
	
	private List<Grupo> grupos;
	
	private Grupo grupo;
	
	
	
	@PostConstruct
	public void inicializar(){
		
	}


	public SesionBean getSesion() {
		return sesion;
	}



	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}



	public List<Grupo> getGrupos() {
		grupos = sesion.getGrupos();
		return grupos;
	}



	public void setGrupos(List<Grupo> grupos) {	
		this.grupos = grupos;
	}



	public Grupo getGrupo() {
		return grupo;
	}



	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	

}
