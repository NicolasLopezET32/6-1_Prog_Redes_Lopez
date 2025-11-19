package Ejercicio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    private final String host;
    private final int puerto;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;	
    private final Scanner scanner = new Scanner(System.in);

    public Cliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void conectarConServidor() {
        try {
            socket = new Socket(host, puerto);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String nombre = scanner.nextLine();
            out.println(nombre);

            String estadoLine = in.readLine();
            System.out.println(estadoLine.substring(7)); 

        } catch (IOException e) {
            System.err.println("Error en cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException ignored) {}
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;
        if (args.length >= 1) host = args[0];
        if (args.length >= 2) {
            try { puerto = Integer.parseInt(args[1]); } catch (NumberFormatException ignored) {}
        }
        new Cliente(host, puerto).conectarConServidor();
    }
}