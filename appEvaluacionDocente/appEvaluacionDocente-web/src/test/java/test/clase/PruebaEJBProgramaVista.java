package test.clase;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class PruebaEJBProgramaVista {

	@Drone
	private WebDriver browser;
	
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBProgramaVista.class));
		return ear;
		
	}
	
	@Test
	@RunAsClient
	public void registrarPrograma(@InitialPage PaginaManejoPrograma pag){
		String resp = pag.registrarPrograma();
	//	ArquillianUtil.takeScreenshot(browser, "testRegistrarPrograma.jpg");
		Assert.assertEquals("Programa registrado correctamente", resp);
	}
	
	
	
}
