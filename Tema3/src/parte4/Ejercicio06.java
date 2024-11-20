package parte4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] tabla;
		
		int longitud = 0;
		
		int grupos = 0;
		
		boolean error;
		
		do {
			
			error = false;
			
			try {
			
				System.out.println("Introduzca la longitud del array");
				longitud = sc.nextInt();
				
				assert (longitud > 0) : "La longitud del array debe ser mayor que 0";
			
			} catch (AssertionError e) {
				
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debe introducir un número entero");
				error = true;
				sc.next();
				
			}
		
		} while (error);
		
		tabla = new int[longitud];
		
		do {
			
			error = false;
			
			try {
			
				System.out.println("¿Y de cuánto quiere los grupos?");
				grupos = sc.nextInt();
				
				assert (grupos <= tabla.length) : "Los grupos deben ser como máximo del mismo tamaño";
			
			} catch (AssertionError e) {
				
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debe introducir un número entero");
				error = true;
				sc.next();
				
			}
		
		} while (error);
		
		for (int i = 0 ; i < tabla.length; i++) {
			
			System.out.println("Introduzca un número en el array");
			tabla[i] = sc.nextInt();
			
		}
		
		System.out.println(Arrays.toString(suma(tabla, grupos)));
		
		sc.close();

	}
	
	static int[] suma(int[] tabla, int grupos) {
		
		int[] tablaSumas = new int[(tabla.length - grupos) + 1];
		int sumaTotal;
		int ultimaPos;
		
		for (int i = 1 ; i <= (tabla.length - grupos) + 1 
				; i++) {
			
			sumaTotal = 0;
			
			ultimaPos = i - 1;
			
			for (int j = ultimaPos; j <= (ultimaPos + grupos) - 1  ; j++) {
				
				sumaTotal += tabla[j];
				
			}
			
			tablaSumas[i-1] = sumaTotal;
			
		}
		
		return tablaSumas;
		
	}

}
