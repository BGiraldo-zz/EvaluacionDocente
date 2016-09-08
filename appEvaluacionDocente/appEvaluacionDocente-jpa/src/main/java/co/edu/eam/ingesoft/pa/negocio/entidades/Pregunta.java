package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase para tener control sobre las
 * preguntas de la evaluacion
 * @author Giraldo
 *
 */

@Entity
@Table(name = "T_PREGUNTA")
@XmlRootElement
@NamedQueries({@NamedQuery(name=Pregunta.PREGUNTA_LISTAR, query="SELECT p FROM Pregunta p")})
public class Pregunta implements Serializable {

	/* Atributos */
	
	public static final String PREGUNTA_LISTAR = "Pregunta.listar";
	
	@Id
	@Column(name="ID_PREGUNTA", nullable = false)
	private int id;
	
	@Size(min = 8, max = 200, message = "La longitud de la pregunta es incorrecta")
	@Column(name="TEXTO", nullable = false, length = 200)
	private String texto;
	
	@Column(name="VALOR", nullable = false)
	private double valor;

	/* Constructor */
	
	public Pregunta(int id, String texto, double valor) {
		super();
		this.id = id;
		this.texto = texto;
		this.valor = valor;
	}
	
	public Pregunta(){
		
	}

	/* Getters y Setters */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
