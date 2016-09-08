package co.edu.eam.ingesoft.pa.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.BODecanoEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Decano;

@Path("/decano")
public class DecanoRest {

	@EJB
	private BODecanoEJB usuarioEJB;
	
	public DecanoRest(){
		
	}
	
	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public Decano buscarDecano(@QueryParam (value="ced") int cedula){
		return usuarioEJB.buscar(cedula);
	}
	
	@PUT
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON) // tipo del dato que enviare 
	@Produces(MediaType.APPLICATION_XML) // tipo de la respuesta que recibire
	public String crearDecano(Decano decano){
		if(usuarioEJB.buscar(decano.getId())==null){
			usuarioEJB.crear(decano);
			return "Registrado Correctamente";
		}else{
			return "Ya Hay un Usuario con la cedula especificada";
		}
	}
	
	
	
}
