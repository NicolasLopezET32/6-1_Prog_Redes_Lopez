package Guia_Ejercicios_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Ejercicios {

	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		PrintStream psErr = new PrintStream(System.err);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			salarioBruto(ps);
			valoresTriangulo(ps);
			calcularPerimetroCuadrado(ps);
			temperaturaGradosCentigrados(ps);
			tiempoSegundos(ps);
			calcularPlan(ps);
			signoZodiacal(ps);
			ordenarAlfabeticamente(ps, psErr, br);
			indicarMenor(ps, psErr, br);
			indicarPar(ps, psErr, br);
			indicarSiDivisible(ps, psErr, br);
			calcularFechaNacimiento(ps, psErr, br);
			calcularApellidoMasLargo(ps, psErr, br);
			indicarMultiplos(ps, psErr, br);
			indicarSiEsPrimo(ps, psErr, br);
		} 
		catch (IOException | NumberFormatException e) {
			psErr.println("Error: " + e.getMessage());
		}
	}

	
	
	public static String leerLinea() {
	    PrintStream psErr = new PrintStream(System.err);
	    StringBuilder resultado = new StringBuilder();

	    try {
	        int caracter;
	        while ((caracter = System.in.read()) != -1) {
	            if (caracter == 10) { 
	                break;
	            } else if (caracter != 13) { 
	                resultado.append((char) caracter);
	            }
	        }
	    } catch (IOException e) {
	        psErr.println("Error: " + e.getMessage());
	    }

	    return resultado.toString().trim();
	}

	
	// Ejercicio 1

	
	public static void salarioBruto(PrintStream ps) {

		ps.print("Ingrese el pago recibido por hora laboral: ");
		int valorHora = Integer.parseInt(leerLinea());

		ps.print("Ingrese cantidad de horas trabajadas: ");
		int cantidadHoras = Integer.parseInt(leerLinea());
		
		int salarioBruto = valorHora * cantidadHoras;
		ps.println("El salario bruto es : " + salarioBruto);
		
	}
	
	public static void valoresTriangulo(PrintStream ps){
		ps.print("Ingrese valor del primer angulo interior: ");
		int primerAngulo = Integer.parseInt(leerLinea());
		
		ps.print("Ingrese valor del segundo angulo interior: ");
		int segundoAngulo = Integer.parseInt(leerLinea());
		
		int tercerAngulo = 180 - primerAngulo - segundoAngulo;
		ps.println("El valor del angulo restante es: " + tercerAngulo);
		
	}
	
	public static void calcularPerimetroCuadrado(PrintStream ps) {
		ps.print("Ingrese la superficie del cuadrado en m2: ");
		int superficie = Integer.parseInt(leerLinea());
		
		double perimetro = 4 * Math.sqrt(superficie);
		ps.println("El perimetro del cuadrado es: " + perimetro);
		
	}
	
	public static void temperaturaGradosCentigrados(PrintStream ps) {
		ps.print("Ingrese cantidad de Farehnheit");
		int tempFarenh = Integer.parseInt(leerLinea());
		
		double tempCelc = (32 - tempFarenh) * 0.55555;
		ps.println("La temperatura en Centrigrados es: " + tempCelc);

	}

	public static void tiempoSegundos(PrintStream ps){
		ps.print("Ingrese una cantidad de segundos: ");
		int segundosIn = Integer.parseInt(leerLinea());
		
		int segundos = 0;
		int minutos = 0;
		int horas = 0;
		int dias = 0;
		
		while (segundosIn > 0) {
			if (segundos < 60) {
				segundos = segundos + 1;
			} else {
				minutos = minutos + 1;
				segundos = 0;
			}
			if (minutos == 59) {
				horas = horas + 1;
				minutos = 0;
			}

			if (horas == 24) {
				dias = dias + 1;
				horas = 0;
			}

			segundosIn = segundosIn - 1;
		}

		ps.println("Los segundos ingresados equivalen a: " + dias + " dias, " + horas + " horas, " + minutos
				+ " minutos y " + segundos + " segundos");
		}
	
	public static void calcularPlan(PrintStream ps){
		
		ps.print("Ingrese el precio de un articulo: ");
		int precio = Integer.parseInt(leerLinea());
		double plan1 = precio - (precio * 0.1);
		double plan2 = precio + (precio * 0.1);
		double plan2Cont = plan2 / 2;
		double plan2Cuot = plan2Cont / 2;
		double plan3 = precio + (precio * 0.15);
		double plan3Cont = plan3 / 4;
		double plan3Cuot = (plan3 - plan3Cont) / 5;
		double plan4 = precio + (precio * 0.25);
		double plan4Cuot1 = (plan4 * 0.6) / 4;
		double plan4Cuot2 = (plan4 * 0.4) / 4;

		ps.println("A continuacion se muestran los precios a pagar en cada plan para este producto:");
		ps.println("Plan 1: $" + plan1 + " (todo al contado)");
		ps.println("Plan 2: $" + plan2 + " ($" + plan2Cont + " al contado y 2 cuotas de $" + plan2Cuot + ")");
		ps.println("Plan 3: $" + plan3 + " ($" + plan3Cont + " al contado y 5 cuotas de $" + plan3Cuot + ")");
		ps.println("Plan 4: $" + plan4 + " (4 cuotas de $" + plan4Cuot1 + " y 4 cuotas de $" + plan4Cuot2 + ")");
			
		}
		
    public static void signoZodiacal(PrintStream ps){
    	ps.print("Ingrese su signo zodiacal: ");
    	String signo = leerLinea();
    	
    	switch (signo) {
    	case "aries":
    		ps.println("Mes Aproximado: Marzo - Abril");
    		break;
    	case "geminis":
    		ps.println("Mes aproximado: Mayo - Junio");
			break;
		case "cancer":
			ps.println("Mes aproximado: Junio - Julio");
			break;
		case "leo":
			ps.println("Mes aproximado: Julio - Agosto");
			break;
		case "virgo":
			ps.println("Mes aproximado: Agosto - Septiembre");
			break;
		case "libra":
			ps.println("Mes aproximado: Septiembre - Octubre");
			break;
		case "escorpio":
			ps.println("Mes aproximado: Octubre - Noviembre");
			break;
		case "sagitario":
			ps.println("Mes aproximado: Noviembre - Diciembre");
			break;
		case "capricornio":
			ps.println("Mes aproximado: Diciembre - Enero");
			break;
		case "acuario":
			ps.println("Mes aproximado: Enero - Febrero");
			break;
		case "piscis":
			ps.println("Mes aproximado: Febrero - Marzo");
			break;
		default:
			ps.println("Signo no reconocido. Asegurate de escribirlo correctamente.");
		}
	}

    // Ejercicio 2
    
    public static void ordenarAlfabeticamente(PrintStream ps, PrintStream psErr, BufferedReader br) throws IOException {
		ps.print("Ingrese el primer apellido: ");
		String apellido1 = br.readLine();
		
		ps.print("Ingrese el segundo apellido: ");
		String apellido2 = br.readLine();
		
		ps.print("Ingrese el tercer apellido: ");
		String apellido3 = br.readLine();

		String[] apellidos = { apellido1, apellido2, apellido3 };

		Arrays.sort(apellidos);

		ps.println("Apellidos ordenados alfabéticamente:");
		for (String apellido : apellidos) {
			ps.println(apellido);
		}
	}
    
    public static void indicarMenor(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		ps.print("Ingrese el primer numero: ");
		double num1 = Double.parseDouble(br.readLine());

		ps.print("Ingrese el segundo numero: ");
		double num2 = Double.parseDouble(br.readLine());
		
		ps.print("Ingrese el tercer numero: ");
		double num3 = Double.parseDouble(br.readLine());
		
		ps.print("Ingrese el cuarto numero: ");
		double num4 = Double.parseDouble(br.readLine());
		
		double menor;
		if (num1 > num2) {
			
			
		}
		double[] numeros = { num1, num2, num3, num4 };

		Arrays.sort(numeros);

		ps.println("El numero mas chico ingresado es: " + numeros[0]);
	}
    
    public static void indicarPar(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
    	ps.print("Ingrese un numero: ");
    	int num = Integer.parseInt(br.readLine());
    	
    	if (num % 2 == 0) {
    		ps.println("El numero es par");
    	} else {
    		ps.println("El numero es impar");
    	}
    	
    }
    
    public static void indicarSiDivisible(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
    	ps.print("Ingrese un numero: ");
    	double num1 = Double.parseDouble(br.readLine());
    	
    	ps.print("Ingrese otro numero: ");
    	double num2 = Double.parseDouble(br.readLine());
    	
    	double[] numeros = {num1, num2};
    	
    	Arrays.sort(numeros);
    	
    	if (numeros[0] % numeros[1] == 0) {
    		ps.print("El numero " + numeros[0] + "es divisible por el numero: " + numeros[1]);
    	} else {
    		ps.print("El numero " + numeros[0] + "no es divisible por el numero:" + numeros[1]);
    	}
    
    }
    
    public static void calcularFechaNacimiento(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
    	ps.print("Ingresá tu día de nacimiento usando los numeros de entre 1 al 31: ");
		int dia = Integer.parseInt(br.readLine());

		ps.print("Ingresá tu mes de nacimiento usando numeros de entre 1 al 12: ");
		int mes = Integer.parseInt(br.readLine());

		String signo = null;

		if (mes == 1) {
			signo = (dia < 20) ? "Capricornio" : "Acuario";
		} else if (mes == 2) {
			signo = (dia < 19) ? "Acuario" : "Piscis";
		} else if (mes == 3) {
			signo = (dia < 21) ? "Piscis" : "Aries";
		} else if (mes == 4) {
			signo = (dia < 20) ? "Aries" : "Tauro";
		} else if (mes == 5) {
			signo = (dia < 21) ? "Tauro" : "Geminis";
		} else if (mes == 6) {
			signo = (dia < 21) ? "Geminis" : "Cancer";
		} else if (mes == 7) {
			signo = (dia < 23) ? "Cancer" : "Leo";
		} else if (mes == 8) {
			signo = (dia < 23) ? "Leo" : "Virgo";
		} else if (mes == 9) {
			signo = (dia < 23) ? "Virgo" : "Libra";
		} else if (mes == 10) {
			signo = (dia < 23) ? "Libra" : "Escorpio";
		} else if (mes == 11) {
			signo = (dia < 22) ? "Escorpio" : "Sagitario";
		} else if (mes == 12) {
			signo = (dia < 22) ? "Sagitario" : "Capricornio";
		}

		if (signo != null) {
			ps.println("Su signo zodiacal es: " + signo);
		} else {
			ps.println("Fecha invalida.");
		}    	
    }
    
    public static void calcularApellidoMasLargo(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException {
		ps.print("Ingrese el nombre y apellido de la primer persona: ");
		String nombre1 = br.readLine();
		
		ps.print("Ingrese el nombre y apellido de la segunda persona: ");
		String nombre2 = br.readLine();

		String[] lista1 = nombre1.split(" ");
		String[] lista2 = nombre2.split(" ");

		if (lista1.length < 2 || lista2.length < 2) {
			ps.println("Por favor, ingresá nombre y apellido para ambas personas.");
		} else {
			if (lista1[1].length() > lista2[1].length()) {
				ps.println(nombre1 + " tiene el apellido más largo");
			} else if (lista2[1].length() > lista1[1].length()) {
				ps.println(nombre2 + " tiene el apellido más largo");
			} else {
				ps.println("Ambos apellidos tienen la misma longitud.");
			}
		}
	}
    public static void indicarMultiplos(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		ps.print("Ingrese un número natural: ");
		int num = Integer.parseInt(br.readLine());

		if (num <= 0) {
			ps.println("Por favor, ingresá un número natural (mayor que 0)");
		} else {
			ps.println("Tabla de multiplicar del " + num + ":");
			for (int i = 1; i <= 10; i++) {
				ps.println(num + " x " + i + " = " + (num * i));
			}
		}
	}
    public static void indicarSiEsPrimo(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		ps.print("Ingrese un numero natural: ");
		int num = Integer.parseInt(br.readLine());

		boolean esPrimo = true;

		if (num <= 1) {
			esPrimo = false;
		} else {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					esPrimo = false;
					break;
				}
			}
		}

		if (esPrimo) {
			ps.println("El numero ingresado es primo");
		} else {
			ps.println("El numero ingresado no es primo");
		}
	}
    
}