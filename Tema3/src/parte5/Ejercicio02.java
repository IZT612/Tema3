package parte5;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio02 {

	// Creamos el generador de numeros aleatorios
	static Random rand = new Random();

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el array "tabla" donde guardaremos la tabla del usuario
		int[] tabla;

		// Creamos la variable entera "tamaño" donde guardamos el tamaño del array
		int tamaño = 0;

		// Creamos la variable booleana "error" donde guardaremos si hay error al pedir
		// datos
		boolean error;

		// Creamos la variable entera "numero" donde guardaremos el número que el
		// usuario quiera introducir al array
		int numero = 0;

		// Creamos un do-while para pedir los datos
		do {

			// Ponemos "error" como false
			error = false;

			// Hacemos un try catch para controlar los errores
			try {

				// Pedimos el tamaño y lo guardamos
				System.out.println("Introduzca de cuanto tamaño quiere su array");
				tamaño = sc.nextInt();

				// Es correcto siempre que el array sea de tamaño mayor a 0
				assert (tamaño > 0) : "El array debe tener un tamaño mayor a 0";

				// Capturamos el error si no se ha introducido un número entero
			} catch (InputMismatchException e) {

				// Informamos al usuario, ponemos "error" como true y limpiamos el scanner
				System.out.println("Debe introducir un número entero");
				error = true;

				sc.next();

				// Capturamos el error si no es mayor a 0
			} catch (AssertionError e) {

				// Informamos al usuario y ponemos "error" como true
				System.out.println(e.getLocalizedMessage());
				error = true;

			}

			// El bucle se repite mientras haya error
		} while (error);

		// A "tabla" le damos el tamaño introducido
		tabla = new int[tamaño];

		// Recorremos las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {

			// Hacemos un do while para pedir los números
			do {

				// Ponemos "error" como false
				error = false;

				// Hacemos try catch para controlar errores
				try {

					// Pedimos el numero y lo guardamos en "numero"
					System.out.println("Introduzca un número para el array");
					numero = sc.nextInt();

					// Capturamos el error si no se ha introducido un numero entero
				} catch (InputMismatchException e) {

					// Informamos al usuario, ponemos "error" como true y limpiamos el scanner
					System.out.println("Debe introducir un número entero");
					error = true;
					sc.next();

				}

				// Se repite mientras haya error
			} while (error);

			// Guardamos el número en "tabla"
			tabla[i] = numero;

		}
		
		// Le mostramos al usuario su tabla inicial
		System.out.println("Su tabla inicial: ");
		System.out.println(Arrays.toString(tabla));
		System.out.println();

		// Llamamos a la función que desordena la tabla
		desordenar(tabla);
		
		// Le mostramos al usuario su tabla desordenada
		System.out.println("Su tabla desordenada: ");
		System.out.println(Arrays.toString(tabla));

		// Cerramos el scanner
		sc.close();

	}

	// Creamos una función "desordenar" que solo requiere un array unidimensional
	// "tabla", no devuelve nada
	static void desordenar(int[] tabla) {

		// Creamos una variable entera "posicion" para guardar la posicion generada
		// aleatoriamente
		int posicion = 0;

		// Creamos un array "tablaCopia" donde guardaremos los mismos valores que en
		// "tabla"
		int[] tablaCopia = new int[tabla.length];

		// Creamos la variable entera "valor" donde guardaremos el valor a cambiar de
		// lugar
		int valor = 0;

		// Creamos una variable booleana "repetir" para guardar si se debe repetir o no
		boolean repetir;

		// Creamos un array "tablaPosiciones" donde guardaremos las posiciones ocupadas
		int[] tablaPosiciones = new int[tabla.length];

		// Recorremos "tablaCopia"
		for (int i = 0; i < tablaCopia.length; i++) {

			// Guardamos el valor en "tablaCopia", se hace de esta forma ya que al igualar
			// ambas solo copia la dirección de memoria, lo que causa errores
			tablaCopia[i] = tabla[i];

		}

		// Recorremos "tabla"
		for (int i = 0; i < tabla.length; i++) {

			// Hacemos un do-while para generar posiciones aleatorias hasta que una esté
			// disponible
			do {

				// Ponemos "repetir" como false
				repetir = false;
				
				// A "posicion" le damos un valor aleatorio entre 0 y la longitud de "tabla"
				posicion = rand.nextInt(0, tabla.length);

				// Si esa posición tiene un 1 en "tablaPosiciones" significa que está ocupado
				if (tablaPosiciones[posicion] == 1) {

					// Ponemos "repetir" como true
					repetir = true;

					// Si no, está libre
				} else {

					// Marcamos esa posición en "tablaPosiciones"
					tablaPosiciones[posicion] = 1;

				}

				// Se repite mientras "repetir" sea true
			} while (repetir);

			// Guardamos el valor en "valor" agarrandolo de una tabla que no modificaremos, es decir, "tablaCopia"
			valor = tablaCopia[i];

			// Guardamos el valor en la posicion generada en "tabla"
			tabla[posicion] = valor;

		}

	}

}
