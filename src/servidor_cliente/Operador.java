package servidor_cliente;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

// TODO: Auto-generated Javadoc
/**
 * The Class Operador.
 * 
 * @author Alexander Silvera
 */
public class Operador extends Thread {

	/** The socket. */
	private Socket socket;

	/** The oos. */
	private ObjectOutputStream oos; 

	/** The ois. */
	private ObjectInputStream ois;

	/**
	 * Instantiates a new operador.
	 *
	 * @param socket the socket
	 */
	public Operador(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Método que ejecuta la lógica del servidor para gestionar la comunicación con un cliente.
	 * 
	 * <p>Este método se ejecuta en un hilo separado por cada cliente conectado. 
	 * Permite recibir mensajes del cliente, procesarlos y enviar respuestas. 
	 * La comunicación se realiza a través de objetos serializados utilizando {@code ObjectInputStream} y {@code ObjectOutputStream}.</p>
	 * 
	 * <p>El flujo general es el siguiente:</p>
	 * <ul>
	 *   <li>Establece los streams de entrada y salida para la comunicación con el cliente.</li>
	 *   <li>Recibe y procesa los mensajes enviados por el cliente.</li>
	 *   <li>Si el cliente envía el mensaje "salir", se cierra la conexión.</li>
	 *   <li>En caso de errores de conexión o cierre inesperado, se captura y maneja la excepción.</li>
	 *   <li>Finalmente, cierra los recursos asociados a la conexión.</li>
	 * </ul>
	 * 
	 * @see Thread
	 * @see ObjectInputStream
	 * @see ObjectOutputStream
	 */
	@Override
	public void run() {
		String name = "Servidor";
		try {
			boolean validador = true;
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while (validador) {
				try {
					Mensaje cliente = (Mensaje) ois.readObject();
					String mensaje = cliente.getMensaje();
					System.out.println(cliente.getName() + ": " + mensaje);

					if (mensaje.equalsIgnoreCase("salir")) {
						System.out.println("El cliente ha cerrado la conexión.");
					} else {
						String respuesta = name + ": " + mensaje.toUpperCase();
						oos.writeObject(respuesta);
					}
				} catch (EOFException e) {
					System.out.println("El cliente ha cerrado la conexión.");
					validador = false;
				} catch (SocketException e) {
					System.out.println("El cliente ha cerrado la conexión.");
					validador = false;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
				socket.close();
				System.out.println("Conexión cerrada.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
