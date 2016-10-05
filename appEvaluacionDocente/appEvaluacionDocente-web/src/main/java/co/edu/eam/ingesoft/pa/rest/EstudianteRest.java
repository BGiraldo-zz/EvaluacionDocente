package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.servicio.ObtencionDatos;
import co.edu.eam.ingesoft.pa.controladores.SesionBean;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.seguridad.rest.Secured;

@Secured
@Path("/estudiante")
public class EstudianteRest {

	@EJB
	private ObtencionDatos obtenerEJB;
	
	@Inject
	private SesionBean sesion;

	private String code;

	private String cedule;

	/**
	 * 
	 */
	public EstudianteRest() {
	}

	@POST
	@Path("/buscar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
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
	
	@POST
	@Path("/listargrupos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO extraerGruposEstudiante(@QueryParam(value = "cod")String codigo, @QueryParam(value = "ced")String cedula){
		List<Grupo> grupos = obtenerEJB.obtenerGruposEstudiante(codigo, cedula);
		return new RespuestaDTO(grupos);
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO logearEstudiante(@QueryParam(value = "user")String user,
			@QueryParam(value = "pass")String pass){
		boolean res = sesion.loguearse(user, pass);
		if(res){
			return new RespuestaDTO(res);
		}
      return new RespuestaDTO(null, "El user o pass es incorrecto", "0");
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
