/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;

/**
 *
 * @author jeez
 */
public class Main {
    private static DefaultListModel charla = new DefaultListModel();
    public static void main(String args[]) {
        new ChatServer();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
//                new TamanoMatriz().setVisible(true);
//               
//            }
//        });
    }
//    public static void ServidorChat() {
//		try {
//			ServerSocket socketServidor = new ServerSocket(8088);
//			System.out.println("Server chat escuchando puerto 8088");
//			while (true) {
//				Socket cliente = socketServidor.accept();
//				// Thread nuevoCliente = new HiloDelCliente(charla, cliente);
//				// Thread hilo = new Thread(nuevoCliente);
//				// hilo.start();
//				HiloDelCliente hiloCliente = new HiloDelCliente(charla, cliente);
//				hiloCliente.start();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
