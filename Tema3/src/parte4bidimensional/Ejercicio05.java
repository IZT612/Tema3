package parte4bidimensional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Creamos un array bidimensional "tabla" para guardar los valores del usuario
		int[][] tabla;

		// Creamos una variable booleana "error" para guardar si hay errores al pedir
		// los datos
		boolean error;

		int filas = 0;

		int columnas = 0;

		int dato = 1;

		int valor = 0;

		int[][] tablaGirada;

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

				// Introducimos el número en "valor"
				valor = sc.nextInt();

				// Forzamos un AssertionError si el valor introducido no es mayor que 0
				assert (valor > 0) : "El valor introducido debe ser mayor que 0";

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

				filas = valor;
				dato++;

				// Si no, vemos si dato equivale a 2 y no hay error. Si es el caso guardamos el
				// valor en "columnas" y aumentamos dato
			} else if (dato == 2 && !error) {

				columnas = valor;
				dato++;

			}

			// Este bucle se repite siempre que haya error o dato sea menor o igual a 2
			// (pueden quedar datos por introducir)
		} while (error || dato <= 2);

		// A tabla le damos las dimensiones que el usuario ha introducido
		tabla = new int[filas][columnas];

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

		// Guardamos en "tablaGirada" el array bidimensional obtenido tras llamar a la
		// función "gira90" dandonde "tabla" de parametro
		tablaGirada = gira90(tabla);

		// Creamos un bucle for para recorrer las filas de la tabla bidimensional
		for (int i = 0; i < tablaGirada.length; i++) {

			// Creamos otro para recorrer las columnas
			for (int j = 0; j < tablaGirada[i].length; j++) {

				// Mostramos el número que corresponde
				System.out.print(tablaGirada[i][j] + "  ");

			}

			// Cambiamos de linea
			System.out.println();

		}

		// Cerramos el scanner
		sc.close();

	}

	// Creamos una funcion "gira90" que recibe un array bidimensional "tabla" y
	// devuelve otro array bidimensional
	static int[][] gira90(int[][] tabla) {

		// Creamos un array bidimensional "tablaGirada" con las dimensiones opuestas a
		// "tabla"
		int[][] tablaGirada = new int[tabla[0].length][tabla.length];

		// Recorremos las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {

			// Recorremos las columnas de "tabla"
			for (int j = 0; j < tabla[0].length; j++) {

				// El número correspondiente de tabla lo guardamos en "tablaGirada" de esta
				// forma: Las filas de "tablaGirada" corresponden a las columnas de "tabla" por
				// lo que basta con guardarlo en la fila j de "tablaGirada". Para las columnas,
				// lo guardamos en la columna opuesta a la fila, es decir, la primera fila de
				// "tabla" se guarda en la útlima columna de "tablaGirada"
				tablaGirada[j][(tabla.length - 1) - i] = tabla[i][j];

			}

		}

		// Devolvemos "tablaGirada"
		return tablaGirada;
	}

}
