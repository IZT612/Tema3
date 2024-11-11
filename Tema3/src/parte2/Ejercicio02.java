package parte2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Creamos la variable "valor" donde guardaremos el valor que el usuario quiere introducir
		int valor = 0;

		// Creamos la booleana "error" para guardar si hay errores al introducir datos
		boolean error;

		// Creamos el array "tabla1" con 10 espacios
		int tabla1[] = new int[10];

		// Creamos el array "tabla2" con 10 espacios
		int tabla2[] = new int[10];

		// Creamos un bucle for para ir introduciendo los valores en cada espacio de la tabla
		for (int i = 0; i <= 19; i++) {

			// Hacemos un do-while para pedir los datos
			do {

				// Ponemos "error" como false para evitar bucles infinitos
				error = false;

				// Hacemos un try catch para evitar errores en el codigo
				try {

					// Si "i" (contador) es igual o menor a 9, estamos en el primer array
					if (i <= 9) {

						// Le pedimos al usuario que introduzca un valor para ese array
						System.out.println("Introduzca que valor quiere introducir en el array 1");

					// Si no, estamos en el segundo
					} else {

						// Le pedimos al usuario que introduzca un valor para ese array
						System.out.println("Introduzca que valor quiere introducir en el array 2");

					}

					// Lo guardamos en "valor"
					valor = sc.nextInt();

					// Si no ha introducido un numero entero capturamos el error
				} catch (InputMismatchException e) {

					// Notificamos al usuario
					System.out.println("Debe introducir un número");

					// Ponemos "error" como true
					error = true;

				}

				// Si hay error
				if (error) {

					// Limpiamos el scanner
					sc.next();

				}

				// El bucle se repita mientras haya errores
			} while (error);

			// Si "i" (contador) es igual o menor a 9, estamos en el primer array
			if (i <= 9) {

				// Guardamos el valor en el primer array en la posicion que corresponda
				tabla1[i] = valor;

			// Si no, estamos en el segundo
			} else {

				/* Guardamos el valor en la posicion correspondiente del segundo array (Calculamos la posicion 
				 * simplemente restandole 10 al contador */
				tabla2[(i - 10)] = valor;

			}

		}

		// Convertimos los arrays en texto para poder compararlos, y ver si son iguales
		if (Arrays.toString(tabla1).equals(Arrays.toString(tabla2))) {

			// Si son iguales se lo notificamos al usuario
			System.out.println("Los arrays son iguales");

		// Si no
		} else {

			// Le mostramos al usuario que son distintos
			System.out.println("Los arrays son distintos");

		}
		
		// Mostramos ambos arrays
		System.out.println(Arrays.toString(tabla1));
		System.out.println();
		System.out.println(Arrays.toString(tabla2));

		// Cerramos el scanner
		sc.close();

	}

}
