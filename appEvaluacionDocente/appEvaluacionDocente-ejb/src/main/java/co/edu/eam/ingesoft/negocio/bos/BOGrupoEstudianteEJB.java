package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.GrupoEstudiante;

@LocalBean
@Stateless
public class BOGrupoEstudianteEJB extends EJBGenerico<GrupoEstudiante> implements InterfaceEJBRemote<GrupoEstudiante> {

	@Override
	public void crear(GrupoEstudiante entidad) {
		dao.crear(entidad);
	}

	@Override
	public GrupoEstudiante buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(GrupoEstudiante entidad) {
	 dao.editar(entidad);
		
	}

	@Override
	public void eliminar(GrupoEstudiante entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return GrupoEstudiante.class;
	}

}
