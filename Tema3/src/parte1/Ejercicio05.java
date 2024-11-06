package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Creamos una variable "maximo" para guardar el valor introducido más alto
		int maximo = Integer.MIN_VALUE;

		// Creamos una variable "minimo" para guardar el valor introducido más bajo
		int minimo = Integer.MAX_VALUE;

		// Creamos una variable "numero" para guardar los números introducidos por el usuario (solo uno a la vez)
		int numero = 0;
		
		// Creamos una variable "suma" para guardar la suma de todos los números
		int suma = 0;

		// Creamos una variable booleana "error" para guardar si hay error al introducir los datos
		boolean error;

		// Creamos un array int "tabla" para guardar 10 números
		int tabla[] = new int[10];

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos un bucle for el cual sirve para ir introduciendo datos en el array hasta completarlo
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

					// Limpiamos el scanners
					sc.next();

				}

				// El bucle se repite mientras haya un error
			} while (error);
			
			// Al espacio correspondiente de la tabla le introducimos el número
			tabla[i] = numero;
			
			// A la suma le vamos añadiendo los valores guardados
			suma += tabla[i];
			
			// Si el número es mayor al máximo guardado, entramos al condicional
			if (numero > maximo) {
				
				// Y guardamos el nuevo máximo como ese numero
				maximo = numero;
				
			}
			
			// Si el número es menor al mínimo guardado, entramos al condicional
			if (numero < minimo) {
				
				// Y guardamos el nuevo mínimo con ese número
				minimo = numero;
				
			}

		}

		// Mostramos al usuario el número máximo
		System.out.println("El número máximo: " + maximo);
		
		// Mostramos al usuario el número mínimo
		System.out.println("El número mínimo: " + minimo);
		
		// Mostramos al usuario la suma de los números
		System.out.println("La suma de los números es: " + suma);
		
		// Cerramos el scanner
		sc.close();

	}

}
