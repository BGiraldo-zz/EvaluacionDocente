package co.edu.eam.ingesoft.pa.interceptores;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;

/*
 * Manejara todas las excecpciones en los servicios
 */
@Provider // hace que el servidor la descubra y sepa que es para 
// trabajar con los servicions rest
public class ManejadorExcepcion implements ExceptionMapper<Throwable>{

	// solo si hay excepcion

	@Override
	/**
	 * @param exc: Excepcion que llega exc
	 */
	public Response toResponse(Throwable exc) {
		if(exc instanceof ExcepcionFuncional){
			ExcepcionFuncional excNeg = (ExcepcionFuncional)exc;
			RespuestaDTO dto = new RespuestaDTO(null, excNeg.getMessage(),"-1");
			exc.printStackTrace();
			ExceptionLoggerInterceptor.log.info("Problema inesperado: " + dto);
			return Response.status(500).entity(dto).build();
			// status de error 500
		}else{
			RespuestaDTO dto = new RespuestaDTO(null, "Error Inesperado" ,"-2");
			exc.printStackTrace();
			ExceptionLoggerInterceptor.log.info("Problema inesperado: " + dto);
			return Response.status(500).entity(dto).build();
		}
	}
	
	
	

}
