package parte4unidimensional;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array "tabla" de tamaño 10
		int[] tabla = new int[10];
		
		// Creamos una variable entera "clave" donde guardaremos el valor a buscar
		int clave = 0;
		
		// Creamos un for que recorre toda la tabla
		for (int i = 0 ; i < tabla.length ; i++) {
			
			// Pedimos un número y lo introducimos en la posición del array que corresponda
			System.out.println("Introduzca un número en el array");
			tabla[i] = sc.nextInt();
			
		}
		
		// Preguntamos que valor quiere buscar y lo guardamos en "clave"
		System.out.println("¿Y qué valor quiere buscar?");
		clave = sc.nextInt();
		
		// Comprobamos si el valor que devuelve la funcion "buscarTodos" es menor a 0
		if (buscarTodos(clave, tabla) < 0) {
			
			// Si es el caso, no se ha encontrado ninguna posicion donde esté ese valor
			System.out.println("No se ha encontrado el valor en el array");
			
		// Si no, debe haber posición
		} else {
			
			// Se la mostramos al usuario
			System.out.println("El valor se ha encontrado en la posición " + buscarTodos(clave, tabla) + " del array");
			
		}
		
		// Cerramos el scanner
		sc.close();

	}
	
	// Creamos la funcion "buscarTodos" la cual pedirá un valor entero y un array, estos llamados "clave" y "tabla"
	static int buscarTodos(int clave, int[] tabla) {
		
		// Creamos una variable entera "posicion" donde guardaremos la posicion que se encuentre
		int posicion = -1;
		
		// Creamos una variable entera "contador" que servirá para recorrer el array en un bucle while
		int contador = 0;
		
		/* Creamos un bucle while que se repite mientras la posición sea negativa (tal y como la creamos) y el 
		 * contador sea menor a la longitud del array */
		while (posicion < 0 && contador < tabla.length) {
			
			// Si la clave recibida es igual al valor en alguna posición del array
			if (tabla[contador] == clave) {
				
				// Guardamos la posición
				posicion = contador;
				
			}
			
			// Incrementamos el contador
			contador++;
			
		}
		
		// Devolvemos la posicion
		return posicion;
		
	}

}
