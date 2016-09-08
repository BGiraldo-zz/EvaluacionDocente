package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IDocenteEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Docente;

@LocalBean
@Stateless
@Remote(IDocenteEJBRemote.class)
public class BODocenteEJB extends EJBGenerico<Docente> implements IDocenteEJBRemote{

	@Override
	public void crear(Docente entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Docente registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Docente buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Docente entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el Docente"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Docente entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el Docente"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}
	}

	@Override
	public Class getClase() {
		return Docente.class;
	}

}
