package co.edu.eam.ingesoft.pa.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;

@Named
@FacesConverter(value="facultad", forClass = Facultad.class)
public class FacultadConverter implements Converter{

	@EJB
	private BOFacultadEJB facultadEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Facultad f = facultadEJB.buscar(value);
		if(f!=null){
			return f;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Facultad){
			Facultad f = (Facultad)value;
			return f.getId();
		}
		return null;
	}

	
	
	
}
