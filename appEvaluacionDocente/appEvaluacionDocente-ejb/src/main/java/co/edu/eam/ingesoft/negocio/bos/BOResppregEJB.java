package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IResppregEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;

@LocalBean
@Stateless
@Remote(IResppregEJBRemote.class)
public class BOResppregEJB extends EJBGenerico<Resppreg> implements IResppregEJBRemote{

	@Override
	public Class getClase() {
		return Resppreg.class;
	}

}
