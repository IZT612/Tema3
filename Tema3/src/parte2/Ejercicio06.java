package parte2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el generador de numeros aleatorios
		Random rand = new Random();

		// Creamos un array con tamaño 6 "tabla" donde guardaremos los numeros del
		// usuario
		int tabla[] = new int[6];

		/*
		 * Creamos un array con tamaño 6 y valores predeterminados "ganadores" donde
		 * guardamos los numeros ganadores
		 */
		int ganadores[] = { 6, 14, 22, 35, 36, 37 };

		// Creamos la variable "aciertos" para guardar cuantos numeros ha acertado
		int aciertos = 0;

		// Creamos una variable "contador" para introducir datos sin repetirse
		int contador = 0;

		// Creamos una variable "busqueda" para guardar la posicion del numero que busquemos
		int busqueda;

		// Creamos una variable "numero" donde guardaremos el numero generado aleatoriamente
		int numero;

		// Creamos un while que se repetira mientras el contador sea menor a 6
		while (contador < 6) {

			// Le ponemos un valor aleatorio entre 1  y 49 a "numero"
			numero = rand.nextInt(1, 50);

			// Ordenamos la tabla
			Arrays.sort(tabla);

			// Comprobamos si el numero se repite
			busqueda = Arrays.binarySearch(tabla, numero);

			// Si no se repite entramos al condicional
			if (busqueda < 0) {

				// Guardamos el número en la tabla
				tabla[0] = numero;
				
				// Incrementamos el contador
				contador++;

			}

		}

		// Mostramos los números del jugador y los ganadores
		System.out.println("Tus números son: " + Arrays.toString(tabla));
		System.out.println();
		System.out.println("Y los números ganadores son: " + Arrays.toString(ganadores));
		System.out.println();

		// Hacemos un for-each recorriendo toda la tabla
		for (int valor : tabla) {

			// Buscamos si el valor está en la tabla de ganadores
			busqueda = Arrays.binarySearch(ganadores, valor);
			
			// Si está entramos al condicional
			if (busqueda >= 0) {

				// Incrementamos en 1 el contador
				contador++;

			}

		}

		// Le mostramos cuantos números ha acrtado
		System.out.println("Ha acertado " + aciertos + " números");

		// Cerramos el scanner
		sc.close();

	}

}
