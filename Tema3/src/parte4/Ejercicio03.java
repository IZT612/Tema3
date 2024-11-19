package parte4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio03 {
	
	// Creamos el scanner
	static Scanner sc = new Scanner(System.in);
	
	// Creamos el generador de numeros aleatorios
	static Random rand = new Random();

	public static void main(String[] args) {
		
		/* Creamos la variable "longitud" dandole el valor que nos devuelva la función "verificador" con 
		 * tipo 1 (Forma de identificar que dato es necesario introducir, ya que estos tienen distintas 
		 * condiciones para ser válidas) */
		int longitud = verificador(1);
		
		// Creamos la variable "fin" dandole el valor que nos devuelva la funcion "verificador" con tipo 2
		int fin = verificador(2);
		
		/* creamos el array "tabla" con la tabla que nos devuelva la función "rellenaPares" dándole la 
		 * longitud y el fin */
		int[] tabla = rellenaPares(longitud, fin);
		
		// Mostramos la tabla como String
		System.out.println(Arrays.toString(tabla));
		
		// Cerramos el scanner
		sc.close();
		
	}

	// Creamos una función "verificador" la cual pedirá un número entero "tipo"
	static int verificador (int tipo) {
		
		// Creamos la variable booleana "error" para comprobar si hay errores al introducir los datos
		boolean error;
		
		// Creamos una variable entera "valor" para guardar el valor introducido por el usuario
		int valor = 0;
		
		// Hacemos un do-while para pedir los datos que se repetirá siempre que haya error
		do {
			
			// Ponemos "error" como falso para evitar bucles infinitos
			error = false;
			
			// Hacemos un try catch para capturar posibles errores
			try {
				
				// Si "tipo" es 1, se debe a la longitud
				if (tipo == 1) {
				
					// Pedimos la longitud y la introducimos en "valor"
					System.out.println("Introduzca el valor para la longitud");
					valor = sc.nextInt();
					
					// Creamos un assert para forzar error cuando valor no sea mayor que 0
					assert(valor > 0) : "La longitud debe ser mayor a 0";
				
				// Si "tipo" no es 1, se debe al fin
				} else {
					
					// Pedimos el fin y lo introducimos en "fin"
					System.out.println("Introduzca el valor para el fin");
					valor = sc.nextInt();
					
					// Creamos un assert para forzar error cuando valor no sea mayor que 2
					assert(valor > 2) : "El fin debe ser mayor a 2";
				}
				
			// Capturamos el error cuando se introduce algo que no es un número entero
			} catch (InputMismatchException e) {
				
				// Informamos al usuario
				System.out.println("Debe introducir un número entero");
				
				// Ponemos "error" como true
				error = true;
				
				// Limpiamos el scanner
				sc.next();
				
			// Capturamos el error provocado por el assert
			} catch (AssertionError e) {
				
				// Informamos al usuario
				System.out.println(e.getLocalizedMessage());
				
				// Ponemos "error" como true
				error = true;
				
			}
			
		// Este bucle se repite mientras haya error
		} while (error);
		
		// Devolvemos el valor
		return valor;
		
	}
	
	// Creamos la funcion "rellenaPares" que requiere una longitud y un fin
	static int[] rellenaPares (int longitud, int fin) {
		
		// Creamos un array "tabla" con la longitud recibida
		int[] tabla = new int[longitud];
		
		// Creamos una variable entera "numero" donde guardaremos el número generado aleatoriamente
		int numero = 0;
		
		/* Creamos una variable entera "contador" donde iremos contando cada vez que se introduce un número 
		 * en el array hasta completarlo */
		int contador = 0;
		
		// Creamos un bucle while el cual se repetirá mientras "contador" sea menor a la longitud de la tabla
		while (contador < tabla.length) {
			
			// Guardamos un número aleatorio entre 2 y el fin recibido en "numero"
			numero = rand.nextInt(2, fin);
			
			// Si "numero" es par
			if (numero % 2 == 0) {
				
				// Guardamos el número
				tabla[contador] = numero;
				
				// E incrementamos el contador
				contador++;
			}
			
		}
		
		// Ordenamos la tabla
		Arrays.sort(tabla);
		
		// Devolvemos la tabla creada
		return tabla;
		
	}
	
}

