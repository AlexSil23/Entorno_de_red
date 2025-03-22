package servidor_cliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * The Class ServidorTCP.
 * @author Alexander Silvera
 */
public class ServidorTCP {

	/**
	 * Método principal del servidor TCP que se encarga de inicializar y gestionar las conexiones de los clientes.
	 * 
	 * <p>Este método configura un servidor TCP en un puerto específico, esperando conexiones entrantes.
	 * Por cada cliente que se conecta, se crea un hilo separado usando la clase {@code Operador} 
	 * para gestionar las comunicaciones con ese cliente.</p>
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan en esta implementación). 
	 * 
	 * <p>El flujo general es el siguiente:</p>
	 * <ul>
	 *   <li>Se inicializa un {@code ServerSocket} en el puerto 2309.</li>
	 *   <li>El servidor entra en un bucle para aceptar conexiones entrantes.</li>
	 *   <li>Por cada conexión aceptada, se inicia un nuevo hilo {@code Operador}.</li>
	 *   <li>Si ocurre una excepción {@code IOException}, se registra el error en el log.</li>
	 * </ul>
	 * 
	 * @see ServerSocket
	 * @see Socket
	 * @see Operador
	 */
	public static void main(String[] args) {
		boolean validador = true;
		int puerto = 2309;
		
		try(ServerSocket servidor = new ServerSocket(puerto);) { 
			System.out.println("Servidor Iniciado");
	        while (validador) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado.");
                new Operador(socket).start();
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
