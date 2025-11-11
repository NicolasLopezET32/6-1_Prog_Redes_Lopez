package tpfinal;


public class Tablero {
    private final Celda[][] tablero = new Celda[3][3];

    public Tablero() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = new Celda();
    }

    public synchronized boolean colocarSimbolo(int fila, int col, String simbolo) {
        if (fila < 0 || fila > 2 || col < 0 || col > 2) return false;
        return tablero[fila][col].marcar(simbolo);
    }

    public synchronized boolean esGanador(String simbolo) {
        for (int i = 0; i < 3; i++)
            if (simbolo.equals(tablero[i][0].getEstado()) &&
                simbolo.equals(tablero[i][1].getEstado()) &&
                simbolo.equals(tablero[i][2].getEstado())) return true;
        for (int j = 0; j < 3; j++)
            if (simbolo.equals(tablero[0][j].getEstado()) &&
                simbolo.equals(tablero[1][j].getEstado()) &&
                simbolo.equals(tablero[2][j].getEstado())) return true;
        if (simbolo.equals(tablero[0][0].getEstado()) &&
            simbolo.equals(tablero[1][1].getEstado()) &&
            simbolo.equals(tablero[2][2].getEstado())) return true;
        if (simbolo.equals(tablero[0][2].getEstado()) &&
            simbolo.equals(tablero[1][1].getEstado()) &&
            simbolo.equals(tablero[2][0].getEstado())) return true;

        return false;
    }

    public synchronized boolean esTableroCompleto() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j].esVacia()) return false;
        return true;
    }

    public synchronized boolean esEmpate() {
        return esTableroCompleto() && !esGanador("X") && !esGanador("O");
    }

    public synchronized String mostrarTablero() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  0 1 2\n");
        for (int i = 0; i < 3; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(tablero[i][j].toString());
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("  -+-+-\n");
        }
        return sb.toString();
    }
}
