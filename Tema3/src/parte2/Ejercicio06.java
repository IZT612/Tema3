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

		// Creamos un array con tamaño 6 "tabla" donde guardaremos los numeros del usuario
		int tabla[] = new int[6];

		/* Creamos un array con tamaño 6 y valores predeterminados "ganadores" donde guardamos los numeros 
		 * ganadores */
		int ganadores[] = { 6, 14, 22, 35, 36, 37 };

		// Creamos la variable "aciertos" para guardar cuantos numeros ha acertado
		int aciertos = 0;

		// Creamos la variable booleana "seRepite" para guardar si algún número se repite
		boolean seRepite = false;

		// Creamos un bucle for que recorre toda la tabla
		for (int i = 0; i <= (tabla.length - 1); i++) {

			// Introducimos un número en "tabla" aleatorio del 1 al 49
			tabla[i] = rand.nextInt(1, 50);

		}

		// Hacemos un bucle for que se encargará de evitar que los números se repitan, recorriendo toda la tabla
		for (int i = 0; i <= (tabla.length - 1); i++) {

			/* Si se repite comenzamos a revisar la tabla desde 0, pues al asignar un valor nuevo a un número 
			 * que se repite existe la posibilidad de que este se vuelva a repetir */
			if (seRepite) {

				i = 0;

			}

			// Hacemos un bucle do-while que se repetirá siempre que el número se repita
			do {

				// Ponemos "seRepite" como falso
				seRepite = false;

				// Ordenamos la tabla
				Arrays.sort(tabla);

				// Si el valor de la tabla es igual al siguiente entramos al condicional
				if (i != (tabla.length - 1) && tabla[i] == tabla[(i + 1)]) {

					// Le damos un nuevo valor a esa posición
					tabla[i] = rand.nextInt(1, 50);

					// Ponemos "seRepite" como verdadero
					seRepite = true;

				}

			// El do-while se repetirá siempre que un número se repita
			} while (seRepite);

		}

		// Mostramos los números del jugador y los ganadores
		System.out.println("Tus números son: " + Arrays.toString(tabla));
		System.out.println();
		System.out.println("Y los números ganadores son: " + Arrays.toString(ganadores));
		System.out.println();
		
		// Creamos un bucle for para ver si algún número del jugador coincide con los ganadores
		for (int i = 0 ; i <= (tabla.length - 1) ; i++) {
			
			// Si encuentra uno, la posición será 0 o mayor, así que entramos al condicional si es el caso
			if(Arrays.binarySearch(ganadores, tabla[i]) >= 0) {
				
				// Y aumentamos en 1 "aciertos"
				aciertos++;
				
			}
			
		}

		// Le mostramos cuantos números ha acrtado
		System.out.println("Ha acertado " + aciertos + " números");

		// Cerramos el scanner
		sc.close();

	}

}
