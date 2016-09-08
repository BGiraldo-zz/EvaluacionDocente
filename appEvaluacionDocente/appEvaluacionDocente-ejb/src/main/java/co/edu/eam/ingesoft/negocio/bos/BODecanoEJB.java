package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IDecanoEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Decano;

@LocalBean
@Stateless
@Remote(IDecanoEJBRemote.class)
public class BODecanoEJB extends EJBGenerico<Decano> implements IDecanoEJBRemote{

	@Override
	public void crear(Decano entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Decano registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Decano buscar(Object pk) {
	   return dao.buscar(pk);
	}

	@Override
	public void editar(Decano entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el Decano"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Decano entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el Decano"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}
	}

	@Override
	public Class getClase() {
		return Decano.class;
	}

}
