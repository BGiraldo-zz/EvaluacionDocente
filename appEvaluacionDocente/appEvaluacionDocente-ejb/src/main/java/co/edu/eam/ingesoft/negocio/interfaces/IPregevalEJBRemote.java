package co.edu.eam.ingesoft.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa.negocio.entidades.Pregeval;

public interface IPregevalEJBRemote extends InterfaceEJBRemote<Pregeval>{

	public List<Pregeval> listarPreguntasEvaluacion(int idEvaluacion);
	
}
