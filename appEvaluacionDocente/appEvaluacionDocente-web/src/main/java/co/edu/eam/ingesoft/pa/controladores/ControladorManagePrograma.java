package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.interceptores.ExceptionLogger;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

@Named
@ViewScoped
@ExceptionLogger
public class ControladorManagePrograma implements Serializable{

	@EJB
	private BOProgramaEJB programaEJB;

	@EJB
	private BOFacultadEJB facultadEJB;

	private List<Facultad> facultades;

	private Programa instancia;
	
	
	@PostConstruct
	public void inicializar() {
		facultades = facultadEJB.listarFacultades();
		instancia=new Programa();
	}
	
	public void registrarPrograma() {

		Programa p = programaEJB.buscar(instancia.getId());

		if (p == null) {

			programaEJB.crear(instancia);
			Messages.addGlobalInfo("Programa registrado correctamente");
			inicializar();
		}

	}
	
	public BOProgramaEJB getProgramaEJB() {
		return programaEJB;
	}

	public void setProgramaEJB(BOProgramaEJB programaEJB) {
		this.programaEJB = programaEJB;
	}

	public BOFacultadEJB getFacultadEJB() {
		return facultadEJB;
	}

	public void setFacultadEJB(BOFacultadEJB facultadEJB) {
		this.facultadEJB = facultadEJB;
	}

	public List<Facultad> getFacultades() {
		facultades = facultadEJB.listarFacultades();
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

	public Programa getInstancia() {
		return instancia;
	}

	public void setInstancia(Programa instancia) {
		this.instancia = instancia;
	}
	
	
	
}
