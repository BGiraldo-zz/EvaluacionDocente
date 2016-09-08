package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.ISuperAdminEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.SuperAdmin;

@Stateless
@Remote(ISuperAdminEJBRemote.class)
public class BOSuperAdminEJB extends EJBGenerico<SuperAdmin> implements ISuperAdminEJBRemote{

	@Override
	public void crear(SuperAdmin entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un superadmin registrado con "
					+ "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public SuperAdmin buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(SuperAdmin entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el superadmin"
					+ " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(SuperAdmin entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar el superadmin"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrado");
		}
	}

	@Override
	public Class getClase() {
		return SuperAdmin.class;
	}

}
