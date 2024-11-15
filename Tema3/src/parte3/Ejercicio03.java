package parte3;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos la variable "filas" donde guardaremos las filas que tendrá el array bidimensional
		int filas;
		
		// Creamos la variable "columnas" donde guardaremos las columnas que tendrá el array bidimensional
		int columnas;
		
		// Creamos un array bidimensional "tabla" vacío, el cual rellenaremos más adelante
		int tabla[][];
		
		// Pedimos e introducimos las filas que tiene el array
		System.out.println("¿Cuántas filas quiere tener en el array?");
		filas = sc.nextInt();
		
		// Pedimos e introducimos las columnas que tiene el array
		System.out.println("¿Y cuántas columnas?");
		columnas = sc.nextInt();
		
		// A "tabla" le damos el tamaño que el usuario ha introducido
		tabla = new int[filas][columnas];
		
		// creamos un for que recorre las filas (este se encargará de introducir valores)
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			// Y otro para recorrer las columnas
			for (int columna = 0 ; columna < columnas ; columna++) {
				
				// Calculamos el valor de cada posicion con la siguiente formula: "10 * fila + columna"
				tabla[fila][columna] = 10 * fila + columna;
				
			}
			
		}
		
		// Creamos un for que recorre todas las filas (este se encargará de mostrar los valores)
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			// Y otro que recorrerá las columnas 
			for (int columna = 0 ; columna < columnas ; columna++) {
				
				// Mostramos el valor en esa posición
				System.out.print(tabla[fila][columna] +"    ");
				
			}
			
			// Creamos un espacio ya que vamos a cambiar de fila, o terminar el programa
			System.out.println();
			
		}
		
		// Cerramos el scanner
		sc.close();

	}

}
