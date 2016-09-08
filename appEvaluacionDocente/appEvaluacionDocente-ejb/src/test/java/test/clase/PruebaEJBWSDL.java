package test.clase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.servicio.ObtencionDatos;

@RunWith(Arquillian.class)
public class PruebaEJBWSDL {

	@EJB
	private ObtencionDatos obtener;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBWSDL.class));
		return ear;
	}
	
	@Test
	public void testObtenerDatos(){
		String res = obtener.obtenerDatos("1", "1");
		Assert.assertEquals("CORRECTO!!", res);
	}
	
	@Test
	public void comprobarEstudiante(){
		boolean res = obtener.comprobarEstudiante("1", "1");
		Assert.assertTrue(res);
	}
	
}
