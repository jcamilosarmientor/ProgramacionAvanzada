
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            // nos ha llegado un mensaje, entonces vamos a imprimir lo que llego
            System.out.println("El mensaje que llega: \n\n" + new String(buffer));
            
            // me llego mensaje...ahora contesto "Hola!"
            String mensaje = "Recibido";
            
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
