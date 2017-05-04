
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 * @author Samuel Holguin
 * @author Alvaro algo
 */
public class SockServerMulti {

    private ServerSocket host;
    private Socket cliente;

    private int puerto;

    private boolean servidorActivado;
    private ArrayList clientesConectados;

    public SockServerMulti() {
        servidorActivado = true;
        puerto = 7010;
        clientesConectados = new ArrayList();

        // Crear el servidor
        System.out.println("Creando el servidor...");
        try {
            host = new ServerSocket(puerto);
            while (servidorActivado) {
                // Esperar que se conecte un cliente
                System.out.println("Esperando que un cliente se conecte al puerto " + puerto);
                cliente = host.accept();
                ClienteHilado miCliente = new ClienteHilado(cliente);
                clientesConectados.add(miCliente);
                miCliente.start();
            }
        } catch (IOException ex) {
            System.out.println("Error al crear el servidor : " + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        new SockServerMulti();
    }
}
