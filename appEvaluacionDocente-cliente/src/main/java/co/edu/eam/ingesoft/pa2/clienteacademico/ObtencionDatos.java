package co.edu.eam.ingesoft.pa2.clienteacademico;

public class ObtencionDatos {
	/*
	private ServiciosAcademicos servicio;

	private IAsignaturaEJBRemote asignaturaEJB;

	private IGrupoEJBRemote grupoEJB;

	private IProgramaEJBRemote programaEJB;

	private IFacultadEJBRemote facultadEJB;

	private IDocenteEJBRemote docenteEJB;

	public ObtencionDatos(ServiciosAcademicos servicio) throws NamingException {
		this.servicio = servicio;
		asignaturaEJB = ServiceLocator.buscarEJB(IAsignaturaEJBRemote.class, "appEvaluacionDocente-ear",
				"appEvaluacionDocente-ejb", "BOAsignaturaEJB");
		grupoEJB = ServiceLocator.buscarEJB(IGrupoEJBRemote.class, "appEvaluacionDocente-ear",
				"appEvaluacionDocente-ejb", "BOGrupoEJB");
		programaEJB = ServiceLocator.buscarEJB(IProgramaEJBRemote.class, "appEvaluacionDocente-ear",
				"appEvaluacionDocente-ejb", "BOProgramaEJB");
		facultadEJB = ServiceLocator.buscarEJB(IFacultadEJBRemote.class, "appEvaluacionDocente-ear",
				"appEvaluacionDocente-ejb", "BOFacultadEJB");
		docenteEJB = ServiceLocator.buscarEJB(IDocenteEJBRemote.class, "appEvaluacionDocente-ear",
				"appEvaluacionDocente-ejb", "BODocenteEJB");

	}

	
	public String obtenerDatos(String codigoEstudiante, String cedulaEstudiante) {
		try {
			List<Curso> cursos = servicio.consultarCursosEstudiante(codigoEstudiante, cedulaEstudiante);

			manejarCursos(cursos);
		} catch (Exception e) {
			return "ERROR!!";
		}
		return "CORRECTO!!";
	}

	
	public void manejarCursos(List<Curso> cursos) {

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
				// g.setPeriodo('1');
				// g.setAnho(2016);
				grupoEJB.crear(g);
			}

		}
	}

	
	public co.edu.eam.ingesoft.pa.negocio.entidades.Facultad manejarFacultad(
			co.edu.eam.ingesoft.pa2.clienteacademico.Facultad facultad) {

		co.edu.eam.ingesoft.pa.negocio.entidades.Facultad fac = new Facultad();
		fac.setId(facultad.getCodigo());
		fac.setNombre(facultad.getNombre());
		facultadEJB.crear(fac);
		return fac;

	}

	
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
*/
}
