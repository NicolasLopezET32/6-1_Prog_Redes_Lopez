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

            String welcome = in.readLine();
            System.out.println("[SERVIDOR] " + welcome);
            System.out.print("Tu nombre: ");
            String nombre = scanner.nextLine();
            out.println(nombre);

            String start = in.readLine();
            System.out.println("[SERVIDOR] " + start);

            String estadoLine = in.readLine();
            System.out.println(estadoLine.substring(7)); 

            while (true) {
                String serverMsg = in.readLine();
                if (serverMsg == null) break;
                if (serverMsg.startsWith("YOUR_MOVE")) {
                    System.out.println("Es tu turno. Ingresa fila y columna separados por espacio (ej: 0 2):");
                    String line = scanner.nextLine();
                    String[] parts = line.trim().split("\\s+");
                    int f = Integer.parseInt(parts[0]);
                    int c = Integer.parseInt(parts[1]);
                    out.println("MOVE|" + f + "|" + c);
                } else if (serverMsg.startsWith("OPPONENT_MOVE")) {
                    System.out.println("Esperando movimiento del oponente..."); 
                } else if (serverMsg.startsWith("INVALID")) {
                    System.out.println("Movimiento inválido. Intenta otra casilla."); 
                } else if (serverMsg.startsWith("ESTADO|")) {
                    String estado = serverMsg.substring(7);
                    System.out.println(estado);
                } else if (serverMsg.startsWith("END|")) {
                    String finalEstado = serverMsg.substring(4);
                    System.out.println("Partida finalizada:\n" + finalEstado);
                    break;
                } else {
                    System.out.println("[SERVIDOR] " + serverMsg);
                }
            }
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