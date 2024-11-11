package parte2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el array "tabla"
		int tabla[];

		// Creamos la variable entera "tamaño" donde guardaremos el tamaño del array
		int tamaño = 0;

		// Creamos la variable entera "valor" donde guardaremos el valor de los elementos del array
		int valor = 0;

		// Creamos la variable booleana "error" donde guardaremos si hay error o no al introducir datos
		boolean error;
		
		// Hacemos un do-while para introducir el tamaño
		do {

			// Ponemos "error" como false para evitar bucles infinitos
			error = false;

			// Hacemos un try catch para evitar errores en el codigo
			try {

				// Pedimos el tamaño
				System.out.println("Introduzca de que tamaño quiere el array");
				
				// Lo guardamos en "tamaño"
				tamaño = sc.nextInt();

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
		
		// Creamos un do-while como el anterior para la variable "valor", guardando los valores de cada elemento del array
		do {

			error = false;

			try {

				System.out.println("Introduzca los valores que quiere en cada elemento del array");
				valor = sc.nextInt();

			} catch (InputMismatchException e) {

				System.out.println("Debe introducir un número");
				error = true;

			}

			if (error) {

				sc.next();

			}

		} while (error);

		// Al array "tabla" le damos el tamaño introducido por el usuario
		tabla = new int[tamaño];

		// Y a cada elemento de "tabla" le ponemos el valor introducido por el usuario
		Arrays.fill(tabla, valor);

		// Mostramos el array "tabla" como String
		System.out.println(Arrays.toString(tabla));

		// Cerramos el scanner
		sc.close();

	}

}
