package parte1;

import java.util.Arrays;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		// Creamos el array "tabla" donde guardaremos todos los valores de la tabla del ejercicio
		int num[] = new int[12];
		
		// Aplicamos todos los valores de la tabla del ejercicio
		num[0] = 39;
		num[1] = -2;
		num[4] = 0;
		num[6] = 14;
		num[8] = 5;
		num[9] = 120;
		
		// Mostramos la tabla
		System.out.println(Arrays.toString(num));
		
		// Hacemos un espacio
		System.out.println();
		
		// Respondemos a la pregunta
		System.out.println("Los valores no inicializados aparecen como 0");

	}

}
