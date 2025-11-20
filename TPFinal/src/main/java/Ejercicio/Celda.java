package Ejercicio;


public class Celda {
    private String estado; // "VACIA", "X", "O"

    public Celda() {
        this.estado = "VACIA";
    }

    public synchronized void vaciar() {
        this.estado = "VACIA";
    }

    public synchronized boolean esVacia() {
        return "VACIA".equals(this.estado);
    }

    public synchronized boolean marcar(String simbolo) {
        if (!esVacia()) return false;
        if (!"X".equals(simbolo) && !"O".equals(simbolo)) return false;
        this.estado = simbolo;
        return true;
    }

    public synchronized String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return esVacia() ? " " : estado;
    }
}
