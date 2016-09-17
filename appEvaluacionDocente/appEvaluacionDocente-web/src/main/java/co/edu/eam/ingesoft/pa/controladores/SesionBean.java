package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.bos.BORolEJB;
import co.edu.eam.ingesoft.negocio.bos.BOSecurityEJB;
import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Acceso;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.Rol;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;
import co.edu.eam.ingesoft.pa.rest.EstudianteRest;
import co.edu.eam.ingesoft.pa.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa.seguridad.MD5Util;;

@Named("SesionBean")
@SessionScoped
public class SesionBean implements Serializable {

	private Logger logger = Logger.getLogger(SesionBean.class);

	private Usuario usuario;

	private String nickname;

	private String password;

	private List<Acceso> accesos;

	private List<Rol> roles;

	@EJB
	private BOUsuarioEJB usuarioEJB;
	
	@EJB
	private BORolEJB rolEJB;

	@EJB
	private BOSecurityEJB<Object> seguridadEJB;

	@Inject
	private EstudianteRest estudiante;

	private RespuestaDTO respuesta;
	
	private List<Grupo> grupos;

	@PostConstruct
	public void inicializar() {
		respuesta = new RespuestaDTO();
	}

	/**
	 * Metodo que Registra un usuario
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public String login() {
		// code ced
		respuesta = estudiante.buscarEstudiante(nickname, password);

		if (respuesta.getCodigo().equals("1")) {
			usuario = new Usuario();
			usuario.setUsuario(estudiante.getCode()); // codigo
			usuario.setPass(estudiante.getCedule()); // cedula
			Rol r = rolEJB.buscar(5);
			roles = new ArrayList<Rol>();
			roles.add(r);
			accesos = seguridadEJB.listarAccesosRol(roles);
			RespuestaDTO rtadto = estudiante.extraerGruposEstudiante(usuario.getUsuario(), usuario.getPass());
			grupos = (List<Grupo>) rtadto.getObj();
			Messages.addFlashGlobalInfo("Se ha iniciado sesion correctamente !!!");
			return "/paginas/index.jsf?faces-redirect=true";

		} else {

			Usuario u = usuarioEJB.buscarUsuarioPorUsername(nickname);

			String passMd5 = MD5Util.code(password);

			if (u != null && passMd5.equals(u.getPass())) {

				usuario = u;
				roles = seguridadEJB.listarRolesUsuario(usuario.getId());
				accesos = seguridadEJB.listarAccesosRol(roles);
				Messages.addFlashGlobalInfo("Se ha iniciado sesion correctamente !!!");
				return "/paginas/index.jsf?faces-redirect=true";
			} else {
				usuario = null;
				roles = null;
				accesos = null;
				Messages.addFlashGlobalWarn("Usuario o Contraseña Incorrectos !!!");
			}
		}
		return null;
	}

	/**
	 * Metodo que veifica si esta logueado el usuario
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean isloged() {
		return usuario != null;
	}

	/**
	 * Metodo que Cierra las sesiones activas
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public String logout() {
		Faces.getSession().invalidate();
		return "/login.jsf?faces-redirect=true";
	}

	/**
	 * Renderiza la opcion manejar Usuario
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean renderizarMenu(int menu) {

		switch (menu) {

		case 1: // Menu Manejo Usuario
           	
			for (Rol r : roles) {
				if (r.getDescripcion().equals("Admin") || r.getDescripcion().equals("Vicerrector")) {
					return true;
				}
			}

			break;

		case 2: // Menu Manejo Pregunta

				for (Rol r : roles) {
					if (r.getDescripcion().equals("Admin") || r.getDescripcion().equals("Vicerrector")
							|| r.getDescripcion().equals("Decano")) {
						return true;
					}
				}
			

			break;

		case 3: // Menu Manejo Programa
			
				for (Rol r : roles) {
					if (r.getDescripcion().equals("Admin") || r.getDescripcion().equals("Vicerrector")) {
						return true;
					}
				}

				break;
				
		case 4: // Menu Manejo Grupo
			
			for (Rol r : roles) {
				if (r.getDescripcion().equals("Admin") || r.getDescripcion().equals("Vicerrector") || 
						r.getDescripcion().equals("Estudiante")) {
					return true;
				}
			}
			
		}

		return false;

	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public BOUsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(BOUsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}

	public BOSecurityEJB<Object> getSeguridadEJB() {
		return seguridadEJB;
	}

	public void setSeguridadEJB(BOSecurityEJB<Object> seguridadEJB) {
		this.seguridadEJB = seguridadEJB;
	}

	public EstudianteRest getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteRest estudiante) {
		this.estudiante = estudiante;
	}

	public RespuestaDTO getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaDTO respuesta) {
		this.respuesta = respuesta;
	}

	public BORolEJB getRolEJB() {
		return rolEJB;
	}

	public void setRolEJB(BORolEJB rolEJB) {
		this.rolEJB = rolEJB;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	

}
