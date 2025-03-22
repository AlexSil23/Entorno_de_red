package servidor_cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteTCP.
 * @author Alexander Silvera
 */
public class ClienteTCP {
	private static volatile boolean validador = true;
	/**
	 * Método principal del cliente TCP que permite enviar y recibir mensajes desde un servidor.
	 * 
	 * <p>Este método establece una conexión TCP con un servidor en un puerto específico, 
	 * envía mensajes ingresados por el usuario y recibe las respuestas del servidor. 
	 * La conexión se mantiene activa hasta que el usuario ingresa el comando "salir".</p>
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan en esta implementación).
	 * 
	 * @throws SocketException Si hay un problema de conexión con el servidor.
	 * 
	 * <p>El flujo general es el siguiente:</p>
	 * <ul>
	 *   <li>Se conecta al servidor en el puerto 2309.</li>
	 *   <li>Solicita al usuario ingresar su nombre para el chat.</li>
	 *   <li>Permite al usuario escribir mensajes que se envían al servidor.</li>
	 *   <li>Recibe y muestra las respuestas del servidor.</li>
	 *   <li>Finaliza la conexión si el usuario escribe "salir" o si ocurre un error.</li>
	 * </ul>
	 * 
	 * @see Socket
	 * @see ObjectOutputStream
	 * @see ObjectInputStream
	 */
	public static void main(String[] args) throws SocketException { 
		Mensaje cliente;
		int puerto = 2309;
		
		
		try(Socket socket = new Socket("localhost", puerto);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in)) {

			System.out.println("Bienvenido, Ingrese su nombre: ");
			String name = sc.nextLine();

			System.out.println("Chat iniciado:");
			while (validador) {
				String text = sc.nextLine();
				cliente = new Mensaje(name, text);

				if (text.equalsIgnoreCase("salir")) {
					System.out.println("Conexión cerrada");
					cliente.setMensaje("salir");					
					validador = false;
					break; 
				}
				//Enviar
				cliente.setMensaje(text);
				oos.writeObject(cliente);
				//Leer
				String mensaje = (String) ois.readObject();
				System.out.println(mensaje);
			}
			
		}catch (SocketException e) {
			System.out.println("Error. Servidor desconectado.");
				//e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
