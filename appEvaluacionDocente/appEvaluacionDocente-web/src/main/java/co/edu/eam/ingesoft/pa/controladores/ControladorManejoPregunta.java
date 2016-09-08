package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.pa.interceptores.ExceptionLogger;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;

@Named("ControladorManejoPregunta")
@ViewScoped
@ExceptionLogger
public class ControladorManejoPregunta implements Serializable {

	/**
	 * ejb de la pregunta
	 */
	@EJB
	private BOPreguntaEJB preguntaEJB;

	/**
	 * Instancia de la pregunta para manejar en este controlador.
	 */
	private Pregunta instancia;

	@PostConstruct
	public void inicializar() {
     instancia = new Pregunta();
	}

	public void registrarPregunta() {
			double pesoP = instancia.getValor()/100;
			instancia.setValor(pesoP);
			preguntaEJB.crear(instancia);
			Messages.addGlobalInfo("Pregunta registrada correctamente");
			inicializar();
	}

	public void buscarPregunta() {

	}

	public void editarPregunta() {

	}

	public void borrarPregunta() {

	}

	public BOPreguntaEJB getPreguntaEJB() {
		return preguntaEJB;
	}

	public void setPreguntaEJB(BOPreguntaEJB preguntaEJB) {
		this.preguntaEJB = preguntaEJB;
	}

	public Pregunta getInstancia() {
		return instancia;
	}

	public void setInstancia(Pregunta instancia) {
		this.instancia = instancia;
	}

}
