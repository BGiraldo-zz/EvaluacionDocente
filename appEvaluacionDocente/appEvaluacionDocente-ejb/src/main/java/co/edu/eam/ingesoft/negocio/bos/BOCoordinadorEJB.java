package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.ICoordinadorEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Coordinador;

@LocalBean
@Stateless
@Remote(ICoordinadorEJBRemote.class)
public class BOCoordinadorEJB extends EJBGenerico<Coordinador> implements ICoordinadorEJBRemote{

	@Override
	public void crear(Coordinador entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Coordinador registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Coordinador buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Coordinador entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el Coordinador"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Coordinador entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el Coordinador"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}	
	}

	@Override
	public Class getClase() {
		return Coordinador.class;
	}

}
