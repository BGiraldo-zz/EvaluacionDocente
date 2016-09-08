package co.edu.eam.ingesoft.pa.interceptores;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa.controladores.SesionBean;

@Interceptor
@Secured
public class SecurityIntercerptor implements Serializable {

	private static Logger log = Logger.getLogger(SecurityIntercerptor.class);

	@Inject
	private SesionBean sesion;

	@AroundInvoke
	public Object interceptar(InvocationContext ctx) throws Exception {

		if (ctx.getMethod().isAnnotationPresent(Secured.class)) {

			if (sesion.isloged()) {
				Object res = ctx.proceed();
				return res;
			} else {
				throw new Exception("No Autorizado !!!");
			}

		} else {
			Object res = ctx.proceed();
			return res;
		}

	}

}
