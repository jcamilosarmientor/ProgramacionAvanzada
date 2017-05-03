
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Juan Camilo Sarmiento
 * @author Samuel Holguin
 * @author Alvaro algo
 * @version 0.1
 */
public class ClienteHilado extends Thread {

    private final String MENSAJE_RECIBIDO = "✓";
    private final String MENSAJE_ENVIADO = "✓✓";
    private final String MENSAJE_LEIDO = "Leído";

    private String[] mensajeCliente;    //
    private final Socket cliente1;
    
    private BufferedReader lector;
    private PrintWriter escritor;

    private byte buffer[]; // Un area de memoria que se utiliza para guardar los datos que leemos del cliente

    public ClienteHilado(Socket cliente) {
        this.cliente1 = cliente;
    }

    public void run() {
        try {
            // Alguien se ha conectado
            // obtenemos los flujos del cliente que se conecto
            lector = new BufferedReader(new InputStreamReader(cliente1.getInputStream()));
            escritor = new PrintWriter(cliente1.getOutputStream(), true);
            while (true) {
                // Obtenemos un mensaje que fijo el cliente nos envía
                System.out.println("Esperando un mensaje...");
                // nos ha llegado un mensaje, entonces vamos a imprimir lo que llego
                mensajeCliente = lector.readLine().split(" ");
                System.out.print("* El mensaje que llega de " + cliente1.getInetAddress().getHostAddress());
                System.out.println(" es: " + mensajeCliente[0]);
                escritor.println(mensajeCliente[0] + " " +mensajeCliente[1] + " 0");
            }

        } catch (IOException ex) {
            System.out.println("Error en los datos: " + ex.getMessage());
        }
    }

    public void attachShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    // terminamos el procesamiento del socket
                    cliente1.close();
                } catch (IOException e) {
                    System.out.println("Error en ClienteHilado.attachShutDownHook: " + e.getMessage());
                }
            }
        });
    }

}
