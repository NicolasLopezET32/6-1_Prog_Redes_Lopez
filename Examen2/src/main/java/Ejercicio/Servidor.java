package Ejercicio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Servidor {
    private final int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void iniciarServidor() {
        System.out.println("Servidor iniciando en puerto " + puerto);
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            while (true) {
                System.out.println("Esperando cliente...");
                Socket s1 = serverSocket.accept();
                System.out.println("Cliente conectado: " + s1.getRemoteSocketAddress());
          
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        } 
    }

   
    public static void main(String[] args) {
        int puerto = 5000;
        if (args.length > 0) {
            try { puerto = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) {}
        }
        new Servidor(puerto).iniciarServidor();
    }
}