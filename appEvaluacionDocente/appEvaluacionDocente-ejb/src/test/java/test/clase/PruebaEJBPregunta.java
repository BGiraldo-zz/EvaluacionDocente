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

import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;

@RunWith(Arquillian.class)
public class PruebaEJBPregunta {

	@EJB
	private BOPreguntaEJB preguntaEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBPregunta.class));
		return ear;
	}
	
	@BeforeClass
	public static void inicializar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-add.sql");
		System.err.println("Inicializar");
	}
	
	@Test
	public void testRegistrarPregunta(){
		
		Pregunta p = new Pregunta();
		p.setId(12);
		p.setTexto("¿El profesor por lo generar es puntual?");
		double valor = 10/100;
		p.setValor(valor);
		
		preguntaEJB.crear(p);
		
		Pregunta pre = preguntaEJB.buscar(12);
		Assert.assertNotNull(pre);
		
	}
	
	
	@AfterClass
	public static void finalizar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-del.sql");
		System.err.println("Finalizar");
	}
	
	
	
	
}
