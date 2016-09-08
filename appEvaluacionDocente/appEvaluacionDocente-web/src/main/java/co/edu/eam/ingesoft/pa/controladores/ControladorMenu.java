package co.edu.eam.ingesoft.pa.controladores;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;
 
@ManagedBean
public class ControladorMenu {
     
    public void save() {
        Messages.addGlobalInfo("Sucess");
    }
     
    public void update() {
    	   Messages.addGlobalInfo("Sucess");
    }
     
    public void delete() {
    	   Messages.addGlobalInfo("Sucess");
    }
     
   
}