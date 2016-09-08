package co.edu.eam.ingesoft.negocio.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IProgramaEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

@LocalBean
@Stateless
@Remote(IProgramaEJBRemote.class)
public class BOProgramaEJB extends EJBGenerico<Programa> implements IProgramaEJBRemote{

	@Override
	public void crear(Programa entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un programa registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Programa buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Programa entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el programa"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Programa entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el programa"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}	
	}
	
	

	@Override
	public Class getClase() {
		return Programa.class;
	}

	@Override
	public List<Programa> listarProgramas() {
		return dao.ejecutarNamedQuery(Programa.LISTAR_PROGRAMAS);
	}

}
