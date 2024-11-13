package parte2;

import java.util.Arrays;

public class Ejercicio07 {

	public static void main(String[] args) {

		// Creamos un array "tabla" con tamaño 55 donde guardaremos todos los valores
		// que pide el ejercicio
		int tabla[] = new int[55];

		/*
		 * Creamos la variable entera "ultimaPos" donde guardaremos la última posición
		 * en la que introdujimos un dato
		 */
		int ultimaPos = 0;

		/*
		 * Creamos la variable entera "limitePos" donde guardaremos hasta que posición
		 * del array se tiene que introducir x número
		 */
		int limitePos = 0;

		// Creamos un bucle for el cual irá incrementando los números para introducirlos al array
		for (int num = 1; num <= 10; num++) {

			/* Ponemos el límite de la posicion igual a la ultima posicion para así calcular cuantas veces 
			 * imprimir el número con solo los números, sin ningun algoritmo complejo */
			limitePos = ultimaPos;

			/* Hacemos un for el cual incrementa en 1 el límite de la posicion hasta repetirlo tantas veces 
			 * como el número */
			for (int i = 1; i <= num; i++) {

				limitePos++;

			}

			// Usamos el fill para meter "num" a "tabla" desde "ultimaPos" hasta "limitePos"
			Arrays.fill(tabla, ultimaPos, limitePos, num);

			// Guardamos la última posición como el límite que acabamos de alcanzar
			ultimaPos = limitePos;

		}

		// Mostramos el array "tabla"
		System.out.println(Arrays.toString(tabla));

	}

}
