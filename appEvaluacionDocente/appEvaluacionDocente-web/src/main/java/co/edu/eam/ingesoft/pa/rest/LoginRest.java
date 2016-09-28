package co.edu.eam.ingesoft.pa.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.negocio.servicio.ObtencionDatos;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

@Path("/seguridad")
public class LoginRest {

	@EJB
	private BOUsuarioEJB cliEJB;

	@EJB
	private ObtencionDatos obtenerDatosEJB;

	public static Map<String, Usuario> tokens = new HashMap<>();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@FormParam(value = "user") String user, @FormParam(value = "pass") String pass) {

		Object ob = obtenerDatosEJB.comprobarEstudiante(user, pass);
		Usuario cred = cliEJB.buscarUsuarioPorUsername(user);

		if (ob != null) {
			Usuario u = new Usuario();
			u.setUsuario(user);
			u.setPass(pass);
			String token = UUID.randomUUID().toString();
			tokens.put(token, u);
			return new RespuestaDTO(token);
		}
	
		if (cred != null) {
			String token = UUID.randomUUID().toString();
			tokens.put(token, cred);
			return new RespuestaDTO(token);

		} else {
			return new RespuestaDTO(null, "NO AUTORIZADO", "-1");
		}
	}

}
