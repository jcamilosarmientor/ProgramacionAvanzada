
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Juan Camilo Sarmiento Reyes
 * @author Samuel Holguin
 * @version 0.1
 */
public class SockClient {

    private int puerto;     //puerto del servidor
    private String hostIP;  //host del servidor
    private String mensajeCliente; //mensaje enviado desde el cliente

    private ArrayList<Mensaje> conversacion;
    private Mensaje mensaje;

    private Socket host;        //socket del servidor
    private Socket cliente2;    //socket de la persona que se conecta conmigo
    private ServerSocket host2; //serverSocket para recibir mensajes desde el servidor

    private BufferedReader lector;
    private BufferedReader lectorCliente;
    private PrintWriter escritor;

    public SockClient() {
        try {
            puerto = 7010;
            hostIP = "localhost";
            conversacion = new ArrayList<>();

            System.out.println("Iniciando el cliente...");
            System.out.println("Estableciendo la conexión con " + hostIP);

            host = new Socket(hostIP, puerto);
            // Capturamos los flujos
            //host2 = new ServerSocket(7020);
            //cliente2 = host2.accept();
            lector = new BufferedReader(new InputStreamReader(host.getInputStream()));
            escritor = new PrintWriter(host.getOutputStream(), true);
            //lectorCliente = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error en SockClient.establecerSocket: " + e.getMessage());
        }
    }

    /**
     * Método para enviar mensajes al servidor
     *
     */
    public void enviarMensaje() {
        Thread hiloEnviar = new Thread(() -> {
            try {
                if (host.isConnected()) {
                    // Enviamos un mensaje
                    System.out.println("Enviando un mensaje...");
                    int[] horaMensaje = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND};
                    mensaje = new Mensaje(mensajeCliente, -1, horaMensaje, "10.20.188.147");
                    conversacion.add(mensaje);

                    escritor.println(conversacion.indexOf(mensaje) + " " + mensaje.getTexto() + " " + mensaje.getIpReceptor());
                    CamaleonChat.jTextArea1.setText(null);

                } else {
                    System.out.println(host);
                }
            } catch (Exception e) {
                System.out.println("Error en SockCliente.enviarMensaje: " + e.getMessage());
            }
        });

        hiloEnviar.start();
    }

    /**
     * Método para mostrar los mensajes que se reciben desde el servidor
     *
     */
    public void mostrarMensaje() {
        Thread hiloLeer = new Thread(() -> {
            String[] mensajeServidor;
            try {
                CamaleonChat.jTextArea2.setText(null);
                mensajeServidor = lector.readLine().split(" ");
                cambiarEstados(Integer.parseInt(mensajeServidor[0]), Integer.parseInt(mensajeServidor[2]));

                for (Mensaje mensaje1 : conversacion) {

                    String mensajeVista = "Cliente: " + mensaje1.getTexto();

                    switch (mensaje1.getEstado()) {
                        case 0: //Enviado
                            mensajeVista += " ✓";
                            break;
                        case 1: //Recibido
                            mensajeVista += " ✓✓";
                            break;
                        case 2: //Leido
                            mensajeVista += " ✓✓✓";
                            break;
                        default: //No ha llegado al servidor
                            mensajeVista += " ?";
                            break;
                    }

                    mensajeVista += "\n";
                    CamaleonChat.jTextArea2.append(mensajeVista);
                    System.out.println(mensaje1.getTexto() + "|" + mensaje1.getEstado());
                }

            } catch (IOException ex) {
                CamaleonChat.jTextArea2.append("Error al establecer conexión con el servidor.");
                System.out.println("Error en SockCliente.mostrarMensaje:" + ex.getMessage());
            }
        });
        hiloLeer.start();
    }

    private void cambiarEstados(int index, int estado) {
        Mensaje mensajeTemp = conversacion.get(index);
        conversacion.remove(index);
        mensajeTemp.setEstado(estado);
        conversacion.add(mensajeTemp);
    }

    public String getMensajeCliente() {
        return mensajeCliente;
    }

    public void setMensajeCliente(String mensajeCliente) {
        this.mensajeCliente = mensajeCliente;
    }

    public void attachShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    // terminamos el procesamiento del socket
                    host.close();
                } catch (IOException e) {
                    System.out.println("Error en ClienteHilado.attachShutDownHook: " + e.getMessage());
                }
            }
        });

    }
}
