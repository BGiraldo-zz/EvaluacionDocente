package co.edu.eam.ingesoft.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;

public interface IPreguntaEJBRemote  extends InterfaceEJBRemote<Pregunta>{

	public List<Pregunta> listarPreguntas();
	
}
