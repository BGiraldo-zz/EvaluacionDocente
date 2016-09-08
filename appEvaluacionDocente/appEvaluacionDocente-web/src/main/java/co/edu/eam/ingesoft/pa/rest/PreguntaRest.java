package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.rest.dto.RespuestaDTO;

@Path("/pregunta")
public class PreguntaRest {

	@EJB
	private BOPreguntaEJB preguntaEJB;

	public PreguntaRest() {

	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON) // como recibo el dato de respuesta
	public RespuestaDTO buscarPregunta(@QueryParam(value = "cod") int id) {
		Pregunta p = preguntaEJB.buscar(id);
		if(p==null){
			return new RespuestaDTO(null, "No encontrado", "0");
		}
		return new RespuestaDTO(p);
	}

	@Path("/crear")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // como envia el dato
	public RespuestaDTO crear(Pregunta pregunta) {
		if (preguntaEJB.buscar(pregunta.getId()) == null) {
			preguntaEJB.crear(pregunta);
			return new RespuestaDTO(true);
		} else {
			return new RespuestaDTO(false, "Ya existe pregunta", "2"); // 2 ya
																		// existe
		}

	}

	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarPreguntas() {
		List<Pregunta> lista = preguntaEJB.listarPreguntas();
		return new RespuestaDTO(lista);
	}

}
