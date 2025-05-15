package Guia_Ejercicios_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import Guia_Ejercicios_1.Ejercicios;

public class main {
    
    public static void main(String[] args) {
        PrintStream ps = new PrintStream(System.out);
        PrintStream psErr = new PrintStream(System.err);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = -1;

        while (opcion != 0) {
            ps.println("\n===== MENÚ DE OPCIONES =====");
            ps.println("1. Calcular Salario Bruto");
            ps.println("2. Calcular Valor de Ángulo Restante");
            ps.println("3. Calcular Perímetro de un Cuadrado");
            ps.println("4. Convertir Fahrenheit a Celsius");
            ps.println("5. Transformar Segundos a Días, Horas, Minutos y Segundos");
            ps.println("6. Calcular Plan de Pagos");
            ps.println("7. Calcular Mes de Nacimiento según Signo");
            ps.println("8. Ordenar Apellidos Alfabéticamente");
            ps.println("9. Indicar el Número Menor");
            ps.println("10. Indicar si un Número es Par o Impar");
            ps.println("11. Calcular si un Número es Divisible por Otro");
            ps.println("12. Calcular Signo Zodiacal por Fecha de Nacimiento");
            ps.println("13. Comparar Apellidos y Ver cuál es Más Largo");
            ps.println("14. Mostrar Tabla de Multiplicar de un Número");
            ps.println("15. Indicar si un Número es Primo");
            ps.println("0. Salir");
            ps.println("");
            ps.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1 -> Ejercicios.salarioBruto(ps);
                    case 2 -> Ejercicios.valoresTriangulo(ps);
                    case 3 -> Ejercicios.calcularPerimetroCuadrado(ps);
                    case 4 -> Ejercicios.temperaturaGradosCentigrados(ps);
                    case 5 -> Ejercicios.tiempoSegundos(ps);
                    case 6 -> Ejercicios.calcularPlan(ps);
                    case 7 -> Ejercicios.signoZodiacal(ps);
                    case 8 -> Ejercicios.ordenarAlfabeticamente(ps, psErr, br);
                    case 9 -> Ejercicios.indicarMenor(ps, psErr, br);
                    case 10 -> Ejercicios.indicarPar(ps, psErr, br);
                    case 11 -> Ejercicios.indicarSiDivisible(ps, psErr, br);
                    case 12 -> Ejercicios.calcularFechaNacimiento(ps, psErr, br);
                    case 13 -> Ejercicios.calcularApellidoMasLargo(ps, psErr, br);
                    case 14 -> Ejercicios.indicarMultiplos(ps, psErr, br);
                    case 15 -> Ejercicios.indicarSiEsPrimo(ps, psErr, br);
                    case 0 -> {
                        ps.println("Saliendo del programa...");
                        break;
                    }
                    default -> ps.println("Opción inválida. Intente nuevamente.");
                }

                if (opcion != 0) {
                    ps.println("\nPresione ENTER para volver al menú...");
                    br.readLine();
                }

            } catch (IOException | NumberFormatException e) {
                psErr.println("El dato ingresado es incorrecto: " + e.getMessage());
            }
        }
    }
}