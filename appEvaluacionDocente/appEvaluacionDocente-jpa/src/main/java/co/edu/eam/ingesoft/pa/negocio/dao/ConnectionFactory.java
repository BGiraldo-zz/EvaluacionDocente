package co.edu.eam.ingesoft.pa.negocio.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//import co.edu.eam.ingesis.gestorlab.persistencia.dao.implementaciones.jpa.FabricaDAOJPA;
//import co.edu.eam.ingesis.gestorlab.persistencia.excepciones.PersistenciaException;

/**
 * Clase para obtener una conection jdbc a base de datos
 * @author Camilo Andres Ferrer Bustos<br/>
 *         email: caferrerb@gmail.com <br/>
 *         Fecha: 17/11/2015<br/>
 */
public class ConnectionFactory {
	
	/**
	 * Metoodo para obtener la conexion
	 * @author Camilo Andres Ferrer Bustos<br/>
	 *         email: caferrerb@gmail.com <br/>
	 *         Fecha: 17/11/2015<br/>
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws PersistenciaException 
	 */
	public static Connection getConnection() throws  Exception{
		Properties props=new Properties();
		try {
			
			props.load(ConnectionFactory.class.getResourceAsStream("/database.properties"));
			
			Class.forName(props.getProperty("javax.persistence.jdbc.driver"));
			System.out.println("2....");
			return DriverManager.getConnection(props.getProperty("javax.persistence.jdbc.url"), 
					props.getProperty("javax.persistence.jdbc.user"), props.getProperty("javax.persistence.jdbc.password"));
		 
		} catch (Exception e) {
			throw new Exception("No se pudo conectar a la BD", e);
			
		}
	}

}
