package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IResppregEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;

@Stateless
@Remote(IResppregEJBRemote.class)
public class BOResppregEJB extends EJBGenerico<Resppreg> implements IResppregEJBRemote{

	@Override
	public void crear(Resppreg entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resppreg buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Resppreg entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Resppreg entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return Resppreg.class;
	}

}
