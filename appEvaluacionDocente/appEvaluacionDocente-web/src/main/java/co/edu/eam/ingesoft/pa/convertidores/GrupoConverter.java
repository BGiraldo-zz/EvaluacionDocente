package co.edu.eam.ingesoft.pa.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.negocio.bos.BOGrupoEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;

@Named
@FacesConverter(value="grupo", forClass = Grupo.class)
public class GrupoConverter implements Converter{

	@EJB
	private BOGrupoEJB grupoEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	    Grupo grupo = grupoEJB.buscar(value);
	    if(grupo!=null){
	    	return grupo;
	    }
	    
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	    if(value instanceof Grupo){
	    	Grupo g = (Grupo)value;
	    	return g.getId();
	    }
		return null;
	}

}
