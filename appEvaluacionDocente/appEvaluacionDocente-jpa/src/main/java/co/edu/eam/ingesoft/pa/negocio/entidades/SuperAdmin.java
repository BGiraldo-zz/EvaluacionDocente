package co.edu.eam.ingesoft.pa.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_SUPERADMIN")
public class SuperAdmin extends Usuario {

	public SuperAdmin() {

	}

	public SuperAdmin(int id, String nombre, String apellido, String usuario, String pass) {
		super(id, nombre, apellido, usuario, pass);
	}

	

}
