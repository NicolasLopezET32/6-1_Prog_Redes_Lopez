package TP1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        final int LONGITUD = 5;
        int[] arreglo1 = new int[LONGITUD];
        int[] arreglo2 = new int[LONGITUD];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintStream consola = System.out;

        pedirNumerosPorConsola(arreglo1, arreglo2, entrada, consola);

        cargarDesdeArchivo("entrada.txt", arreglo1, arreglo2, consola);

        consola.println("\nDatos cargados en memoria (arreglo1):");
        imprimirArreglo(arreglo1, consola);

        guardarEnArchivo("final.txt", arreglo2, consola);

        procesarDivisiones(arreglo1, "resultados.txt", "errores.txt", consola);
    }

    private static void pedirNumerosPorConsola(int[] arr1, int[] arr2, BufferedReader entrada, PrintStream consola) {
        while (true) {
            try {
                consola.print("Ingresá un número cualquiera: ");
                arr1[3] = Integer.parseInt(entrada.readLine());

                consola.print("Ingresá un 0 (obligatorio): ");
                int cero1 = Integer.parseInt(entrada.readLine());
                if (cero1 != 0) throw new IllegalArgumentException("Debe ingresar 0.");

                arr1[4] = cero1;

                consola.print("Ingresá otro número cualquiera: ");
                arr2[3] = Integer.parseInt(entrada.readLine());

                consola.print("Ingresá un 0 (obligatorio): ");
                int cero2 = Integer.parseInt(entrada.readLine());
                if (cero2 != 0) throw new IllegalArgumentException("Debe ingresar 0.");

                arr2[4] = cero2;
                break;
            } catch (IOException e) {
                consola.println("Error de entrada/salida. Intente nuevamente.");
            } catch (NumberFormatException e) {
                consola.println("Entrada inválida. Debe ingresar un número.");
            } catch (IllegalArgumentException e) {
                consola.println(e.getMessage());
            }
        }
    }

    private static void cargarDesdeArchivo(String archivo, int[] arr1, int[] arr2, PrintStream consola) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null && i < 6) {
                try {
                    int numero = Integer.parseInt(linea.trim());
                    if (i < 3)
                        arr1[i] = numero;
                    else
                        arr2[i - 3] = numero;
                    i++;
                } catch (NumberFormatException e) {

                }
            }
        } catch (IOException e) {
            consola.println("No se pudo leer '" + archivo + "': " + e.getMessage());
        }
    }

    private static void imprimirArreglo(int[] arreglo, PrintStream consola) {
        for (int valor : arreglo) {
            consola.println(valor);
        }
    }

    private static void guardarEnArchivo(String nombreArchivo, int[] datos, PrintStream consola) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            escritor.write("Los datos guardados en el archivo (memoria no-volátil) son:");
            escritor.newLine();
            for (int dato : datos) {
                escritor.write(String.valueOf(dato));
                escritor.newLine();
            }
            consola.println("Datos guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void procesarDivisiones(int[] datos, String archivoResultados, String archivoErrores, PrintStream consola) {
        try (
        	BufferedWriter resWriter = new BufferedWriter(new FileWriter(archivoResultados));
            BufferedWriter errWriter = new BufferedWriter(new FileWriter(archivoErrores))
        ) {
            for (int i = 0; i < datos.length; i++) {
                int dividendo = datos[i];
                try {
                    if (i + 1 >= datos.length)
                        throw new ArrayIndexOutOfBoundsException("No hay siguiente número para dividir.");

                    int divisor = datos[i + 1] - 3;

                    if (divisor == 0)
                        throw new ArithmeticException("No puede dividirse por cero.");

                    double resultado = (double) dividendo / divisor;
                    resWriter.write(dividendo + " / " + divisor + " = " + resultado);
                    resWriter.newLine();

                } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                    String mensajeError = dividendo + " / n/a = " + e.getClass().getSimpleName() + ": " + e.getMessage();
                    errWriter.write(mensajeError);
                    errWriter.newLine();
                }
            }
            consola.println("Divisiones procesadas correctamente.");
        } catch (IOException e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
