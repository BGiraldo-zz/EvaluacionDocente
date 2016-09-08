package co.edu.eam.ingesoft.negocio.bos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Acceso;
import co.edu.eam.ingesoft.pa.negocio.entidades.AccesoRol;
import co.edu.eam.ingesoft.pa.negocio.entidades.Rol;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

@Stateless
public class BOSecurityEJB<T> extends EJBGenerico<T> {
	
	/**
	 * 
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Rol> listarRolesUsuario(int idUser) {
		return dao.ejecutarNamedQuery(Rol.LISTAR_ROLES_USUARIO, idUser);
	}

	/**
	 * 
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Acceso> listarAccesosRol(List<Rol> roles) {
		List<Acceso> accesos = new ArrayList<Acceso>();
		for (Rol r : roles) {
			List<Acceso> acces = dao.ejecutarNamedQuery(Acceso.LISTAR_ACCESOS_ROL, r.getId());
			for (Acceso a : acces) {
				accesos.add(a);
			}
		}
		return accesos;
	}

	
	@Override
	public Class getClase() {
		return null;
	}

}
