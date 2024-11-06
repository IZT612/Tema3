package parte1;

import java.util.Random;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Creamos la variable "tabla" como array con 10 espacios, donde guardaremos los numeros aleatorios
		int tabla[] = new int[10];
		
		// Creamos la variable "numero" donde guardaremos los numeros generados aleatoriamente
		int numero;
		
		// Creamos el generador de numeros aleatorios
		Random rand = new Random();
		
		/* Creamos un for con una variable "i", la cual servira para recorrer cada espacio de "tabla", 
		 * este bucle se repetirá mientras que la "i" sea menor a la longitud de la tabla, y a "i" 
		 * le iremos incrementando 1 */
		for (int i = 0 ; i < tabla.length ; i++) {
			
			// Le ponemos a "numero" un valor aleatorio del 1 al 100
			numero = rand.nextInt(1, 101);
			
			// Al espacio de la tabla correspondiente le ponemos el valor de "numero" (aleatorio)
			tabla[i] = numero;
			
			// Mostramos el número al usuario
			System.out.print(tabla[i] + " ");
			
		}
		
		

	}

}
