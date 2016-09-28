package co.edu.eam.ingesoft.pa.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.webServiceEJB;
import co.edu.eam.ingesoft.pa.negocio.dto.ResponderEvaluacionGrupoDTO;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;


@Path("/respuesta")
public class RespuestaRest {

	@EJB
	private webServiceEJB servicioEJB;
	
	
	@Path("/responderevaluacion")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // como envia el dato
	public RespuestaDTO responderEvaluacion(ResponderEvaluacionGrupoDTO respuesta){
		RespuestaDTO  r = servicioEJB.responderEvaluacion(respuesta);
		return r;
	}
	
	
}
