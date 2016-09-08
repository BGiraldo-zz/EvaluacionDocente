package co.edu.eam.ingesoft.negocio.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IPreguntaEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;

@LocalBean
@Stateless
@Remote(IPreguntaEJBRemote.class)
public class BOPreguntaEJB extends EJBGenerico<Pregunta> implements IPreguntaEJBRemote{

	@Override
	public void crear(Pregunta entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una pregunta registrada con"
					+ " el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Pregunta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Pregunta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar la "
					+ " pregunta con codigo " + entidad.getId()
					+ " ya que aún no esta registrada");
		}
	}

	@Override
	public void eliminar(Pregunta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar la pregunta"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrada");
		}
	}

	@Override
	public Class getClase() {
		return Pregunta.class;
	}

	@Override
	public List<Pregunta> listarPreguntas() {
		return dao.ejecutarNamedQuery(Pregunta.PREGUNTA_LISTAR);
	}

}
