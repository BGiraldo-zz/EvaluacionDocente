package co.edu.eam.ingesoft.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;

public interface IFacultadEJBRemote extends InterfaceEJBRemote<Facultad>{

	public List<Facultad> listarFacultades();
	
}
