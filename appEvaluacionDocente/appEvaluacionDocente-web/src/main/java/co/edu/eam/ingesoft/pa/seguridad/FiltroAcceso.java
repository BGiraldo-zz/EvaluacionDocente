package co.edu.eam.ingesoft.pa.seguridad;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa.controladores.SesionBean;
import co.edu.eam.ingesoft.pa.negocio.entidades.Acceso;

@WebFilter(urlPatterns = "/paginas/*")
public class FiltroAcceso implements Filter {

	@Inject
	private SesionBean sesion;

	Logger logger = Logger.getLogger(FiltroAcceso.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) resp;

		String urlcompleta = httpreq.getRequestURI().toString();
		String contexpath = httpreq.getContextPath();

		logger.info("URL = " + urlcompleta + ", path = " + contexpath);
		String url = urlcompleta.substring(contexpath.length());
		logger.info("URL a filtrar" + url);

		if (sesion.isloged()) {

			boolean cargue = false;
			if (url.equals("/paginas/index.jsf")) {
				cargue = true;
			} else {

					List<Acceso> accesos = sesion.getAccesos();
					for (Acceso a : accesos) {
						if (a.getUrl().equals(url)) {
							cargue = true;
						}
					}
			}

			if (!cargue) {
				httpresp.sendRedirect(httpreq.getContextPath() + "/paginas/index.jsf");
			} else {
				chain.doFilter(request, resp);
			}

		} else {
			String redireccion = httpreq.getContextPath() + "/login.jsf";
			logger.info("Redireccionado a " + redireccion);
			httpresp.sendRedirect(redireccion);

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
