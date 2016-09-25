package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@Named("ControladorManejoRespuesta")
@ViewScoped
public class ControladorManejoRespuesta implements Serializable{

	
	
	public String calificarGrupo(){
		//Debo tener el grupo y el estudiante
		// antes de calificar verificar si hay una evaluacion de este grupo
		// con estado calificada, si es null o no calificada entonces
		// se manda al formulari y al completarlo se crea la eval para el grupo 
		// o se le cambia el estado... tener en cuenta que cada pregunta tendra su respuesta
		return "/index.jsf?faces-redirect=true";
	}
	
}
