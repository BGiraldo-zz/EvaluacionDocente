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

import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

@RunWith(Arquillian.class)
public class PruebaEJBUsuario {

	@EJB
	private BOUsuarioEJB usuarioEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBUsuario.class));
		return ear;
	}
	
	@BeforeClass
	public static void inicializar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-add.sql");
		System.err.println("Inicializar");
	}
	
	@Test
	public void testCrearUsuario(){
		Usuario u = new Usuario();
		u.setNombre("Manuel");
		u.setApellido("Santiar");
		u.setId(18);
		u.setPass("123");
		u.setUsuario("man");
		
		usuarioEJB.crear(u);
		Usuario us = usuarioEJB.buscar(18);
		Assert.assertNotNull(us);
		
	}
	
	@AfterClass
	public static void finalizar(){
		TestDataUtil.ejecutarSQL("sqltest/prueba-del.sql");
		System.err.println("Finalizar");
	}
	
}
