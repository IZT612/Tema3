package parte1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el generador de numeros aleatorios
		Random rand = new Random();
		
		// Creamos una variable booleana "error" donde guardaremos si hay errores o no al introducir los datos
		boolean error;
		
		// Creamos la variable entera "numero" donde guardaremos el numero introducido por el usuario
		int numero = 0;
		
		// Creamos la tabla "numeros" con 100 espacios
		int numeros[] = new int[100];
		
		// Hacemos un bucle for el cual irá almacenando en cada espacio de la tabla un número aleatorio entre 1 y 10
		for (int i = 0 ; i < numeros.length ; i++) {
			
			// Introducimos el numero aleatorio en el lugar de la tabla correspondiente
			numeros[i] = rand.nextInt(1, 11);
			
		}
		
		// Hacemos un do-while para pedir el numero
		do {
			
			// Ponemos "error" como false para evitar bucles infinitos
			error = false;
			
			// Hacemos un try catch para ver si hay errores en esta parte del codigo
			try {
				
				// Pedimos el numero
				System.out.println("Introduzca un número del 1 al 10");
				
				// Lo introducimos en "numero"
				numero = sc.nextInt();
				
				// Hacemos un assert para que nos de error si el numero esta por debajo de 1 o por encima de 10
				assert (numero >= 1 && numero <= 10) : "El número debe estar entre 1 y 10";
				
			// Si ha introducido algo que no es un numero capturamos el error
			} catch (InputMismatchException e) {
				
				// Le pedimos que introduzca un numero
				System.out.println("Debe introducir un número entero");
				
				// Y ponemos "error" como true
				error = true;
				
			// Si el assert ha dado error lo capturamos
			} catch (AssertionError e) {
				
				// Y le decimos que el numero debe estar entre 1 y 10
				System.out.println(e.getLocalizedMessage());
				
				// Y ponemos "error" como true
				error = true;
				
			}
			
			// Si hay error
			if (error) {
				
				// Limpiamos el scanner
				sc.next();
				
			}
			
		// El do-while se repite mientras haya error
		} while (error);
		
		// Mostramos este mensaje para indicarle en que posiciones está el numero que ha introducido el usuario
		System.out.println("El número " + numero + " se encuentra en las posiciones: ");
		
		// Hacemos un bucle for para recorrer toda la tabla 
		for (int i = 0 ; i < numeros.length ; i++) {
			
			// Si el numero del usuario es igual a alguno de los de la tabla
			if (numeros[i] == numero) {
				
				// Mostramos su posicion
				System.out.print(i + ", ");
				
			}
			
		}
		
		// Cerramos el scanner
		sc.close();

	}

}
