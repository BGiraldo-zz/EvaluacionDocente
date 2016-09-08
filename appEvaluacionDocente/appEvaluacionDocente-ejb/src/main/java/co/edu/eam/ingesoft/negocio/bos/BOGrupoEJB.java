package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IGrupoEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;

@LocalBean
@Stateless
@Remote(IGrupoEJBRemote.class)
public class BOGrupoEJB extends EJBGenerico<Grupo> implements IGrupoEJBRemote{

	@Override
	public void crear(Grupo entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un grupo registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Grupo buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Grupo entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el grupo"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Grupo entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el grupo"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}
	}

	@Override
	public Class getClase() {
		return Grupo.class;
	}

}
