package parte4;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos un array "tabla" donde guardaremos los numeros introducidos por el usuario
		int[] tabla;
		
		// Creamos un array "tabla" donde guardaremos las posiciones encontradas mediante la función "buscarTodos"
		int[] posiciones;

		/* Creamos una variable entera "longitud" donde guardaremos la longitud del array "tabla" 
		 * (introducida por el usuario) */
		int longitud;
		
		// Creamos una variable entera "valor" donde guardaremos el valor que el usuario quiere buscar en el array
		int valor;

		// Preguntamos la longitud del array y la introducimos en "longitud"
		System.out.println("Introduzca de cuanta longitud quiere la tabla");
		longitud = sc.nextInt();

		// Le ponemos al array "tabla" esa longitud
		tabla = new int[longitud];
		
		// Creamos un bucle for que recorre toda la tabla
		for (int i = 0; i < tabla.length; i++) {

			// Pedimos que introduzca un número y lo guardamos en la tabla
			System.out.println("Introduzca un número en el array");
			tabla[i] = sc.nextInt();
		
		}
		
		// Preguntamos que valor quiere buscar y lo guardamos en "valor"
		System.out.println("¿Qué valor quiere buscar en el array?");
		valor = sc.nextInt();
		
		// Guardamos la tabla obtenida por la funcion "buscarTodos" dándole "valor" y "tabla" en "posiciones"
		posiciones = buscarTodos(valor, tabla);
		
		// Le mostramos al usuario el array "posiciones"
		System.out.println("El número " + valor + " se encuentra en las siguientes posiciones");
		System.out.println(Arrays.toString(posiciones));

		// Cerramos el scanner
		sc.close();
		
	}
	
	// Creamos la funcion "buscarTodos"
	static int[] buscarTodos(int valor, int[] tabla) {
		
		// Creamos un array "posiciones" sin longitud predeterminada
		int[] posiciones;
		
		/* Creamos una variable entera "posicion" que usaremos para saber en que lugar introducir las posiciones 
		 * de "valor" encontrados en "tabla" en el array "posiciones" */
		int posicion = 0;
		
		/* Creamos una variable entera "longitudPosiciones" donde guardaremos la longitud que tendrá el array 
		 * "posiciones" */
		int longitudPosiciones = 0;
		
		// Creamos un bucle for each que recorrerá toda la tabla guardando los valores en "numero"
		for (int numero : tabla) {
			
			// Si "numero" es igual al valor
			if (numero == valor) {
				
				// Incrementamos la longitud del array "posiciones"
				longitudPosiciones++;
				
			}
			
		}
		
		// Le damos a "posiciones" la longitud guardada en "longitudPosiciones"
		posiciones = new int[longitudPosiciones];
		
		// Creamos un bucle for que recorrerá toda la tabla
		for (int i = 0; i < tabla.length ; i++) {
			
			// Si un número en la posición "i" de "tabla" es igual al valor 
			if (tabla[i] == valor) {
				
				// Introducimos su posición en "posiciones"
				posiciones[posicion] = i;
				
				// Incrementamos la posicion donde guardaremos
				posicion++;
				
			}
			
		}
			
		// Devolvemos el array donde guardamos las posiciones
		return posiciones;
		
	}

}
