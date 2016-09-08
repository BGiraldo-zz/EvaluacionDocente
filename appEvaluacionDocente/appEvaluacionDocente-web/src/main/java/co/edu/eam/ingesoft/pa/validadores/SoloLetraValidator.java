package co.edu.eam.ingesoft.pa.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@FacesValidator(value = "sololetraval")
public class SoloLetraValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		if(value instanceof String){
			String palabra = (String)value;
			if(!palabra.matches("[a-zA-Z ]*")){
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN
						,"El Nombre u Apellido solo debe contener letras",null));
			}
			
		}else{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN
					,"Porfavor indique correctamente los campos, solo letras",null));
		}
		
		
	}

}
