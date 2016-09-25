package co.edu.eam.ingesoft.negocio.servicio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.negocio.bos.BOAsignaturaEJB;
import co.edu.eam.ingesoft.negocio.bos.BODocenteEJB;
import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOGrupoEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;
import co.edu.eam.ingesoft.pa2.clienteacademico.Curso;
import co.edu.eam.ingesoft.pa2.clienteacademico.Docente;
import co.edu.eam.ingesoft.pa2.clienteacademico.Estudiante;
import co.edu.eam.ingesoft.pa2.clienteacademico.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.clienteacademico.ServiciosEducativosService;

@LocalBean
@Stateless
public class ObtencionDatos implements Serializable {

	@EJB
	private BOAsignaturaEJB asignaturaEJB;

	@EJB
	private BOGrupoEJB grupoEJB;

	@EJB
	private BOProgramaEJB programaEJB;

	@EJB
	private BOFacultadEJB facultadEJB;

	@EJB
	private BODocenteEJB docenteEJB;

	private List<Grupo> groups;

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean comprobarEstudiante(String codigo, String cedula) {

		try {

			ServiciosEducativosService cliente = new ServiciosEducativosService();
			ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
			BindingProvider bp = (BindingProvider) servicio;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					"http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");

			Estudiante e = servicio.consultaEstudiante(codigo, cedula);

			if (e == null) {
				return false;
			}

		} catch (Exception e) {
       //  e.getMessage();
         return false;
		}
		return true;
	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public String obtenerDatos(String codigo, String id) {
		try {

			ServiciosEducativosService cliente = new ServiciosEducativosService();
			ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
			BindingProvider bp = (BindingProvider) servicio;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					"http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");

			List<Curso> cursos = servicio.consultarCursosEstudiante(codigo, id);

			manejarCursos(cursos);

		} catch (Exception e) {
			return "ERROR!!";
		}
		return "CORRECTO!!";
	}

	public List<Grupo> obtenerGruposEstudiante(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");

		List<Curso> cursos = servicio.consultarCursosEstudiante(codigo, cedula);

		manejarCursos(cursos);
		return groups;
	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void manejarCursos(List<Curso> cursos) {

		groups = new ArrayList<>();

		for (Curso c : cursos) {

			Asignatura asignatura = manejarAsignatura(c.getAsignatura());
			co.edu.eam.ingesoft.pa.negocio.entidades.Docente docente = manejarDocente(c.getDocente());

			String codigoCurso = c.getId();
			Grupo group = grupoEJB.buscar(codigoCurso);

			if (group == null) {
				Grupo g = new Grupo();
				g.setAsignatura(asignatura);
				g.setDocente(docente);
				g.setGrupo(c.getGrupo().toString());
				g.setId(c.getId());
				g.setPeriodo(3);
				g.setAnho(2016);
				grupoEJB.crear(g);
				groups.add(g);
			} else {
				groups.add(group);
			}

		}
	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public co.edu.eam.ingesoft.pa.negocio.entidades.Facultad manejarFacultad(
			co.edu.eam.ingesoft.pa2.clienteacademico.Facultad facultad) {

		co.edu.eam.ingesoft.pa.negocio.entidades.Facultad fac = new Facultad();
		fac.setId(facultad.getCodigo());
		fac.setNombre(facultad.getNombre());
		facultadEJB.crear(fac);
		return fac;

	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public co.edu.eam.ingesoft.pa.negocio.entidades.Programa manejarPrograma(
			co.edu.eam.ingesoft.pa2.clienteacademico.Programa programa) {

		co.edu.eam.ingesoft.pa.negocio.entidades.Programa program = new Programa();
		program.setNombre(programa.getNombre());
		program.setId(programa.getCodigo());

		co.edu.eam.ingesoft.pa.negocio.entidades.Facultad facultad = facultadEJB
				.buscar(programa.getFacultad().getCodigo());
		if (facultad == null) {
			co.edu.eam.ingesoft.pa.negocio.entidades.Facultad f = manejarFacultad(programa.getFacultad());
			program.setFacultad(f);
		} else {
			program.setFacultad(facultad);
		}

		programaEJB.crear(program);

		return program;

	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public Asignatura manejarAsignatura(co.edu.eam.ingesoft.pa2.clienteacademico.Asignatura asignatura) {

		co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura a = asignaturaEJB.buscar(asignatura.getCodigo());

		if (a == null) {
			co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura asig = new Asignatura();
			asig.setId(asignatura.getCodigo());
			asig.setNombre(asignatura.getNombre());
			co.edu.eam.ingesoft.pa.negocio.entidades.Programa pro = programaEJB
					.buscar(asignatura.getPrograma().getCodigo());
			if (pro != null) {
				asig.setPrograma(pro);
				asignaturaEJB.crear(asig);
				return asig;
			} else {
				co.edu.eam.ingesoft.pa.negocio.entidades.Programa program = manejarPrograma(asignatura.getPrograma());
				asig.setPrograma(program);
				asignaturaEJB.crear(asig);
				return asig;
			}

		} else {
			co.edu.eam.ingesoft.pa.negocio.entidades.Programa pro = programaEJB
					.buscar(asignatura.getPrograma().getCodigo());
			if (pro == null) {
				manejarPrograma(asignatura.getPrograma());
			}
		}
		return a;
	}

	/**
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public co.edu.eam.ingesoft.pa.negocio.entidades.Docente manejarDocente(Docente docente) {

		co.edu.eam.ingesoft.pa.negocio.entidades.Docente d = docenteEJB.buscar(docente.getCodigodocente());
		if (d == null) {
			co.edu.eam.ingesoft.pa.negocio.entidades.Docente doc = new co.edu.eam.ingesoft.pa.negocio.entidades.Docente();
			doc.setApellido(docente.getApellido());
			doc.setId(docente.getCodigodocente());
			doc.setNombre(docente.getNombre());
			co.edu.eam.ingesoft.pa.negocio.entidades.Programa pro = programaEJB
					.buscar(docente.getPrograma().getCodigo());
			if (pro == null) {
				co.edu.eam.ingesoft.pa.negocio.entidades.Programa program = manejarPrograma(docente.getPrograma());
				doc.setPrograma(program);
			} else {
				doc.setPrograma(pro);
			}

			docenteEJB.crear(doc);
			return doc;
		}
		return d;
	}
}
