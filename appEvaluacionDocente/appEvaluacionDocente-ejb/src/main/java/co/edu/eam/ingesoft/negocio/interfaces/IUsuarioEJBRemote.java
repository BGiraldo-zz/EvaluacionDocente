package co.edu.eam.ingesoft.negocio.interfaces;

import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

public interface IUsuarioEJBRemote extends InterfaceEJBRemote<Usuario>{

	public Usuario buscarUsuarioPorUsername(String username);
	
}
