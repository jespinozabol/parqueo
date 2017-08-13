package examen;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Hilo encargado de atender a un cliente.
 */
public class HiloDelCliente extends Thread implements ListDataListener {

    /**
     * Lista en la que se guarda toda la charla
     */
    private DefaultListModel charla;

    /**
     * Socket al que está conectado el cliente
     */
    private Socket socket;

    /**
     * Para lectura de datos en el socket
     */
    private DataInputStream dataInput;

    /**
     * Para escritura de datos en el socket
     */
    private DataOutputStream dataOutput;
    private String[][] _message;
    /**
     * Crea una instancia de esta clase y se suscribe a cambios en la charla.
     *
     * @param charla La lista de textos que componen la charla del chat
     * @param socket Socket con el cliente.
     */
    public HiloDelCliente(DefaultListModel charla, Socket socket) {
        this.charla = charla;
        this.socket = socket;
        try {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            charla.addListDataListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
     public HiloDelCliente(String[][] message) throws IOException {
         socket = new Socket("localhost", 8088);
        dataOutput = new DataOutputStream(socket.getOutputStream());
           String texto = inputString(message);
        try {
            dataOutput.writeUTF(inputString(message));
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
     }

    public String inputString(String[][] arr) {
        StringBuilder builder = new StringBuilder();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (String[] row : arr) {
            sj.add(Arrays.toString(row));
        }
        return sj.toString();        
    }

    /**
     * Atiende el socket. Todo lo que llega lo mete en la charla.
     */
    @Override
    public void run() {
        try {
 //           while (true) {
                String texto = dataInput.readUTF();
                synchronized (charla) {
                    charla.addElement(texto);
                    charla.notify();
                    //Este println muestra en la consola del servidor lo que hablan los clientes
                    System.out.println(texto);
                }
   //         }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(socket.getInetAddress() + " se ha ido!");
        }
    }

    /**
     * Envía el último texto de la charla por el socket. Se avisa a este método
     * cada vez que se mete algo en charla, incluido cuando lo mete este mismo
     * hilo. De esta manera, lo que un cliente escriba, se le reenviará para que
     * se muestre en el textArea.
     */
    @Override
    public void intervalAdded(ListDataEvent e) {
        String texto = (String) charla.getElementAt(e.getIndex0());
        try {
            dataOutput.writeUTF(inputString(_message));
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
    }

    /**
     * No hace nada, pero se escribe porque el implments los requiere.
     */
    @Override
    public void intervalRemoved(ListDataEvent e) {
    }

    /**
     * No hace nada, pero se escribe porque el implments los requiere.
     */
    @Override
    public void contentsChanged(ListDataEvent e) {
    }
}
