package test.clase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

@RunWith(Arquillian.class)
public class PruebaEJBPrograma {

	@EJB
	private BOProgramaEJB programaEJB;
	
	@EJB
	private BOFacultadEJB facultadEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBPrograma.class));
		return ear;
	}
	
	@BeforeClass
	public static void inicializar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-add.sql");
		System.err.println("Inicializar");
	}
	
	@Test
	public void testRegistrarPrograma(){
		
		Programa pro = new Programa();
		pro.setId("14789");
		pro.setNombre("Arqueologia");
		Facultad fa = facultadEJB.buscar("4");
		pro.setFacultad(fa);
		
		programaEJB.crear(pro);
		Programa prop = programaEJB.buscar("14789");
		Assert.assertNotNull(prop);

	}
	
	@AfterClass
	public static void finalizar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-del.sql");
		System.err.println("Finalizar");
	}
	
	
	
	
}
