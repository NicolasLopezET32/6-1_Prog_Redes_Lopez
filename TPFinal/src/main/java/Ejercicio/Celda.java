package Ejercicio;

public class Celda {

    private String estado = "VACIA";

    public void vaciar() {
        estado = "VACIA";
    }

    public boolean esVacia() {
        return "VACIA".equals(estado);
    }

    public boolean marcar(String simbolo) {
        if (!"X".equals(simbolo) && !"O".equals(simbolo)) return false;

        if (!esVacia()) return false;

        estado = simbolo;
        return true;
    }

    public String getEstado() {
        return estado;
    }

    public String toString() {
        return esVacia() ? " " : estado;
    }
}
