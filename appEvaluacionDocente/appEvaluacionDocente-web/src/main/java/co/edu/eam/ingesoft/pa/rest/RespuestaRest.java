package co.edu.eam.ingesoft.pa.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.BOGrupoEstudianteEJB;
import co.edu.eam.ingesoft.negocio.bos.BOResppregEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.GrupoEstudiante;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregeval;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;
import co.edu.eam.ingesoft.pa.rest.dto.ResponderEvaluacionGrupoDTO;
import co.edu.eam.ingesoft.pa.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.rest.dto.RespuestaPreguntaDTO;

@Path("/respuesta")
public class RespuestaRest {

	@EJB
	private BOResppregEJB respuestaEJB;
	
	@EJB
	private BOGrupoEstudianteEJB grupoEstEJB;
	
	
	@Path("/responderEvaluacion")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // como envia el dato
	public RespuestaDTO responderEvaluacion(ResponderEvaluacionGrupoDTO respuesta){
		Evaluacion evaluacion;
		Pregunta pregunta;
		Respuesta rpta;
		Grupo grupo = null;
		String codigoEst = respuesta.getCodigoEst();
		String cedulaEst = respuesta.getCedulaEst();
		for(RespuestaPreguntaDTO r : respuesta.getPreguntasRespondidas()){
         evaluacion = r.getEvaluacion();
		 evaluacion = r.getEvaluacion();
		 pregunta = r.getPregunta();
		 rpta = r.getRespuesta();
		 grupo = r.getRespuesta().getGrupo();
		 Pregeval preg = new Pregeval(pregunta, evaluacion);
		 Resppreg resp = new Resppreg(rpta, preg, r.getCalificacion());
		 respuestaEJB.crear(resp);
		}
		GrupoEstudiante g = new GrupoEstudiante(grupo, cedulaEst, codigoEst, true);
		grupoEstEJB.crear(g);
		
		return new RespuestaDTO(g);
	}
	
	
}
