package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IAsignaturaEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura;

@LocalBean
@Stateless
@Remote(IAsignaturaEJBRemote.class)
public class BOAsignaturaEJB extends EJBGenerico<Asignatura> implements IAsignaturaEJBRemote {

	@Override
	public void crear(Asignatura entidad) throws ExcepcionFuncional {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una asignatura registrada con"
					+ " el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Asignatura buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Asignatura entidad) throws ExcepcionFuncional {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar la "
					+ " asignatura con codigo " + entidad.getId()
					+ " ya que aún no esta registrada");
		}
	}

	@Override
	public void eliminar(Asignatura entidad) throws ExcepcionFuncional {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar la asignatura"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrada");
		}
	}

	@Override
	public Class getClase() {
		return Asignatura.class;
	}

}
