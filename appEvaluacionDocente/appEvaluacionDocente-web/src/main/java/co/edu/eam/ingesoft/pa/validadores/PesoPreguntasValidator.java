package co.edu.eam.ingesoft.pa.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="pesopreval")
public class PesoPreguntasValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		if(value instanceof Double){
			double valor = (Double)value;
			if(valor <= 0 || valor > 100){
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN,"El "
						+ "número no debe ser menor a '0' o mayor a '100' ",null));
			}
		}else{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN,"El "
					+ " dato insertado no es valido",null));
		}
	}

}
