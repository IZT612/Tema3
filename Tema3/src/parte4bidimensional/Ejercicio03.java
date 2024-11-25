package parte4bidimensional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Creamos un array bidimensional "tabla" para guardar los valores del usuario
		int[][] tabla;

		// Creamos una variable entera "filas" para guardar cuantas filas tendrá el
		// array del usuario
		int filas = 0;

		// Creamos una variable entera "columnas" para guardar cuantas columnas tendrá
		// el array del usuario
		int columnas = 0;

		// Creamos una variable booleana "error" para guardar si hay errores al pedir
		// los datos
		boolean error;

		/*
		 * Creamos una variable entera "dato" iniciada en 1, esto servirá como
		 * identificador para saber que dato preguntarle al usuario
		 */
		int dato = 1;

		/*
		 * Creamos una variable entera "valor" para guardar los valores introducidos por
		 * el usuario al pedir filas y columnas
		 */
		int valor;

		// Creamos un do-while para pedir los datos de filas y columnas
		do {

			// Reiniciamos "valor"
			valor = 0;

			// Reiniciamos "error" para evitar bucles infinitos
			error = false;

			// Hacemos un try-catch para evitar errores en el codigo
			try {

				// Si "dato" es igual a uno, es decir, es el primer dato que pregutnamos, se
				// trata de las filas
				if (dato == 1) {

					// Pedimos las filas y las guardamos en "valor"
					System.out.println("Introduzca cuantas filas quiere tener en su array bidimensional");
					valor = sc.nextInt();

					// Si no, son las columnas
				} else {

					// Pedimos las columnas y las guardamos en "valor"
					System.out.println("Introduzca cuantas columnas quiere tener en su array bidimensional");
					valor = sc.nextInt();

				}

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

			// Si no hay error y se trata del primer dato son las filas
			if (dato == 1 && !error) {

				// Guardamos el valor en "filas" e incrementamos "dato"
				filas = valor;
				dato++;

				// Si no hay error y se trata del segundo dato son las columnas
			} else if (dato == 2 && !error) {

				// Guardamos el valor en "columnas" e incrementamos "dato"
				columnas = valor;
				dato++;

			}

			// Este bucle se repite siempre que haya error o dato no sea mayor que 2
		} while (error || !(dato > 2));

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

		sc.close();
		
	}
	
	static boolean simetrica(int[][] tabla) {
		
		boolean simetrica = false;
		
		for (int i = 0; i < tabla.length; i++) {
			
			
		}
		
		
		return simetrica;
	}

}
