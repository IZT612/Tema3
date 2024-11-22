package parte4bidimensional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] tabla;
		
		int[][] tablaTraspuesta;
		
		int filas = 0;
		
		int columnas = 0;
		
		boolean error;
		
		int dato = 1;
		
		int valor;
		
		do {

			valor = 0;
			
			error = false;
			
			try {
				
				if (dato == 1) {
					
					System.out.println("Introduzca cuantas filas quiere tener en su array bidimensional");
					valor = sc.nextInt();
					
				} else {
					
					System.out.println("Introduzca cuantas columnas quiere tener en su array bidimensional");
					valor = sc.nextInt();
					
				}
				
				assert(valor > 0) : "El valor introducido debe ser mayor que 0";
				
			} catch(InputMismatchException e) {
				
				System.out.println("El valor introducido debe ser un número entero");
				error = true;
				sc.next();
				
			} catch (AssertionError e) {
				
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			}
			
			if (dato == 1 && !error) {
				
				filas = valor;
				dato++;
				
			} else if (dato == 2 && !error) {
				
				columnas = valor;
				dato++;
				
			}
			
		} while (error || !(dato > 2));
		
		tabla = new int[filas][columnas];
		
		for (int i = 0 ; i < tabla.length ; i++) {
			
			for (int j = 0; j < tabla[i].length ; j++) {
				
				do {
					
					error = false;
					
					try {
						
						System.out.println("Introduzca un valor para el array, estamos en la fila " + (i + 1) + " y columna " + (j + 1));
						tabla[i][j] = sc.nextInt();
						
					} catch (InputMismatchException e) {
						
						System.out.println("El número introducido debe ser mayor que 0");
						error = true;
						sc.next();
						
					}
					
				} while (error);

			}
			
		}
		
		// tabla creada

	}

}
