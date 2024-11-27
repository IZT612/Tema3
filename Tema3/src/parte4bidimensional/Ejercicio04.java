package parte4bidimensional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Creamos el array bidimensional "tabla" donde guardaremos la matriz del
		// usuario
		int[][] tabla;

		// Creamos la variable booleana "error" donde guardaremos si hay error al pedir
		// los datos
		boolean error;

		// Creamos la variable booleana "magica" donde guardaremos si es mágica o no
		boolean magica;

		// Creamos la variable entera "dimensiones" donde guardaremos las dimensiones de
		// la matriz
		int dimensiones = 0;

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
		 * Guardamos en "magica" el booleano recibido al llamar a la funcion "esMagica"
		 * dandole como parametro "tabla"
		 */ magica = esMagica(tabla);

		// Si es magica se lo informamos al usuario
		if (magica) {

			System.out.println("La tabla es mágica");

			// Y si no, le informamos al usuario que no lo es
		} else {

			System.out.println("La tabla no es mágica");

		}

		// Cerramos el scanner
		sc.close();

	}

	// Creamos la función "esMagica", la cual devuelve un booleano y requiere un
	// array bidimensional "tabla"
	static boolean esMagica(int[][] tabla) {

		// Creamos una variable booleana "magica", donde guardaremos si "tabla" es
		// magica o no
		boolean magica = true;

		// Creamos una variable entera "filas" que usaremos como contador para recorrer
		// las filas de "tabla"
		int filas = 0;

		// Creamos una variable entera "columnas" que usaremos como contador para
		// recorrer las columnas de "tabla"
		int columnas = 0;

		// Creamos una variable entera "sumaInicial" donde guardaremos la primera suma,
		// la cual debería ser igual a todas las demás si es mágica
		int sumaInicial = 0;

		// Creamos una variable entera "suma" donde iremos guardando las sumas de las
		// filas y columnas de "tabla"
		int suma = 0;

		// Creamos un while para recorrer las filas de "tabla" siempre que sea mágica
		while (filas < tabla.length && magica) {

			// Reiniciamos el valor de "suma"
			suma = 0;

			// Otro para recorrer las columnas siempre que sea mágica
			while (columnas < tabla[filas].length && magica) {

				// Sumamos el valor en "suma"
				suma += tabla[filas][columnas];

				// Incrementamos las columnas
				columnas++;

			}

			// Si "filas" equivale a 0, es la primera suma, asi que guardamos "suma" en
			// "sumaInicial"
			if (filas == 0) {

				sumaInicial = suma;

			}

			// Si "suma" no es igual a "sumaInicial" ponemos "magica" como false
			if (!(suma == sumaInicial)) {

				magica = false;

			}

			// Incrementamos las filas
			filas++;

			// Reiniciamos las columnas
			columnas = 0;

		}

		// Reiniciamos "filas" para evitar errores en el proximo while
		filas = 0;

		// Reiniciamos "columnas" para evitar errores en el proximo while
		columnas = 0;

		// Repetimos los whiles anterior pero esta vez recorriendo primero las columnas
		while (columnas < tabla[filas].length && magica) {

			suma = 0;

			while (filas < tabla.length && magica) {

				suma += tabla[filas][columnas];

				filas++;

			}

			if (!(suma == sumaInicial)) {

				magica = false;

			}

			columnas++;

			filas = 0;

		}

		// Devolvemos magica
		return magica;

	}

}
