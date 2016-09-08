package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.negocio.interfaces.IEvaluacionEJBRemote;
import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;

@Stateless
@Remote(IEvaluacionEJBRemote.class)
public class BOEvaluacionEJB extends EJBGenerico<Evaluacion> implements IEvaluacionEJBRemote{

	@Override
	public void crear(Evaluacion entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una evaluación registrada con"
					+ " el codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Evaluacion buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Evaluacion entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede editar la "
					+ " evaluación con codigo " + entidad.getId()
					+ " ya que aún no esta registrada");
		}
	}

	@Override
	public void eliminar(Evaluacion entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("No se puede eliminar la evaluación"
					+ " con codigo " + entidad.getId()
					+ " ya que no fue encontrada");
		}
	}

	@Override
	public Class getClase() {
		return Evaluacion.class;
	}

}
