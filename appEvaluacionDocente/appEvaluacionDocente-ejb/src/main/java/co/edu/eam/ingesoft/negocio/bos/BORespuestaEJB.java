package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IRespuestaEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

@Stateless
@Remote(IRespuestaEJBRemote.class)
public class BORespuestaEJB extends EJBGenerico<Respuesta> implements IRespuestaEJBRemote{

	@Override
	public void crear(Respuesta entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una respuesta registrada con"
					+ " el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Respuesta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Respuesta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar la "
					+ " respuesta con codigo " + entidad.getId()
					+ " ya que aún no esta registrada");
		}
	}

	@Override
	public void eliminar(Respuesta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar la respuesta"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrada");
		}
	}

	@Override
	public Class getClase() {
		return Respuesta.class;
	}

}
