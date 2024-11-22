package parte4bidimensional;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Creamos el generador de números aleatorios
		Random rand = new Random();
		
		/* Creamos un array bidimensional "tabla" con 6 filas y 10 columnas donde guardaremos los numeros aleatorios */
		int[][] tabla = new int[6][10];
		
		/* Creamos un array unidimensional "minMax" donde guardaremos el array creado con la funcion "minMaxF" que mostrará el valor máximo y mínimo de "tabla" */
		int[] minMax;
		
		// Creamos un bucle for que recorre las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {
			
			// Creamos un bucle for que recorre las columnas de "tabla"
			for (int j = 0; j < tabla[i].length; j++) {
				
				// Introducimos un número entre 0 y 1000 en "tabla"
				tabla[i][j] = rand.nextInt(0, 1001);
				
			}
			
		}
		
		/* Al array "minMax" le asignamos los mismos valores que el array unidimensional devuelto por "minMaxF" 
		 * dado el array bidimensional "tabla" */
		minMax = minMaxF(tabla);
		
		// Mostramos el array
		System.out.println(Arrays.toString(minMax));

	}

	/* Creamos una función "minMaxF" que devuelve un array unidimensional y requiere de un array bidimensional 
	 * que llamaremos "tabla" */
	static int[] minMaxF(int[][] tabla) {
		
		// Creamos un array unidimensional "minMax" con tamaño 2 donde guardaremos el mínimo y máximo
		int[] minMax = new int[2];
		
		/* Creamos las variables enteras "min" y "max" donde guardaremos los valores mínimos y máximos 
		 * respectivamente */
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// Creamos un bucle for que recorre las filas de "tabla"
		for (int i = 0; i < tabla.length; i++) {
			
			// Creamos un bucle for-each que recorre las columnas de "tabla" según la fila y lo guarda en "valor"
			for (int valor : tabla[i]) {
	
				// Si el valor es más grande que el máximo
				if (valor > max) {
					
					// Guardamos "valor" en "max"
					max = valor;
					
				}
				
				// Si elvalor es más pequeño que el mínimo
				if (valor < min) {
					
					// Guardamos "valor" en "min"
					min = valor;
					
				}
				
			}
			
		}
		
		// Guardamos el mínimo y máximo en el array "minMax" respectivamente
		minMax[0] = min;
		minMax[1] = max;
		
		// Devolvemos el array "minMax"
		return minMax;
		
	}

}
