package parte4unidimensional;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array "tabla" donde guardaremos los numeros introducidos por el usuario
		int[] tabla;
		
		// Creamos la variable entera "longitud" donde guardaremos la longitud del array
		int longitud;
		
		// Creamos la variable "numero" donde guardaremos los numeros introducdios por el usuario (individualmente)
		int numero;
		
		// Pedimos la longitud y la guardamos en "longitud"
		System.out.println("De cuanta longitud quiere el array?");
		longitud = sc.nextInt();
		
		// Ponemos el array de esa longitud
		tabla = new int[longitud];
		
		// Creamos un bucle que recorrerá el array 
		for (int i = 0 ; i < tabla.length ; i++) {
			
			// Pedimos que introduzca un numero y lo guardamos en "numero"
			System.out.println("Introduzca un número en el array");
			numero = sc.nextInt();
			
			// Guardamos el numero en la posicion de la tabla correspondiente
			tabla[i] = numero;
			
		}
		
		// Mostramos el valor recibido tras llamar a la funcion "suma"
		System.out.println(suma(tabla));

	}
	
	// Creamos la funcion "suma" que recibirá un array unidimensional
	static int suma(int[] tabla) {
		
		// Creamos una variable entera "sumaTotal" para guardar la suma total de los numeros
		int sumaTotal = 0;
		
		// Creamos un bucle que recorre el array
		for (int i = 0 ; i < tabla.length ; i++) {
			
			// Vamos sumando los números en "sumaTotal"
			sumaTotal += tabla[i];
			
		}
		
		// Devolvemos el valor de "sumaTotal"
		return sumaTotal;
	}

}
