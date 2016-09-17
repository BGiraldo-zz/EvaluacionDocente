package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.servicio.ObtencionDatos;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.rest.dto.RespuestaDTO;

@Path("/estudiante")
public class EstudianteRest {

	@EJB
	private ObtencionDatos obtenerEJB;

	private String code;

	private String cedule;

	/**
	 * 
	 */
	public EstudianteRest() {
	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarEstudiante(@QueryParam(value = "cod") String codigo,
			@QueryParam(value = "ced") String cedula) {
		boolean res = obtenerEJB.comprobarEstudiante(codigo, cedula);
		if (res) {
			code = codigo;
			cedule = cedula;
			return new RespuestaDTO(true);
		}
		return new RespuestaDTO(false, "No encontrado", "0");
	}
	
	@GET
	@Path("/listargrupos")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO extraerGruposEstudiante(@QueryParam(value = "cod")String codigo, @QueryParam(value = "ced")String cedula){
		List<Grupo> grupos = obtenerEJB.obtenerGruposEstudiante(codigo, cedula);
		return new RespuestaDTO(grupos);
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCedule() {
		return cedule;
	}

	public void setCedule(String cedule) {
		this.cedule = cedule;
	}

}
