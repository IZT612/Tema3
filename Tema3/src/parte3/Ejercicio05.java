package parte3;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		int tabla[][] = new int[4][5];
		
		int sumaFila;
		
		int sumaTotal = 0;
		
		int sumaColumna;
		
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			for (int columna = 0 ; columna < 10 ; columna++) {
				
				tabla[fila][columna] = rand.nextInt(100, 1000);
				
			}
			
			
		}
		
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			sumaFila = 0;
			
			for (int columna = 0 ; columna < 10 ; columna++) {
				
				System.out.print(tabla[fila][columna] + "  ");
				sumaFila += tabla[fila][columna];
				sumaTotal += tabla[fila][columna];
				
			}
			
			System.out.println();
			
		}
		
		for (int columna = 0 ; columna < 10 ; columna++) {
			
			for (int fila = 0 ;  ; fila++) {
				
			}
			
		}

	}

}
