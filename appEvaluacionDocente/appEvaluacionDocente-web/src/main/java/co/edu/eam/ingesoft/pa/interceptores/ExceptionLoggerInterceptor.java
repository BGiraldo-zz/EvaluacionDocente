package co.edu.eam.ingesoft.pa.interceptores;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;

@Interceptor
@ExceptionLogger
public class ExceptionLoggerInterceptor implements Serializable {

	public static Logger log = Logger.getLogger(ExceptionLoggerInterceptor.class);
	
	@AroundInvoke
	public Object mostrarException(InvocationContext invocationContext) throws Exception{
		log.info("Ingresando al metodo : " + invocationContext.getMethod().getName() );
		try{		
			return invocationContext.proceed();
		}catch(ExcepcionFuncional exc){
			Messages.addGlobalError(exc.getMessage());
			log.error(exc.getMessage(),exc);
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		Faces.getApplication().getNavigationHandler().handleNavigation(Faces.getContext()
				, null, "error.jsf?faces-redirect=true");
		}finally {
			log.info("Saliendo del metodo : " + invocationContext.getMethod().getName() );
		}
		return null;
	}
	
	
	
	
}
