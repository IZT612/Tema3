package parte2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el generador de numeros aleatorios
		Random rand = new Random();

		// Creamos un array "tabla" con 1000 espacios
		int tabla[] = new int[1000];

		// Creamos una variable entera "numero" donde guardaremos el numero introducido
		// por el usuario
		int numero = 0;

		/*
		 * Creamos una variable entera "cantidad" donde guardaremos la cantidad de veces
		 * que se ha encontrado el número
		 */
		int cantidad = 0;

		/*
		 * Creamos una variable booleana "inputError" donde guardaremos si hay un error
		 * de input, esta es distinta a la siguiente ya que el scanner solo se limpia si
		 * ocurre este error
		 */
		boolean inputError;

		// Creamos una variable booleana "error" donde guardaremos si hay errores al
		// introducir el numero
		boolean error;

		// Creamos un bucle "for" que recorre todo el array "tabla" para introducir
		// valores aleatorios en este
		for (int i = 0; i <= (tabla.length - 1); i++) {

			// Introducimos un valor aleatorio entre 0 y 99 en el espacio correspondiente
			tabla[i] = rand.nextInt(0, 100);

		}

		// Creamos un do-while para pedir el numero
		do {

			// Ponemos ambos errores como false para evitar bucles infinitos
			error = false;
			inputError = false;

			// Hacemos un try catch para manejar los errores que puedan ocurrir
			try {

				// Pedimos el numero
				System.out.println("Introduzca que numero quiere revisar en el array");

				// Lo introducimos en "numeo"
				numero = sc.nextInt();

				// Hacemos un assert que nos dará error si el número no está entre 0 y 99
				assert (numero >= 0 && numero <= 99) : "El número debe estar entre 0 y 99";

				// Si se introduce algo que no sea un número entero atrapamos el error
			} catch (InputMismatchException e) {

				// Informamos al usuario del error que ha sucedido
				System.out.println("Debe introducir un número entero");

				// Ponemos ambos errores como true
				inputError = true;
				error = true;

				// Atrapamos el assert error
			} catch (AssertionError e) {

				// Informamos al usuario del error que ha sucedido
				System.out.println(e.getLocalizedMessage());

				// Ponemos "error" como true
				error = true;

			}

			// Si "inputError" es verdadero
			if (inputError) {

				// Limpiamos el scanner
				sc.next();

			}

		// El bucle se repite siempre que haya error
		} while (error);
		
		Arrays.sort(tabla);

		// Creamos un bucle for que recorrerá toda la tabla
		for (int i = 0; i <= (tabla.length - 1); i++) {

			// Si el número se encuentra en alguna parte de la tabla
			if (tabla[i] == numero) {

				// A "cantidad" le sumamos 1
				cantidad++;

			}

		}

		// Si la cantidad no es 0, significa que se ha encontrado minimo 1 vez
		if (cantidad != 0) {

			// Le mostramos al usuario las veces que se ha encontrado
			System.out.println("El número se encuentra " + cantidad + " veces en la tabla");

		// Si no, no se ha encontrado nada
		} else {

			// Se lo notificamos al usuario
			System.out.println("No se ha encontrado el número " + numero + " en la tabla");

		}

		// Cerramos el scanner
		sc.close();

	}

}
