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

		// Creamos el array bidimensional "tabla" donde guardaremos los números
		int[][] tabla;

		// Creamos la variable entera "filas" para guardar las filas de la tabla
		int filas = 0;

		// Creamos la variable entera "columnas" para guardar las columnas de la tabla
		int columnas = 0;

		// Creamos la variable entera "dimensiones" para guardar los datos para las
		// dimensiones de la tabla sin saber aún si son filas o columnas
		int dimensiones = 0;

		// Creamos la variable entera "valor" para guardar el número a buscar
		int valor = 0;

		// Creamos la variable entera "dato" para guardar que dato pedimos
		int dato = 1;

		// Creamos la variable booleana "encontrado" para guardar si encontramos el
		// número en la tabla
		boolean encontrado;

		// Creamos la variable booleana "error" para guardar errores al pedir datos
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

		// Recorremos las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {

			// Recorremos las columnas de "tabla"
			for (int j = 0; j < tabla[i].length; j++) {

				// Introducimos un número aleatorio entre 1 y 100
				tabla[i][j] = rand.nextInt(1, 101);

			}

		}

		// Creamos un do-while para pedir el valor a buscar
		do {

			// Reiniciamos "error" para evitar bucles infinitos
			error = false;

			// Hacemos un try-catch para evitar errores en el codigo
			try {

				// Pedimos el valor a buscar y lo guardamos en "valor"
				System.out.println("Introduzca un valor entre 1 y 100 para buscar en la tabla");
				valor = sc.nextInt();

				// Forzamos un AssertionError si el valor introducido no es mayor que 0 o mayor que 100
				assert (valor >= 1 && valor <= 100) : "El valor introducido debe ser mayor que 0 y menor que 100";

				// Si no se ha introducido un numero entero atrapamos el error
			} catch (InputMismatchException e) {

				// Informamos al usuario, ponemos "error" como true y limpiamos el scanner
				System.out.println("El valor introducido debe ser un número entero");
				error = true;
				sc.next();

				// Si el valor no coincide con los posibles numeros generados atrapamos el error
			} catch (AssertionError e) {

				// Informamos al usuario y ponemos "error" como true
				System.out.println(e.getLocalizedMessage());
				error = true;

			}

			// Este bucle se repite siempre que haya error
		} while (error);

		// Llamamos a la función "buscar" dándole "tabla" y "valor" y guardamos el
		// boolean que devuelve en "encontrado"
		encontrado = buscar(tabla, valor);

		// Si se ha encontrado, informamos al usuario que se ha encontrado
		if (encontrado) {

			System.out.println("El número ha sido encontrado");

			// Si no, le informamos que no se ha encontrado
		} else {

			System.out.println("El número no se ha encontrado");

		}

		// Cerramos el scanner
		sc.close();

	}

	// Creamos la función "buscar" a la que le damos un array bidimensional "tabla"
	// y un entero "valor", y devuelve un booleano
	static boolean buscar(int[][] tabla, int valor) {

		// Creamos otra variable booleana "encontrado" para la funcion que inicializamos
		// en false
		boolean encontrado = false;

		// Recorremos las filas de "tabla"
		for (int i = 0; i < tabla.length && !encontrado; i++) {

			// Recorremos las columnas de "tabla"
			for (int j = 0; j < tabla[i].length && !encontrado; j++) {

				// Si se encuentra el valor, ponemos "encontrado" como true
				if (tabla[i][j] == valor) {

					encontrado = true;

				}

			}

		}

		// Devolvemos "encontrado"
		return encontrado;

	}
}
