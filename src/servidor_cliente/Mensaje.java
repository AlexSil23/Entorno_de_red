package servidor_cliente;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Mensaje.
 * @author Alexander Silvera
 */
public class Mensaje implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The name. */
	private String name;
	
	/** The mensaje. */
	private String mensaje;
	
	/**
	 * Instantiates a new mensaje.
	 *
	 * @param name the name
	 * @param mensaje the mensaje
	 */
	public Mensaje(String name, String mensaje) {
		this.name = name;
		this.mensaje = mensaje;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * Sets the mensaje.
	 *
	 * @param mensaje the new mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Cliente [name=" + name + ", mensaje=" + mensaje + "]";
	}
}
