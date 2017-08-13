package examen.servidorchat;

import examen.HiloDelCliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;

/**
 * Servidor de chat. Acepta conexiones de clientes, crea un hilo para
 * atenderlos, y espera la siguiente conexion.
 */
public class ServidorChat {
	/** Lista en la que se guaradara toda la conversacion */
	private DefaultListModel charla = new DefaultListModel();


	/**
	 * Se mete en un bucle infinito para ateder clientes, lanzando un hilo para cada
	 * uno de ellos.
	 */
	public ServidorChat() {
		try {
                    	ServerSocket socketServidor = new ServerSocket(8088);
			System.out.println("Server chat escuchando puerto 8088");
			while (true) {
				Socket cliente = socketServidor.accept();
				// Thread nuevoCliente = new HiloDelCliente(charla, cliente);
				// Thread hilo = new Thread(nuevoCliente);
				// hilo.start();
				HiloDelCliente hiloCliente = new HiloDelCliente(charla, cliente);
				hiloCliente.start();
                                socketServidor.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
                        
		}
	}
}