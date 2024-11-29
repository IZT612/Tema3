package parte5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el generador de numeros aleatorios
		Random rand = new Random();

		// Creamos la var
		int[][] tabla;

		int filas = 0;

		int columnas = 0;

		int dimensiones = 0;

		int valor = 0;

		int dato = 1;

		boolean encontrado;

		boolean error;

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

		tabla = new int[filas][columnas];

		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla[i].length; j++) {

				tabla[i][j] = rand.nextInt(1, 101);

			}

		}

		// Creamos un do-while para pedir los datos de filas y columnas
		do {

			// Reiniciamos "error" para evitar bucles infinitos
			error = false;

			// Hacemos un try-catch para evitar errores en el codigo
			try {

				System.out.println("Introduzca un valor entre 1 y 100 para buscar en la tabla");
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

			// Este bucle se repite siempre que haya error
		} while (error);

		encontrado = buscar(tabla, valor);

		if (encontrado) {

			System.out.println("El número ha sido encontrado");

		} else {

			System.out.println("El número no se ha encontrado");

		}

		sc.close();

	}

	static boolean buscar(int[][] tabla, int valor) {

		boolean encontrado = false;

		for (int i = 0; i < tabla.length && !encontrado; i++) {

			for (int j = 0; j < tabla[i].length && !encontrado; j++) {

				if (tabla[i][j] == valor) {

					encontrado = true;

				}

			}

		}

		return encontrado;

	}
}
