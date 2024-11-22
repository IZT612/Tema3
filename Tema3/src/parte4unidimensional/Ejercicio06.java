package parte4unidimensional;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array "tabla"
		int[] tabla;
		
		// Creamos la variable entera "longitud" para guardar la longitud del array
		int longitud = 0;
		
		// Creamos la variable entera "grupos" para guardar de cuantos números se quieren los grupos
		int grupos = 0;
		
		// Creamos la variable booleana "error" para guardar si hay error al preguntar datos
		boolean error;
		
		// Hacemos un do-while para preguntar la longitud
		do {
			
			// Ponemos "error" como false para evitar bucles infinitos
			error = false;
			
			// Hacemos un try catch para capturar posibles errores en el codigo
			try {
			
				// Pedimos la longitud y la guardamos en "longitud"
				System.out.println("Introduzca la longitud del array");
				longitud = sc.nextInt();
				
				// Forzamos un error de asert si la longitud del array no es mayor que 0
				assert (longitud > 0) : "La longitud del array debe ser mayor que 0";
			
			// Capturamos el posible error de assert
			} catch (AssertionError e) {
				
				// Informamos al usuario y ponemos "error" como true
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			// Capturamos un posible error si no se ha introducido un numero entero
			} catch (InputMismatchException e) {
				
				// Informamos al usuario y ponemos error como true, además, limpiamos el scanner
				System.out.println("Debe introducir un número entero");
				error = true;
				sc.next();
				
			}
		
		// Esto se repite mientras que haya error
		} while (error);
		
		// Al array "tabla" le damos esa longitud
		tabla = new int[longitud];
		
		// Creamos un do-while para preguntar los grupos
		do {
			
			// Ponemos "error" como falso
			error = false;
			
			// Hacemos un try-catch para capturar posibles errores
			try {
			
				// Pedimos de cuanto quiere los grupos y lo insertamos en "grupos"
				System.out.println("¿Y de cuánto quiere los grupos?");
				grupos = sc.nextInt();
				
				// Forzamos un error de assert si la cantidad de grupos es mayor al tamaño del array "tabla"
				assert (grupos <= tabla.length) : "Los grupos deben ser como máximo del mismo tamaño";
			
			// Capturamos el error de assert
			} catch (AssertionError e) {
				
				// Informamos al usuario y ponemos "error" como true
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			// Capturamos un error por si no se ha introducido un numero entero
			} catch (InputMismatchException e) {
				
				// Informamos al usuario, ponemos "error" como true, y limpiamos el scanner
				System.out.println("Debe introducir un número entero");
				error = true;
				sc.next();
				
			}
		
		// Este se repite mientras haya error
		} while (error);
		
		// Creamos un bucle for que recorre la tabla
		for (int i = 0 ; i < tabla.length; i++) {
			
			// Pedimos que introduzca un número y lo guardamos dentro del array
			System.out.println("Introduzca un número en el array");
			tabla[i] = sc.nextInt();
			
		}
		
		// Mostramos el resultado llamando a la funcion "suma" dándole "tabla" y "grupos"
		System.out.println(Arrays.toString(suma(tabla, grupos)));
		
		// Cerramos el scanner
		sc.close();

	}
	
	// Creamos una función "suma" que devolverá un array, y requerirá un array y un número entero
	static int[] suma(int[] tabla, int grupos) {
		
		/* Creamos un array "tablaSumas" a la cual le daremos de tamaño todas las posibles sumas que se pueden 
		 * realizar teniendo en cuenta el tamaño del array proporcionado y la cantidad de numeros que se 
		 * agrupan. Aquí guardaremos las sumas de cada agrupación */
		int[] tablaSumas = new int[(tabla.length - grupos) + 1];
		
		// Creamos una variable entera "sumaTotal" donde guardaremos la suma total de cada agrupación de numeros
		int sumaTotal;
		
		/* Creamos una variable entera "posInicial" donde guardamos la posición por la que debemos iniciar a 
		 * agrupar */
		int posInicial;
		
		/* Creamos un bucle for que recorre las filas del array, y se repite tantas veces como posibles sumas 
		 * hay según las agrupaciones de numeros y el tamaño del array */
		for (int i = 0 ; i <= (tabla.length - grupos) ; i++) {
			
			// Ponemos "sumaTotal" como 0
			sumaTotal = 0;
			
			/* Creamos otro bucle for el cual irá recorriendo los elementos del array desde la posición inicial
			 * (i), y se repetirá hasta que alcance la posición del último número con el que se debería 
			 * agrupar */
			for (int j = i; j < (i + grupos)  ; j++) {
				
				// Sumamos el número a "sumaTotal"
				sumaTotal += tabla[j];
				
			}
			
			// Insertamos en "tablaSumas" la suma total ("sumaTotal")
			tablaSumas[i] = sumaTotal;
			
		}
		
		// Devolvemos el array "tablaSumas"
		return tablaSumas;
		
	}

}
