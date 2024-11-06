package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		int maximo = Integer.MIN_VALUE;

		int minimo = Integer.MAX_VALUE;

		int numero = 0;
		
		int suma = 0;

		boolean error;

		int tabla[] = new int[10];

		Scanner sc = new Scanner(System.in);

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

				/*
				 * Hacemos un if donde limpiamos el scanner solo si se ha producido error, ya
				 * que si no, este se limpiará incluso si el resultado es correcto
				 */
				if (error) {

					// Limpiamos el scanners
					sc.next();

				}

				// El bucle se repite mientras haya un error
			} while (error);
			
			tabla[i] = numero;
			
			if (numero > maximo) {
				
				maximo = numero;
				
			}
			
			if (numero < minimo) {
				
				minimo = numero;
				
			}

		}
		
		for (int valor : tabla) {
			
			suma += valor;
			
		}
		
		System.out.println("El número máximo: " + maximo);
		System.out.println("El número mínimo: " + minimo);
		System.out.println("La suma de los números es: " + suma);
		
		sc.close();

	}

}
