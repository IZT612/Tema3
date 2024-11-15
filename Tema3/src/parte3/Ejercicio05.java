package parte3;

import java.util.Random;

public class Ejercicio05 {

	public static void main(String[] args) {
		
		// Creamos el generador de numeros aleatorios 
		Random rand = new Random();
		
		// Declaramos el array bidimensional "tabla" donde guardaremos todos los números aleatorios
		int tabla[][] = new int[4][5];
		
		// Declaramos la variable entera "sumaFila" donde guardaremos la suma de cada fila individualmente
		int sumaFila;
		
		// Declaramos la variable entera "sumaTotal" donde guardaremos la suma de todos los números de la tabla
		int sumaTotal = 0;
		
		// Declaramos la variable entera "sumaColumna" donde guardaremos la suma de cada columna individualmente
		int sumaColumna = 0;
		
		/* Creamos un bucle for que recorrerá todas las filas del array "tabla" (Este bucle será para escribir valores en 
		 * el array) */
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			// También recorremos cada columna
			for (int columna = 0 ; columna < 5 ; columna++) {
				
				// Le ponemos a cada posición un valor aleatorio entre 100 y 999
				tabla[fila][columna] = rand.nextInt(100, 1000);
				
			}
			
			
		}
		
		/* Creamos un bucle for que recorrerá todas las filas del array "tabla" (Este bucle mostrará el array en forma de 
		 * tabla y guardará y mostrará los valores de los sumatorios de cada fila) */
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			// Reiniciamos el valor de "sumaFila" al comenzar una nueva fila
			sumaFila = 0;
			
			// Creamos un bucle for para recorrer todas las columnas 
			for (int columna = 0 ; columna < 5 ; columna++) {
				
				// Mostramos el valor que se encuentra ahí
				System.out.print(tabla[fila][columna] + "              ");
				
				// Sumamos el valor en "sumaFila" y "sumaTotal"
				sumaFila += tabla[fila][columna];
				sumaTotal += tabla[fila][columna];
				
			}
			
			// Mostramos el sumatorio de la fila antes de comenzar una nueva fila
			System.out.println("Σ" + (fila + 1) + ": " + sumaFila);
			
		}
		
		/* Creamos un bucle for que recorrerá todas las columnas del array "tabla" (Este bucle será para poder calcular y 
		 * mostrar los sumatorios de cada columna del array) */
		for (int columna = 0 ; columna < 5 ; columna++) {
			
			// Reiniciamos "sumaColumna" al comenzar una nueva columna
			sumaColumna = 0;
		
			
			// Creamos un bucle for que recorrerá las filas del array
			for (int fila = 0 ; fila < tabla.length ; fila++) {
				
				// Sumamos el valor en "sumaColumna"
				sumaColumna += tabla[fila][columna];
				
			}
			
			// Mostramos el sumatorio de la columna
			System.out.print("Σ" + (columna + 1) + ": " + sumaColumna + "         ");
			
		}
		
		// Mostramos la suma total
		System.out.print("Total: " + sumaTotal);

	}

}
