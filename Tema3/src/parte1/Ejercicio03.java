package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		/* Creamos la variable "numero" donde guardaremos los numeros introducidos por el usuario 
		 * (uno a la vez) */
		int numero = 0;

		// Creamos la variable booleana "error" donde guardaremos si hay error
		boolean error;
		
		/* Creamos la variable "valor" donde guardremos el valor de cada espacio de la tabla para 
		 * mostrarlos mas tarde */
		int valor = 0;

		/* Creamos la variable "tabla" donde guardaremos los numeros introducidos por el usuario a la 
		 * vez, como un array */
		int tabla[] = new int[10];

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		/* Creamos un bucle for el cual nos servira para recoger los datos de cada
		 * posición e introducirlos en la lsita */
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
					numero = sc.nextInt();

					// Si se produce un error de input, lo atrapamos y hacemos lo siguiente
				} catch (InputMismatchException e) {

					// Le mostramos al usuario que ha habido un error
					System.out.println("Ha ocurrido un error, vuelva a introducir el número porfavor");

					// Ponemos error como true
					error = true;

				}

				/* Hacemos un if donde limpiamos el scanner solo si se ha producido error, ya
				 * que si no, este se limpiará incluso si el resultado es correcto */
				if (error) {

					// Limpiamos el scanner
					sc.next();

				}
				
			// Introducimos el numero del usuario en el espacio de la lista correspondiente
			tabla[i] = numero;

			// Este bucle se repetirá mientras haya un error
			} while (error);

		}

		/* Creamos un for con variable "i" en 9, este bucle se repite mientras "i" sea mayor o igual a 
		 * 0, y a "i" se le va reduciendo 1 por cada iteracion */
		for (int i = tabla.length - 1 ; i >= 0; i--) {
			
			// A "valor" le damos el valor de la posición de la tabla correspondiente
			valor = tabla[i];

			// Mostramos la variable "valor"
			System.out.print(valor + " ");

		}
		
		// Cerramos el scanner
		sc.close();

	}

}
