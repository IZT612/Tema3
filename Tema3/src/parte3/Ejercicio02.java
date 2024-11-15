package parte3;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos un array bidimensional "tabla" donde almacenaremos distintas notas de varios alumnos
		double tabla[][] = new double[4][5];
		
		/* Creamos las variables "maximo" y "minimo" donde guardaremos las notas máximas y minimas 
		 * correspondientes de cada alumno */
		double maximo;
		double minimo;
		
		// Creamos la variable "suma" para calcular la media
		double suma;
		
		// Creamos la variable "media" para mostrar la media
		double media;
		
		// Creamos un for que recorrerá cada fila del array
		for (int fila = 0; fila < tabla.length ; fila++) {
			
			// Y otro for que recorre las columnas
			for (int columna = 0; columna < 5 ; columna++) {
				
				// Pedimos que introduzca el dato
				 System.out.println("Introduzca la nota del alumno " + (fila + 1) + " en la asignatura " + (columna + 1));
				
				 // Introducimos el valor en el lugar de la tabla que le corresponda
				 tabla[fila][columna] = sc.nextDouble();
				 
				 
			}
			
		}
		
		// Mostramos el encabezado de la tabla a mostrar, para hacerlo más visual
		System.out.print("              ");
		System.out.print(" Asignatura 1 ");
		System.out.print(" Asignatura 2 ");
		System.out.print(" Asignatura 3 ");
		System.out.print(" Asignatura 4 ");
		System.out.print(" Asignatura 5 ");
		
		// Creamos un for que recorrerá cada fila
		for (int fila = 0; fila < tabla.length ; fila++) {
			
			// Reiniciamos los valores del máximo y minimo
			maximo = Integer.MIN_VALUE;
			minimo = Integer.MAX_VALUE;
			suma = 0;
			
			// Cambiamos de linea ya que estamos en otra fila
			System.out.println();
			
			// Mostramos a que alumno le pertenece esa fila
			System.out.print("Alumno " + (fila + 1) + "       ");
			
			// Creamos un for que recorre cada columna de la fila
			for (int columna = 0; columna < 5; columna++) {
				
				// Mostramos el valor de cada posicion de la tabla
				System.out.print("      " + tabla[fila][columna] + "    ");
				
				suma += tabla[fila][columna];
				
				// Si el valor de la tabla es mas grande que el actual maximo
				if (tabla[fila][columna] > maximo) {
					
					// Guardamos el valor como nuevo máximo
					maximo = tabla[fila][columna];
	
				}
				
				// Si el valor de la tabla es menor que el actual minimo
				if (tabla[fila][columna] < minimo) {
					
					// Guardamos el valor como nuevo minimo
					minimo = tabla[fila][columna];
	
				}
				
			}
			
			media = suma / 5;
			
			
			// Mostramos: maximo, minimo y media antes de cambiar de fila
			System.out.print("      Máxima: " + maximo);
			System.out.print("    Mínima: " + minimo);
			System.out.println("     Media: " + media);
			
		}
		
		// Cerramos el scanner
		sc.close();

	}

}
