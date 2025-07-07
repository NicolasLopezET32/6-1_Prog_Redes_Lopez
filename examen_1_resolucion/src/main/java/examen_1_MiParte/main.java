package examen_1_MiParte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class main {
	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
	
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	PrintStream ps = new PrintStream(System.out);
	
	public static void main(String[] args) throws IOException {
		
		boolean bucle = true;
		while(bucle) {
			mostrarMenu();
			System.out.print(ANSI_CYAN.concat("Ingrese el numero de la opcion: ").concat(ANSI_RESET));
			int opcion = pedirNumero();
			switch(opcion) {
				case 1:
					agregarDatos();
					break;
				case 2:
					eliminarDatos();
					break;
					 
				case 3:
					mostrarDatos();
					break;
					
				case 4: 
					salirArchivo();
					bucle = false;
					break;
					
				case 5: 
				default:
					PrintStream ps = new PrintStream(System.out);

					ps.print(ANSI_RED.concat("Debe seleccionar una de las 4 opciones.").concat(ANSI_RESET));
					break;
			}
			
			
		}
		
}

	private static int pedirNumero() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		int numero = isr.read() - 48;
		return numero;
	}
	
	
	private static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("===============================");
		System.out.println("	    MENU");
		System.out.println("===============================");
		System.out.println("1. Agregar datos nuevos al archivo.");
		System.out.println("2. Eliminar Datos.");
		System.out.println("3. Mostrar Datos.");
		System.out.println("4. Salir.");
		
		}
	private static void agregarDatos() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		PrintStream ps = new PrintStream(System.out);
		ps.println(ANSI_GREEN.concat("prueba agregarDatos").concat(ANSI_RESET));

	}
}