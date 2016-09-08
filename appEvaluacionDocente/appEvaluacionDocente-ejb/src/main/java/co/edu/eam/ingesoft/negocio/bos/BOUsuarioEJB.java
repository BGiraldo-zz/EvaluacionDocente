package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IUsuarioEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

@LocalBean
@Stateless
@Remote(IUsuarioEJBRemote.class)
public class BOUsuarioEJB extends EJBGenerico<Usuario> implements IUsuarioEJBRemote {

	@Override
	public void crear(Usuario entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un usuario registrado con " + "el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Usuario buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Usuario entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar el usuario" + " con codigo " + entidad.getId()
					+ " ya que aún no esta registrado");
		}
	}

	@Override
	public void eliminar(Usuario entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional(
					"No se puede eliminar el usuario" + " con codigo " + entidad.getId() + " ya que no fue encontrado");
		}
	}

	@Override
	public Class getClase() {
		return Usuario.class;
	}

	@Override
	public Usuario buscarUsuarioPorUsername(String username) {
		try {
			return dao.ejecutarQuery(Usuario.BUSCAR_POR_USERNAME, username);
		} catch (Exception e) {
			return null;
		}
	}

}
