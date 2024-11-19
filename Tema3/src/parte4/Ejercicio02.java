package parte4;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array "tabla" donde guardaremos los numeros introducidos por el usuario
		int[] tabla;
		
		// Creamos la variable entera "longitud" donde guardaremos de que longitud se quiere el array
		int longitud;
		
		// Creamos la variable entera "numero" donde guardaremos los numeros del usuario (individualmente)
		int numero;
		
		// Pedimos la longitud del array y la guardamos en "longitud"
		System.out.println("¿De qué longitud quiere el array?");
		longitud = sc.nextInt();
		
		// Ponemos el array "tabla" a esa longitud guardada en "longitud"
		tabla = new int[longitud];
		
		// Creamos un for que recorre toda la tabla
		for (int i = 0; i < tabla.length; i++) {
			
			// Pedimos un número y lo guardamos en "numero"
			System.out.println("Introduzca un número");
			numero = sc.nextInt();
			
			// Guardamos el numero en la posicion correspondiente
			tabla[i] = numero;
			
		}
		
		// Mostramos el número máximo el cual calculamos mediante la función "maximo" dandole "tabla" como dato
		System.out.println("El máximo es: " + maximo(tabla));
		
		// Cerramos el scanner
		sc.close();

	}
	
	// Creamos la funcion "maximo" la cual devolverá un entero y necesitará un array unidimensional
	static int maximo(int [] tabla) {
		
		// Creamos la variable entera "maximo" donde guardaremos el numero más alto
		int maximo = Integer.MIN_VALUE;
		
		// Creamos un for-each para recorrer la tabla guardando los valores en una variable entera "valor"
		for (int valor : tabla) {
			
			// Si el valor es mayor al actual máximo
			if (valor > maximo) {
				
				// Guardamos el nuevo máximo como el valor
				maximo = valor;
				
			}
			
		}
		
		// Devolvemos el máximo una vez terminado
		return maximo;
		
	}

}
