import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class SockClient {

    private int puerto;     //puerto del servidor
    private String hostIP;  //host del servidor
    private String mensaje; //mensaje enviado desde el cliente
    private String miIp;    //ip del cliente

    private Socket host;    //socket del servidor
   
    private DataInputStream datosEntrada;   //tuberia para datos de entrada (desde el servidor)
    private DataOutputStream datosSalida;   //tuberia para datos de salida (desde el cliente)

    private BufferedReader lector = null;   //buffered para leer mensajes (aun no definitivo)

    private byte buffer[]; // Un area de memoria que se utiliza para guardar los datos que leemos del cliente

    public SockClient() {
        try {
            puerto = 7010;
            hostIP = "localhost";
            miIp = InetAddress.getLocalHost().getHostAddress();
            buffer = new byte[512];

            System.out.println("Iniciando el cliente...");
            // System.out.print("Digite la direccion IP o nombre del host a conectar: ");
            System.out.println("Estableciendo la conexión con " + hostIP);

            host = new Socket(hostIP, puerto);
            // Capturamos los flujos
            datosEntrada = new DataInputStream(host.getInputStream());
            datosSalida = new DataOutputStream(host.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error en SockClient.establecerSocket: " + e.getMessage());
        }
    }

    /**
     * Método para enviar mensajes al servidor
     *
     */
    public void enviarMensaje() {
        Thread hiloEscribir = new Thread(() -> {
            try {
                if (host.isConnected()) {
                    String mensajeCliente;
                    //String []informacionCliente = {mensaje, miIp};
                    // Enviamos un mensaje
                    System.out.println("Enviando un mensaje...");
                    datosSalida.write(mensaje.getBytes());
                    datosSalida.write(("ip_cliente: " + miIp).getBytes()); //apenas comienza el programa le envio mi ip al servidor

                    // esperamos una resopuesta por parte del servidor
                    datosEntrada.read(buffer);

                    //mostrarMensaje(new String(buffer));
                    //El string respuesta del servidor
                    String respuestaServidor = new String(buffer);

                    System.out.println("El servidor nos contesta: " + respuestaServidor);
                    if (!respuestaServidor.isEmpty()) {
                        mostrarMensaje(mensaje);
                    } else {
                        
                        mensajeCliente = "Cliente:✓ " + mensaje;
                    }
                    //System.out.println("Mensaje cliente: " + mensajeCliente);
                    //CamaleonChat.jTextArea2.append(mensajeCliente);
                    
                    CamaleonChat.jTextArea1.setText(null);

                } else {
                    System.out.println(host);
                }
                //Cuando se cierre la ventana se hace un metodo que llame a estas 3 lineas
                /*  datosEntrada.close();
                    datosSalida.close();
                    host.close();
                 */
            } catch (IOException e) {
                System.out.println("Error en SockCliente.enviarMensaje: " + e.getMessage());
            }
        });
        hiloEscribir.start();
    }

    /**
     * Método para mostrar los mensajes que se reciben desde el servidor
     *
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje) {
        Thread hiloLeer = new Thread(() -> {
            try {
                lector = new BufferedReader(new InputStreamReader(host.getInputStream()));
                while (true) {
                    String msgRecibido = lector.readLine();
                    System.out.println("El servidor nos contesta: " + mensaje);
                    CamaleonChat.jTextArea2.append("Cliente#d%:" + mensaje);
                }
            } catch (IOException ex) {
                System.out.println("Error en leer el mensaje" + ex.getMessage());
            }
        });
        hiloLeer.start();
    }

    //Métodos get y set
    public String getMensaje() {

        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
