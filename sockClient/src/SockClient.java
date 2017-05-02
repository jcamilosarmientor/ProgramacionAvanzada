
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SockClient {

    private Socket host;

    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;

    private String mensaje;

    private Scanner teclado;
    private int puerto;
    private String hostIP;

    BufferedReader lector = null;

    private byte buffer[]; // Un area de memoria que se utiliza para guardar los datos que leemos del cliente

    public String getMensaje() {

        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public SockClient() {
        this.principal = new Thread(() -> {
            try {
                host = new Socket("127.0.0.1",7010);
            } catch(IOException ex){
                System.out.println("Error en hilo principal" + ex.getMessage());
            }
        });
        puerto = 7010;
        teclado = new Scanner(System.in);
        buffer = new byte[512];

        System.out.println("Iniciando el cliente...");
        // System.out.print("Digite la direccion IP o nombre del host a conectar: ");
        hostIP = "localhost";//teclado.nextLine();
        System.out.println("Estableciendo la conexión con " + hostIP);
        
        try {
            host = new Socket(hostIP, puerto);
            // Capturamos los flujos
            datosEntrada = new DataInputStream(host.getInputStream());
            datosSalida = new DataOutputStream(host.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error en SockClient.establecerSocket: " + e.getMessage());
        }
    }

    Thread principal;

    public boolean enviarMensaje() {

        try {
            if (host.isConnected()) {
                // Enviamos un mensaje
                System.out.println("Enviando un mensaje...");
                datosSalida.write(mensaje.getBytes());

                // esperamos una resopuesta por parte del servidor
                datosEntrada.read(buffer);
                
                //mostrarMensaje(new String(buffer));
                
                //El string respuesta del servidor
                String respuestaServidor =  new String(buffer);
                String mensajeCliente; 
                
                System.out.println("El servidor nos contesta: " + respuestaServidor);
                if (!respuestaServidor.isEmpty()) {
                    System.out.println("if");
                    mensajeCliente = "Cliente: " + mensaje + " ✓ \n"; 
                } else {
                    System.out.println("else");
                    mensajeCliente = "Cliente:✓ " + mensaje;
                } 
                System.out.println("Mensaje cliente: " + mensajeCliente);
                CamaleonChat.jTextArea2.append(mensajeCliente);
                CamaleonChat.jTextArea1.setText(null);

            } else {
                System.out.println(host);
            }
            //Cuando se cierre la ventana se hace un metodo que llame a estas 3 lineas
            /*datosEntrada.close();
            datosSalida.close();
            host.close();*/
            return true;
        } catch (IOException e) {

            System.out.println("Error en SockCliente.enviarMensaje: " + e.getMessage());
            return false;
        }
    }

    public void mostrarMensaje(String mensaje) {
        Thread hiloLeer;
        hiloLeer = new Thread(() -> {
            try {
                lector = new BufferedReader(new InputStreamReader(host.getInputStream()));
                while (true) {
                    String msgRecibido = lector.readLine();
                    System.out.println("El servidor nos contesta: " + mensaje);
                    CamaleonChat.jTextArea2.append("Cliente#d%:" + mensaje);
                    CamaleonChat.jTextArea2.append("Cliente#d%:" + datosSalida);
                }
            } catch (IOException ex) {
                System.out.println("Error en leer el mensaje" + ex.getMessage());
            }
        });
        hiloLeer.start();
        /*try {
            lector = new BufferedReader(new InputStreamReader(host.getInputStream()));
            while (true) {
                String msgRecibido = lector.readLine();
                CamaleonChat.jTextArea2.append("Cliente#d%:" + msgRecibido);
                CamaleonChat.jTextArea2.append("Cliente#d%:" + datosSalida);
            }
        } catch (IOException ex) {
            System.out.println("Error en leer el mensaje" + ex.getMessage());
        }*/
    }
}
