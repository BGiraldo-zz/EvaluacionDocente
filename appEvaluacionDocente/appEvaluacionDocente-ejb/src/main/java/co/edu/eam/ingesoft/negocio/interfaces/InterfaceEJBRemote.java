package co.edu.eam.ingesoft.negocio.interfaces;

public interface InterfaceEJBRemote<T> {

	
	public void crear(T entidad);
	
	public T buscar(Object pk);
	
	public void editar(T entidad);

	public void eliminar(T entidad);


	
}
