package co.edu.eam.ingesoft.pa.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

@Named
@FacesConverter(value = "programa", forClass = Programa.class)
public class ProgramaConverter implements Converter {

	@EJB
	private BOProgramaEJB programaEJB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Programa p = programaEJB.buscar(value);
		if (p != null) {
			return p;
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Programa){
			Programa p = (Programa)value;
			return p.getId();
		}
		return null;
	}

}
