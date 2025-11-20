package Ejercicio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
    private final int puerto;
    private final ExecutorService pool = Executors.newCachedThreadPool();

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void iniciarServidor() {
        System.out.println("Servidor iniciando en puerto " + puerto);
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            while (true) {
                System.out.println("Esperando jugador 1...");
                Socket s1 = serverSocket.accept();
                System.out.println("Jugador 1 conectado: " + s1.getRemoteSocketAddress());
                System.out.println("Esperando jugador 2...");
                Socket s2 = serverSocket.accept();
                System.out.println("Jugador 2 conectado: " + s2.getRemoteSocketAddress());
                pool.submit(() -> gestionarPartida(s1, s2));
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private void gestionarPartida(Socket s1, Socket s2) {
        try (Socket socket1 = s1; Socket socket2 = s2;
             BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
             PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
             BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
             PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true)) {


            out1.println("WELCOME|TURNO|X");
            out2.println("WELCOME|TURNO|O");

            String nombre1 = in1.readLine();
            String nombre2 = in2.readLine();
            Jugador j1 = new Jugador(nombre1 == null ? "Jugador1" : nombre1, "X");
            Jugador j2 = new Jugador(nombre2 == null ? "Jugador2" : nombre2, "O");
            Partida partida = new Partida(j1, j2);

            out1.println("START|ERES|X");
            out2.println("START|ERES|O");

            out1.println("ESTADO|" + partida.estadoActual());
            out2.println("ESTADO|" + partida.estadoActual());

            while (!partida.isTerminada()) {
                if (partida.estadoActual().contains("TURNO:X")) {
                    out1.println("YOUR_MOVE");
                    out2.println("OPPONENT_MOVE");
                    String line = in1.readLine();
                    if (line == null) break;
                    if (line.startsWith("MOVE|")) {
                        String[] parts = line.split("\\|");
                        int f = Integer.parseInt(parts[1]);
                        int c = Integer.parseInt(parts[2]);
                        boolean ok = partida.validarMovimiento(f, c, "X");
                        if (!ok) out1.println("INVALID"); else {
                            partida.cambiarTurno();
                        }
                    }
                } else {
                    out2.println("YOUR_MOVE");
                    out1.println("OPPONENT_MOVE");
                    String line = in2.readLine();
                    if (line == null) break;
                    if (line.startsWith("MOVE|")) {
                        String[] parts = line.split("\\|");
                        int f = Integer.parseInt(parts[1]);
                        int c = Integer.parseInt(parts[2]);
                        boolean ok = partida.validarMovimiento(f, c, "O");
                        if (!ok) out2.println("INVALID"); else {
                            partida.cambiarTurno();
                        }
                    }
                }
                
                out1.println("ESTADO|" + partida.estadoActual());
                out2.println("ESTADO|" + partida.estadoActual());
                if (partida.finalizarSiCorresponde()) break;
            }

            out1.println("END|" + partida.estadoActual());
            out2.println("END|" + partida.estadoActual());

        } catch (IOException e) {
            System.err.println("Error gestionando partida: " + e.getMessage());
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
