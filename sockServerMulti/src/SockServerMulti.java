
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
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
public class SockServerMulti {

    private ServerSocket host;
    private Socket cliente;

    private Scanner teclado;
    private int puerto;

    private boolean servidorActivado;
    private ArrayList clientesConectados;

    public SockServerMulti() {
        servidorActivado = true;
        puerto = 7010;
        teclado = new Scanner(System.in);
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
