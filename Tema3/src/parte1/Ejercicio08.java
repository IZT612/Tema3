package parte1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		boolean error;
		
		int numero = 0;
		
		int numeros[] = new int[100];
		
		for (int i = 0 ; i < numeros.length ; i++) {
			
			numeros[i] = rand.nextInt(1, 11);
			
		}
		
		do {
			
			error = false;
			
			try {
				
				System.out.println("Introduzca un número del 1 al 10");
				
				numero = sc.nextInt();
				
				assert (numero >= 1 && numero <= 10) : "El número debe estar entre 1 y 10";
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debe introducir un número entero");
				error = true;
				
			} catch (AssertionError e) {
				
				System.out.println(e.getLocalizedMessage());
				error = true;
				
			}
			
			if (error) {
				
				sc.next();
				
			}
			
		} while (error);
		
		System.out.println("El número " + numero + " se encuentra en las posiciones: ");
		
		for (int i = 0 ; i < numeros.length ; i++) {
			
			if (numeros[i] == numero) {
				
				System.out.print(i + ", ");
				
			}
			
		}
		
		sc.close();

	}

}
