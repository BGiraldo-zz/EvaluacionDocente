package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.bos.BOCoordinadorEJB;
import co.edu.eam.ingesoft.negocio.bos.BODecanoEJB;
import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.pa.interceptores.ExceptionLogger;
import co.edu.eam.ingesoft.pa.interceptores.Secured;
import co.edu.eam.ingesoft.pa.negocio.entidades.Coordinador;
import co.edu.eam.ingesoft.pa.negocio.entidades.Decano;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;
import co.edu.eam.ingesoft.pa.seguridad.MD5Util;

@Named("ControladorManejoUsuario")
@ViewScoped
@ExceptionLogger
public class ControladorManejoUsuario implements Serializable {

	@EJB
	private BOUsuarioEJB usuarioEJB;

	@EJB
	private BOProgramaEJB programaEJB;

	@EJB
	private BOFacultadEJB facultadEJB;

	private List<Programa> programas;

	private List<Facultad> facultades;

	private Usuario instancia;

	private String tipoUser;

	private Facultad facultad;

	private Programa programa;

	@PostConstruct
	public void inicializar() {
		instancia = new Usuario();
		facultades = null;
		programas = null;
	}

	/**
	 * Registra un usuario
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	@Secured
	public void registrarUsuario() {

		Usuario u = usuarioEJB.buscar(instancia.getId());

		if (tipoUser.equals("b")) { // Coordinador

			Coordinador c = new Coordinador();
			c.setApellido(instancia.getApellido());
			c.setId(instancia.getId());
			c.setNombre(instancia.getNombre());
			String passMd5 = MD5Util.code(instancia.getPass());
			c.setPass(passMd5);
			c.setPrograma(programa);
			c.setUsuario(instancia.getUsuario());
			usuarioEJB.crear(c);
			Messages.addGlobalInfo("Coordinador registrado correctamente");
			inicializar();

		}
		
		if (tipoUser.equals("c")) { // Decano

			Decano d = new Decano();
			d.setApellido(instancia.getApellido());
			d.setId(instancia.getId());
			d.setNombre(instancia.getNombre());
			String passMd5 = MD5Util.code(instancia.getPass());
			d.setPass(passMd5);
			d.setFacultad(facultad);
			d.setUsuario(instancia.getUsuario());
			usuarioEJB.crear(d);
			Messages.addGlobalInfo("Decano registrado correctamente");
			inicializar();
		}

	}

	/**
	 * Carga la lista dependiendo del tipo de usuario para cargar en el combo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void cambiarCombo() {

		if (tipoUser.equals("a")) { // Seleccione una opcion
			facultades = null;
			programas = null;
		} else if (tipoUser.equals("b")) { // Coordinador
			facultades = null;
			programas = programaEJB.listarProgramas();
		} else if (tipoUser.equals("c")) { // Decano
			programas = null;
			facultades = facultadEJB.listarFacultades();
		}
	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void buscarUsuario() {

	}

	public void editarUsuario() {

	}

	public void removerUsuario() {

	}
	
	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public List<Facultad> getFacultades() {
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

	public Usuario getInstancia() {
		return instancia;
	}

	public void setInstancia(Usuario instancia) {
		this.instancia = instancia;
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

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public BOUsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(BOUsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}
