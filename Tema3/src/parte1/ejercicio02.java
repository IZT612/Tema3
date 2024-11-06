package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio02 {

	public static void main(String[] args) {

		/* Creamos la variable "numero" donde guardaremos los numeros introducidos por el usuario 
		 * (solo uno a la vez) */
		double numero = 0;

		/* Creamos la variable booleana "error" donde guardaremos si hay error al introducir el dato o 
		 * no */
		boolean error;

		// Creamos la variable "tabla" donde guardaremos todos los numeros que ha introducido el usuario
		double tabla[] = new double[5];

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		/* Creamos un bucle for el cual nos servira para recoger los datos de cada posición e 
		 * introducirlos en la lsita */
		for (int i = 0; i < tabla.length; i++) {

			// Creamos el do-while para que el usuario introduzca datos correctos
			do {

				// Reiniciamos el error para evitar bucles infinitos
				error = false;

				// Hacemos un try para ver si hay algun error a la hora de guardar el número
				try {

					// Pedimos el numero
					System.out.println("Introduzca un número");

					// Lo guardamos en "numero"
					numero = sc.nextDouble();

				// Si se produce un error de input, lo atrapamos y hacemos lo siguiente
				} catch (InputMismatchException e) {

					// Le mostramos al usuario que ha habido un error
					System.out.println("Ha ocurrido un error, vuelva a introducir el número porfavor");
					
					// Ponemos error como true
					error = true;

				}

				/* Hacemos un if donde limpiamos el scanner solo si se ha producido error, ya que si 
				 * no, este se limpiará incluso si el resultado es correcto */
				if (error) {

					// Limpiamos el scanner
					sc.next();

				}

			// Este bucle se repetirá mientras haya un error
			} while (error);

			// Le asignamos a la posición de la tabla correspondiente el número del usuario
			tabla[i] = numero;

		}

		/* Creamos un bucle for-each con una variable "valor" el cual obtendrá todos los valores de 
		 * "tabla" */
		for (double valor : tabla) {

			// Mostramos el valor al usuario
			System.out.println(valor);

		}
		
		// Cerramos el scanner
		sc.close();

	}

}
