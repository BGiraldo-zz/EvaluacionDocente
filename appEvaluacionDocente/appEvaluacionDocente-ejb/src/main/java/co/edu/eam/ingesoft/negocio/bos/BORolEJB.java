package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Rol;

@LocalBean
@Stateless
public class BORolEJB extends EJBGenerico<Rol> implements InterfaceEJBRemote<Rol>{

	@Override
	public void crear(Rol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rol buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Rol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Rol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return Rol.class;
	}

}
