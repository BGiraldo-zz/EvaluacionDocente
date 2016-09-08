package co.edu.eam.ingesoft.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

public interface IProgramaEJBRemote extends InterfaceEJBRemote<Programa>{
	
	public List<Programa> listarProgramas();

}
