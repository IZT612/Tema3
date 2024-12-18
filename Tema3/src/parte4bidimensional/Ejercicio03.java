package parte4bidimensional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Creamos un array bidimensional "tabla" para guardar los valores del usuario
		int[][] tabla;

		// Creamos una variable entera "dimensiones" para guardar cuantas filas y
		// columnas tendrá el
		// array del usuario
		int dimensiones = 0;

		// Creamos una variable booleana "error" para guardar si hay errores al pedir
		// los datos
		boolean error;

		// Creamos una variable booleana "simetrica" para guardar si es simetrica
		boolean simetrica;

		// Creamos un do-while para pedir los datos de filas y columnas
		do {

			// Reiniciamos "error" para evitar bucles infinitos
			error = false;

			// Hacemos un try-catch para evitar errores en el codigo
			try {

				// Pedimos las dimensiones y las guardamos en "dimensiones"
				System.out.println("Introduzca cuantas filas y columnas quiere tener en su array bidimensional");
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

			// Este bucle se repite siempre que haya error
		} while (error);

		// A tabla le damos las dimensiones que el usuario ha introducido
		tabla = new int[dimensiones][dimensiones];

		// Creamos un for que recorre las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {

			// Y otro para recorrer las columnas
			for (int j = 0; j < tabla[i].length; j++) {

				// Hacemos un do-while para volver a pedir el valor sin cambiar la posición en
				// caso de error
				do {

					// Reiniciamos "error"
					error = false;

					// Hacemos un try catch
					try {

						// Pedimos un valor y lo guardamos en la posicion correspondiente
						System.out.println("Introduzca un valor para el array, estamos en la fila " + (i + 1)
								+ " y columna " + (j + 1));
						tabla[i][j] = sc.nextInt();

						// Si no se ha introducido un numero entero atrapamos el error
					} catch (InputMismatchException e) {

						// Informamos al usuario, ponemos "error" como true y limpiamos el scanner
						System.out.println("El número introducido debe ser mayor que 0");
						error = true;
						sc.next();

					}

					// Este solo se repetirá mientras haya error
				} while (error);

			}

		}

		/*
		 * Guardamos el valor el resultado obtenido al llamar la funcion "esSimetrica"
		 * dandole "tabla" como parámetro en "simetrica"
		 */
		simetrica = esSimetrica(tabla);

		// Si es simétrica, mostramos al usuario que la matriz es simétrica
		if (simetrica) {

			System.out.println("La tabla bidimensional es simétrica");

			// Si no, le mostramos que es asimétrica
		} else {

			System.out.println("La tabla bidimensional es asimétrica");

		}

		// Cerramos el scanner
		sc.close();

	}

	/*
	 * Creamos una funcion "esSimetrica" que devuelve un booleano, y requiere un
	 * array bidimensional llamado "tabla"
	 */
	static boolean esSimetrica(int[][] tabla) {

		// Creamos una variable booleana "simetrica" donde guardamos si es simetrica o
		// no
		boolean simetrica = true;

		// Creamos una variable entera "filas" que usaremos como contador para recorrer
		// las filas de "tabla"
		int filas = 0;

		/*
		 * Creamos una variable entera "columnas" que usaremos como contador para
		 * recorrer las columnas de "tabla"
		 */
		int columnas = 0;

		// Creamos un bucle "while" que recorre las filas de "tabla" mientras sea
		// simétrica
		while (filas < tabla.length && simetrica) {

			// Creamos un bucle "while" que recorre las columnas de "tabla" mientras sea
			// simétrica
			while (columnas < tabla[filas].length && simetrica) {

				// Vamos comprobando cada valor, buscando si NO es simetrica
				if (!(tabla[filas][columnas] == tabla[columnas][filas])) {

					// Si es el paso ponemos "simetrica" como false
					simetrica = false;

				}

				// Incrementamos "columnas"
				columnas++;

			}

			// Incrementamos "filas"
			filas++;

		}

		// Devolvemos "simetrica"
		return simetrica;
	}

}
