package parte2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random rand = new Random();

		int tabla[] = new int[6];

		int ganadores[] = { 6, 14, 22, 35, 36, 37 };

		int aciertos = 0;

		boolean seRepite = false;

		for (int i = 0; i <= (tabla.length - 1); i++) {

			tabla[i] = rand.nextInt(1, 50);

		}

		for (int i = 0; i <= (tabla.length - 1); i++) {

			if (seRepite) {

				i = 0;

			}

			do {

				seRepite = false;

				Arrays.sort(tabla);

				if (i != (tabla.length - 1) && tabla[i] == tabla[(i + 1)]) {

					tabla[i] = rand.nextInt(1, 50);

					seRepite = true;

				}

			} while (seRepite);

		}

		System.out.println("Tus números son: " + Arrays.toString(tabla));
		System.out.println();
		System.out.println("Y los números ganadores son: " + Arrays.toString(ganadores));
		System.out.println();
		
		for (int i = 0 ; i <= (tabla.length - 1) ; i++) {
			
			if(Arrays.binarySearch(ganadores, tabla[i]) >= 0) {
				
				aciertos++;
				
			}
			
		}

		System.out.println("Ha acertado " + aciertos + " números");

		sc.close();

	}

}
