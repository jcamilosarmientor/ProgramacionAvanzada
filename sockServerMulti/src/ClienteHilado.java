
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Estudiantes
 */
public class ClienteHilado extends Thread{

    private String mensajeCliente;
    private String []cliente1;    //
    private String []cliente2;
    private final Socket cliente;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;

    private byte buffer[]; // Un area de memoria que se utiliza para guardar los datos que leemos del cliente
    
    public ClienteHilado(Socket cliente) {
        this.cliente = cliente;
        buffer = new byte[512];                
    }
    
    public void run(){
        try {            
            // Alguien se ha conectado
            // obtenemos los flujos del cliente que se conecto
            datosEntrada = new DataInputStream(cliente.getInputStream());
            datosSalida = new DataOutputStream(cliente.getOutputStream());
            
            
       while(true){
            // Obtenemos un mensaje que fijo el cliente nos envía
            System.out.println("Esperando un mensaje...");
            datosEntrada.read(buffer);
            mensajeCliente = new String(buffer); 
            // nos ha llegado un mensaje, entonces vamos a imprimir lo que llego
            System.out.println("* El mensaje que llega: \n\n" + mensajeCliente);
            
            /*
            De esta forma el programa establece la conexion entre las 2 personas dependiendo quien inice la conversacion:
            
            1. el programa toma el mensaje recibido (mensajeCliente), si comienza con ip_cliente
            
            2. entonces valida los arreglos cliente1 y cliente2, que comienzan vacios. Valida primero el tamaño del arreglo cliente1, 
            como esta vacio, utiliza el metodo split sobre mensajeCliente para separar el string con el simbolo : y 
            asginandolo a cliente1, quedando de la siguiente forma: 
                cliente1 = {"ip_cliente", ipDelCliente}
            
            3. cuando la segunda persona inicie la conversacion con la primera,como cliente1 ya no tiene un tamaño 0, se hace la asignacion
            (tambien por el metodo split) para el cliente2
            
            ej: 
                1. juan inicia la conversacion
                    1.1 cliente1.length = 0 ? (true)
                    1.2 cliente1 = {"ip_cliente:", ipDeJuan};
                2. samuel inicia la conversacion co juan:
                    2.1 cliente1.length =0 ? (false)
                    2.2 cliente2 = {"ip_cliente:", ipDeSamuel} 
            */
            if (mensajeCliente.startsWith("ip_cliente:")) {
                if(cliente1.length == 0) {
                    cliente1 = mensajeCliente.split(":");
                    System.out.println(cliente1[1]);
                } else {
                    cliente2 = mensajeCliente.split(":");
                    System.out.println(cliente2[1]);
                }
            } 
            // me llego mensaje...ahora contesto "Hola!"
            String mensaje = new String(buffer) + "✓";
            
            datosSalida.write(mensaje.getBytes());
       }
            // terminamos el procesamiento del socket
            //System.out.println("\nFIN de este socket " + cliente.getInetAddress().getHostAddress());
            //datosEntrada.close();
            //datosSalida.close();
            //cliente.close();
        } catch (IOException ex) {
            System.out.println("Error en los datos: " + ex.getMessage());
        }
    }

}
