package test.clase;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Location("paginas/ManejoPreguntas.jsf")
public class PaginaManejoPregunta {

	@Drone
	private WebDriver browser;
	
	@FindBy(id="tfCodigo")
	private WebElement tfIdPreg;
	
	@FindBy(id="tfareaDescripcion")
	private WebElement tfDescripcion;
	
	@FindBy(id="tfValor")
	private WebElement tfValor;
	
	@FindBy(id="btnRegistrar")
	private WebElement btnRegistar;
	
	@FindBy(id="mensajes")
	private WebElement message;
	
	
	public String registrarPregunta(){
	
		tfIdPreg.sendKeys("13");
		tfDescripcion.sendKeys("¿Realiza RetroAlimentación del parcial?");
	    double valor = 10/100;
		tfValor.sendKeys(""+valor);
		Graphene.guardAjax(btnRegistar).click();
		Graphene.waitModel().until().element(message).is().present();
		
		return message.getText();
	}
	
}
