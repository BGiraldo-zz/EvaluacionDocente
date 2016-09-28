package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa.negocio.dto.ResponderEvaluacionGrupoDTO;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.negocio.dto.RespuestaPreguntaDTO;
import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.GrupoEstudiante;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregeval;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

@LocalBean
@Stateless
public class webServiceEJB {

	@EJB
	private BOResppregEJB respregEJB;
	
	@EJB
	private BOGrupoEstudianteEJB grupoEstEJB;
	
	@EJB
	private BORespuestaEJB respuestaEJB;
	
	@EJB
	private BOEvaluacionEJB evaluacionEJB;
	

	/**
	 * @param respuesta, es el dto que contiene los datos
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 * Metodo para responder preguntas de una evaluación
	 * de un curso, teniendo en cuenta que todos los datos
	 * estan en la bd y son envidos desde el cliente
	 */
	public RespuestaDTO responderEvaluacion(ResponderEvaluacionGrupoDTO respuesta){
		
		String cedulaEst = respuesta.getCedulaEst();
		String codigoEst = respuesta.getCodigoEst();
		Evaluacion eval = respuesta.getEvaluacion();
		Evaluacion eval1 = evaluacionEJB.buscar(eval.getId());
		if(eval1==null){
			evaluacionEJB.crear(eval);
		}
		
		Respuesta res = respuesta.getRespuesta();
		respuestaEJB.crear(res);
		
		GrupoEstudiante g = new GrupoEstudiante();
		g.setGrupo(res.getGrupo());
		g.setCalificado(false);
		g.setCedulaEstudiante(cedulaEst);
		g.setCodigoEstudiante(codigoEst);
		grupoEstEJB.crear(g);
		
		for(RespuestaPreguntaDTO r: respuesta.getPreguntasRespondidas()){
			Pregeval preg = new Pregeval();
			preg.setPregunta(r.getPregunta());
			preg.setEvaluacion(eval);
			
			Resppreg respreg = new Resppreg();
			respreg.setPregeval(preg);
			respreg.setRespuesta(res);
			respreg.setCalificacion(r.getCalificacion());
			respregEJB.crear(respreg);
		}
		
		g.setCalificado(true);
		grupoEstEJB.editar(g);
		
		return new RespuestaDTO(g, "La evaluación se ha completado correctamente", "7");
	}
	
}
