package test.clase;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class PruebaEJBPreguntaVista {

	@Drone
	private WebDriver browser;

	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBPreguntaVista.class));
		return ear;
	}
	
	@Test
	@RunAsClient
	public void RegistrarPregunta(@InitialPage PaginaManejoPregunta pag){
		
		String resp = pag.registrarPregunta();
		ArquillianUtil.takeScreenshot(browser, "testCrearPregunta.jpg");
		Assert.assertEquals("Pregunta registrada correctamente", resp);
		
	}
	
	@BeforeClass
	public static void iniciar(){
		
	}
	
	@AfterClass
	public static void terminar(){
		
	}
	
	
	
	
	
	
	
}
