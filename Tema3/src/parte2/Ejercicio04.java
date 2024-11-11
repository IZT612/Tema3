package parte2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos un array "tabla" de tamaño 8 donde guardaremos los valores iniciales ordenados de menor a mayor
		int tabla[] = new int[8];
		
		// Creamos un array "tablaFinal" de tamaño 8 donde guardaremos los valores ordenados de mayor a menor
		int tablaFinal[] = new int[8];

		// Creamos una variable entera "puntuacion" donde guardaremos la puntuación que introduzca el usuario
		int puntuacion = 0;

		// Creamos una variable booleana "error" para ver si hay errores al introducir los datos
		boolean error;

		// Creamos un bucle for para introducir las puntuaciones en la tabla
		for (int i = 0; i <= (tabla.length - 1); i++) {
			
			//  Creamos un do-while para pedir datos y repetir si es incorrecto
			do {

				// Ponemos error como falso
				error = false;

				// Hacemos un try catch para evitar errores
				try {

					//  Pedimos una puntuacion
					System.out.println("Introduzca una puntuación entre 1000 y 2800");

					// La guardamos en "puntuacion"
					puntuacion = sc.nextInt();

					// Obligamos un AssertionError si la puntuación no es mayor que 1000 y menor que 2800
					assert (puntuacion > 1000 && puntuacion < 2800)
							: "Debe introducir una puntuación entre los valores dados";

				// Si no se introduce un numero entero capturamos el error
				} catch (InputMismatchException e) {

					// Se lo indicamos al usuario
					System.out.println("Debe introducir un número");
					
					// Ponemos "error" como true
					error = true;

				// Si el dato no está entre los valores indicados
				} catch (AssertionError e) {

					// Se lo indicamos al usuario
					System.out.println(e.getLocalizedMessage());
					
					// Ponemos "error" como true
					error = true;

				}

				// Si hay error
				if (error) {

					// Limpiamos el scanner
					sc.next();

				}

			// Se vuelve a pedir el dato si hay error
			} while (error);
			
			// Guardamos el valor en la tabla
			tabla[i] = puntuacion;

		}
		
		// Ordenamos la tabla de menor a mayor
		Arrays.sort(tabla);
		
		// Hacemos un for que irá recorriendo "tablaFinal" del último valor al primero
		for (int i = (tabla.length - 1) ; i >= 0 ; i--) {
			
			// En la posición correspondiente de "tablaFinal" guardamos el valor de "tabla" en la posición inversa
			tablaFinal[i] = tabla[(tabla.length - 1) - i];
			
		}
		
		// Mostramos la tabla ordenada de mayor a menor
		System.out.println(Arrays.toString(tablaFinal));
		
		// Cerramos el scanner
		sc.close();

	}

}
