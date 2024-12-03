package parte5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio03 {

	// Creamos el generador de números aleatorios
	static Random rand = new Random();

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos la variable booleana "error" para evitar errores al pedir los datos
		boolean error;

		// Creamos la variable entera "dato" para poder distinguir entre filas y
		// columnas al pedir los datos, hacemos esto para poder pedirlo todo en un mismo
		// do while sin necesidad de crear uno para filas y otro para columnas
		int dato = 1;

		// Creamos la variable entera "dimensiones" donde guardaremos las dimensiones a
		// guardar en "filas" o "columnas"
		int dimensiones = 0;

		// Creamos la variable entera "filas" para guardar cuantas filas quiere el
		// usuario en su array
		int filas = 0;

		// Creamos la variable entera "columnas" para guardar cuantas columnas quiere el
		// usuario en su array
		int columnas = 0;

		// Creamos la variable entera "numero" para guardar el numero que el usuario
		// quiere introducir en su array
		int numero = 0;

		// Creamos el array bidimensional "tabla" para guardar todos los numeros y posteriormente desordenarla
		int[][] tabla;

		// Creamos un do-while para pedir los datos de filas y columnas
		do {

			// Reiniciamos "error" para evitar bucles infinitos
			error = false;

			// Hacemos un try-catch para evitar errores en el codigo
			try {

				// Si el "dato" equivale a 1 se trata de las filas
				if (dato == 1) {

					// Pedimos las filas
					System.out.println("Introduzca cuantas filas quiere tener en su array bidimensional");

					// Si no, se trata de las columnas
				} else {

					// Pedimos las columnas
					System.out.println("Introduzca cuantas columnas quiere tener en su array bidimensional");

				}

				// Introducimos el número en "dimensiones"
				dimensiones = sc.nextInt();

				// Forzamos un AssertionError si el valor introducido no es mayor que 0
				assert (dimensiones > 0) : "El valor introducido debe ser mayor que 0";

				// Si no se ha introducido un numero entero atrapamos el error
			} catch (InputMismatchException e) {

				// Informamos al usuario, ponemos "error" como true y limpiamos el scanner
				System.out.println("El valor introducido debe ser un número entero");
				error = true;
				sc.next();

				// Si el valor no es mayor que 0 atrapamos el error
			} catch (AssertionError e) {

				// Informamos al usuario y ponemos "error" como true
				System.out.println(e.getLocalizedMessage());
				error = true;

			}

			// Si dato equivale a uno y no hay error guardamos el valor en "filas" y
			// aumentamos "dato"
			if (dato == 1 && !error) {

				filas = dimensiones;
				dato++;

				// Si no, vemos si dato equivale a 2 y no hay error. Si es el caso guardamos el
				// valor en "columnas" y aumentamos dato
			} else if (dato == 2 && !error) {

				columnas = dimensiones;
				dato++;

			}

			// Este bucle se repite siempre que haya error o dato sea menor o igual a 2
			// (pueden quedar datos por introducir)
		} while (error || dato <= 2);

		// A tabla les damos las dimensiones dadas por el usuario
		tabla = new int[filas][columnas];

		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla[i].length; j++) {

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

				// Guardamos el numero en "tabla"
				tabla[i][j] = numero;

			}

		}
		
		System.out.println("Su tabla inicial:");

		// Recorremos "tabla"
		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla[i].length; j++) {

				// Mostramos la tabla inicial
				System.out.print(tabla[i][j] + " ");

			}

			// Cambiamos de linea con un espacio
			System.out.println();

		}
		
		System.out.println();

		// Llamamos a la funcion para desordenar la tabla
		desordenar(tabla);

		System.out.println("Su tabla desordenada:");
		
		// Recorremos de nuevo "tabla"
		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla[i].length; j++) {

				// Mostramos el numero
				System.out.print(tabla[i][j] + " ");

			}

			// Cambiamos de linea con un espacio
			System.out.println();

		}

		// Cerramos el scanner
		sc.close();

	}

	// Creamos una función "desordenar" que solo requiere un array bidimensional
	// "tabla", no devuelve nada
	static void desordenar(int[][] tabla) {

		// Creamos un array "posicion" para guardar las posicion generadas
		// aleatoriamente
		int[] posicion = new int[2];

		// Creamos un array bidimensional "tablaCopia" donde guardaremos los mismos
		// valores que en
		// "tabla"
		int[][] tablaCopia = new int[tabla.length][tabla[0].length];

		// Creamos la variable entera "valor" donde guardaremos el valor a cambiar de
		// lugar
		int valor = 0;

		// Creamos una variable booleana "repetir" para guardar si se debe repetir o no
		boolean repetir;

		// Creamos un array "tablaPosiciones" donde guardaremos las posiciones ocupadas
		int[][] tablaPosiciones = new int[tabla.length][tabla[0].length];

		// Recorremos "tablaCopia"
		for (int i = 0; i < tablaCopia.length; i++) {

			for (int j = 0; j < tablaCopia[i].length; j++) {

				// Guardamos el valor en "tablaCopia", se hace de esta forma ya que al igualar
				// ambas solo copia la dirección de memoria, lo que causa errores
				tablaCopia[i][j] = tabla[i][j];

			}

		}

		// Recorremos "tabla"
		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla[i].length; j++) {

				// Hacemos un do-while para generar posiciones aleatorias hasta que una esté
				// disponible
				do {

					// Ponemos "repetir" como false
					repetir = false;

					// A "posicion" le damos valores aleatorios entre las posibles posiciones de
					// "tabla"
					posicion[0] = rand.nextInt(0, tabla.length);
					posicion[1] = rand.nextInt(0, tabla[0].length);

					// Si esa posición tiene un 1 en "tablaPosiciones" significa que está ocupado
					if (tablaPosiciones[posicion[0]][posicion[1]] == 1) {

						// Ponemos "repetir" como true
						repetir = true;

						// Si no, está libre
					} else {

						// Marcamos esa posición en "tablaPosiciones"
						tablaPosiciones[posicion[0]][posicion[1]] = 1;

					}

					// Se repite mientras "repetir" sea true
				} while (repetir);

				// Guardamos el valor en "valor" agarrandolo de una tabla que no modificaremos,
				// es decir, "tablaCopia"
				valor = tablaCopia[i][j];

				// Guardamos el valor en la posicion generada en "tabla"
				tabla[posicion[0]][posicion[1]] = valor;

			}

		}

	}

}
