package co.edu.eam.ingesoft.pa.seguridad.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.rest.LoginRest;

@Secured// indica al filtro que se interceptara lo anotado con esto
@Provider // interceptores y filtros para rest
public class InterceptorSeguridadRest implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext ctxReq) throws IOException {
		
		String token = ctxReq.getHeaderString("Authorization");
		if(!LoginRest.tokens.containsKey(token)){
			RespuestaDTO dto = new RespuestaDTO(null, "NO AUTORIZADO","-3");
			ctxReq.abortWith(Response.status(401).entity(dto).build());
		}else{
			
		}
		
	}

}