package parte5;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[][] tablero = new char[8][8];

		int fila;

		char columnaChar;

		int columna;

		char pieza;

		for (int i = 0; i < tablero.length; i++) {

			Arrays.fill(tablero[i], '*');

		}

		System.out.println("¿Cuál es tu pieza?");
		System.out.println("T. torre");
		System.out.println("A. alfil");
		System.out.println("D. dama");
		System.out.println("C. caballo");

		pieza = sc.next().charAt(0);

		System.out.println("¿En qué fila se encuentra su pieza?");

		fila = (sc.nextInt() - 1);

		System.out.println("¿Y en qué columna?");

		columnaChar = sc.next().charAt(0);

		columna = ((int) columnaChar) - 97;

		System.out.println(columna);

		tablero[fila][columna] = pieza;

		movimientosAlfil(tablero, pieza, fila, columna);

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {

				System.out.print(tablero[i][j] + " ");

			}

			System.out.println();

		}

	}

	static void movimientosTorre(char[][] tablero, char pieza, int fila, int columna) {

		for (int i = 0; i < tablero.length; i++) {

			tablero[i][columna] = 'X';

		}

		for (int j = 0; j < tablero[0].length; j++) {

			tablero[fila][j] = 'X';

		}

		tablero[fila][columna] = pieza;

	}

	static void movimientosAlfil(char[][] tablero, char pieza, int fila, int columna) {

		int distancia = 0;

		for (int j = columna; j < tablero.length; j++) {

			if (j + distancia < tablero[j].length) {
				tablero[fila][j + distancia] = 'X';
			}

			if (j - distancia >= 0) {
				tablero[fila][j - distancia] = 'X';
			}

			distancia++;

		}

		distancia = 0;

		for (int j = columna; j >= 0; j--) {

			if (j + distancia < tablero[j].length) {
				tablero[fila][j + distancia] = 'X';
			}

			if (j - distancia >= 0) {
				tablero[fila][j - distancia] = 'X';
			}

			distancia++;

		}

		tablero[fila][columna] = pieza;

	}

}
