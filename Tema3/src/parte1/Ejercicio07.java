package parte1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		/*
		 * Creamos la variable "temperatura" donde guardaremos las temperaturas
		 * introducidos por el usuario (una a la vez)
		 */
		int temperatura = 0;

		// Creamos una variable booleana "error" para ver si hay errores al introducir
		// datos
		boolean error;

		// Creamos una variable "mes" para guaradar los nombres de los meses
		String mes;

		// Creamos una variable "contadorMes" para saber de que mes estamos mostrando la
		// temperatura
		int contadorMes = 0;

		// Creamos la tabla "temperaturas" para guardar todas las temperaturas
		int temperaturas[] = new int[12];

		/*
		 * Creamos el for principal para introducir datos con una variable "i" que
		 * incrementa hasta la longitud de la tabla
		 */
		for (int i = 0; i < temperaturas.length; i++) {

			// Creamos un do-while para pedir todas las temperaturas
			do {

				// Ponemos el error como falso
				error = false;

				// Hacemos un try catch para ver si hay errores al introducir los datos
				try {

					// Le pedimos al usuario la temperatura del mes correspondiente
					System.out.println("Introduzca la temperatura del mes " + (i + 1));

					// Introducimos el valor en "numero"
					temperatura = sc.nextInt();

					// Si ha habido un error lo atrapamos
				} catch (InputMismatchException e) {

					// Y le decimos al usuario que debe introducir una temperatura válida
					System.out.println("Debe introducir una temperatura válida");

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
			temperaturas[i] = temperatura;

		}

		// Creamos el for each para recorrer la tabla de temperaturas para así
		// mostrarlas
		for (int valor : temperaturas) {

			// Le añadimos 1 a "contadorMes"
			contadorMes++;

			/*
			 * Hacemos un switch donde según el número de "contadorMes", le ponemos el mes
			 * correspondiente en texto
			 */
			mes = switch (contadorMes) {

			case 1 -> {
				yield "Enero      | ";
			}

			case 2 -> {
				yield "Febrero    | ";
			}

			case 3 -> {
				yield "Marzo      | ";
			}

			case 4 -> {
				yield "Abril      | ";
			}

			case 5 -> {
				yield "Mayo       | ";
			}

			case 6 -> {
				yield "Junio      | ";
			}

			case 7 -> {
				yield "Julio      | ";
			}

			case 8 -> {
				yield "Agosto     | ";
			}

			case 9 -> {
				yield "Septiembre | ";
			}

			case 10 -> {
				yield "Octubre    | ";
			}

			case 11 -> {
				yield "Noviembre  | ";
			}

			case 12 -> {
				yield "Diciembre  | ";
			}

			default -> {
				yield "";
			}

			};

			// Mostramos el mes sin cambiar de linea para mostrar la temperatura a continuacion
			System.out.print(mes);

			// Hacemos un for para mostrar la temperatura, añadiendo un asterisco por cada cifra que incrementa
			for (int i = 0; i < valor; i++) {

				// Mostramos el asterisco
				System.out.print("*");

			}

			// Cambiamos de línea
			System.out.println();

		}

		// Cerramos el scanner
		sc.close();

	}

}
