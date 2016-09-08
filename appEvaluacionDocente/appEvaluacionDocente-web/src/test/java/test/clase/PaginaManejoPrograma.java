package test.clase;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Location("paginas/ManejoPrograma.jsf")
public class PaginaManejoPrograma {

	
	@Drone
	private WebDriver browser;
	
	@FindBy(id="tfPrograma")
	private WebElement tfCode;
	
	@FindBy(id="tfNombre")
	private WebElement tfNombre;
	
	@FindBy(id="comboFa_input")
	private Select cbFacultad;
	
	@FindBy(id="btnRegistrar")
	private WebElement btnRegistar;
	
	@FindBy(id="mensajes")
	private WebElement message;
	
	
	public String registrarPrograma(){
		
		tfCode.sendKeys("8");
		tfNombre.sendKeys("Mercadotecnia");
		cbFacultad.selectByValue("1");
		
		Graphene.guardAjax(btnRegistar).click();
		Graphene.waitModel().until().element(message).is().present();
		
		return message.getText();
	}
	
	
}
