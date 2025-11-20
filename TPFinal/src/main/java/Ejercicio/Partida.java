package Ejercicio;

import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;


public class Partida {
    private final Tablero tablero = new Tablero();
    private Jugador jugador1;
    private Jugador jugador2;
    private volatile String turno;
    private final AtomicBoolean terminada = new AtomicBoolean(false);

    public Partida(Jugador j1, Jugador j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.turno = j1.getSimbolo();
    }

    public synchronized boolean validarMovimiento(int fila, int col, String simbolo) {
        if (terminada.get()) return false;
        if (!simbolo.equals(turno)) return false;
        return tablero.colocarSimbolo(fila, col, simbolo);
    }

    public synchronized String estadoActual() {
        StringBuilder sb = new StringBuilder();
        sb.append(tablero.mostrarTablero()).append("\n");
        if (tablero.esGanador("X")) sb.append("GANADOR:X\n");
        else if (tablero.esGanador("O")) sb.append("GANADOR:O\n");
        else if (tablero.esEmpate()) sb.append("EMPATE\n");
        else sb.append("EN_JUEGO\n");
        sb.append("TURNO:").append(turno).append("\n");
        return sb.toString();
    }

    public synchronized void cambiarTurno() {
        turno = "X".equals(turno) ? "O" : "X";
    }

    public synchronized boolean finalizarSiCorresponde() {
        if (tablero.esGanador("X") || tablero.esGanador("O") || tablero.esEmpate()) {
            terminada.set(true);
            return true;
        }
        return false;
    }

    public boolean isTerminada() {
        return terminada.get();
    }
}
