package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos la variable "numero" donde guardaremos los numeros introducidos por el usuario (uno a la vez)
		int numero = 0;

		// Creamos la variable booleana "error" donde guardaremos si hay error al introducir el número
		boolean error;

		// Creamos la tabla "tabla" con 8 espacios para almacenar numeros enteros
		int tabla[] = new int[8];

		/* Creamos el for principal para introducir datos con una variable "i" que incrementa hasta la longitud 
		 * de la tabla */
		for (int i = 0; i < tabla.length; i++) {

			// Creamos un do-while para pedir todos los números
			do {

				// Ponemos el error como falso
				error = false;

				// Hacemos un try catch para ver si hay errores al introducir los datos
				try {

					// Le pedimos al usuario un numero
					System.out.println("Introduzca un número");

					// Introducimos el valor en "numero"
					numero = sc.nextInt();

				// Si ha habido un error lo atrapamos 
				} catch (InputMismatchException e) {

					// Y le decimos al usuario que debe introducir un numero entero
					System.out.println("Debe introducir un número entero");

					// Ponemos error como true
					error = true;

				}

				// Si hay error
				if (error) {

					// Limpiamos el scanner
					sc.next();

				}

			// El bucle para pedir datos se reptie siempre que haya error
			} while (error);
			
			// Introducimos el número en la posición de la tabla correspondiente
			tabla[i] = numero;

		}
		
		// Hacemos un for-each para recorrer todo valor en la tabla
		for (int valor : tabla) {
			
			// Si el valor es divisible entre 2
			if (valor % 2 == 0) {
				
				// Es par
				System.out.println(valor + " --> par");
				
			// Si no
			} else {
				
				// Es impar
				System.out.println(valor + " --> impar");
				
			}
			 
		}
		
		// Cerramos el scanner
		sc.close();

	}

}
