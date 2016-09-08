package co.edu.eam.ingesoft.pa2.connect;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * clase para buscar un ejb remoto.
 * @author UTFNA
 *
 */
public class ServiceLocator {

	
	public static final String IP="localhost";
	public static final String  PUERTO="8082";
	/**
	 * 
	 * @param interfaceRemota
	 * @param appName, nombre de la aplicacion o proyecto EAR
	 * @param moduleName, nombre del proyecto EJB
	 * @param beanName, nombre del EJB.
	 * @return
	 * @throws NamingException 
	 */
	public static <T> T buscarEJB(Class<T> interfaceRemota,String appName,String moduleName,String beanName) throws NamingException{
		
		Hashtable<Object, Object> props = new Hashtable<Object, Object>();

		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);

		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);

		props.put(Context.PROVIDER_URL, "http-remoting://" + IP + ":" + PUERTO);
		props.put("remote.connection.default.host", IP);
		props.put("remote.connection.default.port", PUERTO);
		
		InitialContext ctx=new InitialContext(props);
		
		String jndi=String.format("ejb:%s/%s/%s!%s", appName,moduleName,beanName,interfaceRemota.getCanonicalName());
		System.out.println(jndi);
		
		return (T)ctx.lookup(jndi);
		
	}
}
