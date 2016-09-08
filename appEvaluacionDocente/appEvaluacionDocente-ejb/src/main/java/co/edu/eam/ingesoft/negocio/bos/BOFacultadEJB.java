package co.edu.eam.ingesoft.negocio.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IFacultadEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;

@LocalBean
@Stateless
@Remote(IFacultadEJBRemote.class)
public class BOFacultadEJB extends EJBGenerico<Facultad> implements IFacultadEJBRemote{

	@Override
	public void crear(Facultad entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una facultad registrada con"
					+ " el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Facultad buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Facultad entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar la "
					+ " facultad con codigo " + entidad.getId()
					+ " ya que aún no esta registrada");
		}
	}

	@Override
	public void eliminar(Facultad entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar la facultad"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrada");
		}
	}

	@Override
	public Class getClase() {
		return Facultad.class;
	}

	@Override
	public List<Facultad> listarFacultades() {
		return dao.ejecutarNamedQuery(Facultad.LISTAR_FACULTADES);
	}

}
