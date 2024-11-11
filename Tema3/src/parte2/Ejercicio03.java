package parte2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el generador de numeros aleatorios
		Random rand = new Random();
		
		// Creamos el array "tabla" de tamaño 30
		int tabla[] = new int[30];
		
		// Creamos un bucle for el cual irá recorriendo cada posición de la tabla
		for (int i = 0 ; i <= (tabla.length - 1)  ; i++) {
			
			// Introducimos un valor aleatorio entre 0 y 9 en la posición
			tabla [i] = rand.nextInt(1, 10);
			
		}
		
		// Ordenamos el array
		Arrays.sort(tabla);
		
		// Mostramos el array
		System.out.println(Arrays.toString(tabla));
		
		// Cerramos el scanner
		sc.close();

	}

}
