package co.edu.eam.ingesoft.negocio.excepcion;

import javax.ejb.ApplicationException;

/**
 * Aqui se manejara la excepcion 
 * que se produzca en ejecucion 
 * para tener un control sobre ellas
 * @author Brayan Giraldo
 *
 */

@ApplicationException(rollback=true)
public class ExcepcionFuncional extends RuntimeException {

	public ExcepcionFuncional(String mensaje) {
		super(mensaje);
	}

}
