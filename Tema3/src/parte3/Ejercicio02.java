package parte3;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tabla[][] = new int[5][5];
		
		for (int fila = 0; fila < tabla.length ; fila++) {
			
			System.out.println();
			
			for (int columna = 0; columna < 6 ; columna++) {
				
				 System.out.println("Introduzca la nota del alumno " + fila + " en la asignatura " + (columna + 1));
				
				 sc.nextInt();
				 
				 
				
			}
			
		}
		
		

	}

}
