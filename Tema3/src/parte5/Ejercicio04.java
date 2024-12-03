package parte5;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el tablero como un array bidimensional 8x8
		char[][] tablero = new char[8][8];

		// Creamos una variable entera "fila" donde guardaremos la fila en la que se
		// encuentra la pieza
		int fila;

		// Creamos una variable de caracter "columnaChar" donde guardaremos en qué
		// columna está la pieza
		char columnaChar;

		// Creamos una variable entera "columna" donde guardaremos la columna de la
		// pieza como entero para poder trabajar con ella
		int columna;

		// Creamos una variable de caracter "pieza" donde guardaremos la pieza del
		// usuario
		char pieza;

		// Creamos un bucle que recorre las filas para llenar todas las filas de
		// asteriscos
		for (int i = 0; i < tablero.length; i++) {

			Arrays.fill(tablero[i], '*');

		}

		// Le preguntamos al usuario cuál es su pieza y la guardamos
		System.out.println("¿Cuál es tu pieza?");
		System.out.println("T. torre");
		System.out.println("A. alfil");
		System.out.println("D. dama");
		System.out.println("C. caballo");
		pieza = sc.next().charAt(0);

		// Le preguntamos en que fila se encuentra y lo guardamos en "fila", restandole
		// 1 ya que en un tablero hay hasta la fila 8 pero el array al comenzar desde 0
		// el máximo es 7
		System.out.println("¿En qué fila se encuentra su pieza?");
		fila = (sc.nextInt() - 1);

		// Le preguntamos la columna, y hacemos la guardamos en "columnaChar"
		System.out.println("¿Y en qué columna?");
		columnaChar = sc.next().charAt(0);

		// Pasamos el caracter a entero para trabajar con el, guardandolo en "columna"
		columna = ((int) columnaChar) - 97;

		// Creamos un switch según la pieza
		switch (pieza) {

		// Si es una Torre llama a la función "movimientosTorre"
		case 'T' -> {

			movimientosTorre(tablero, fila, columna);

		}

		// Si es un Alfil llama a la función "movimientosAlfil"
		case 'A' -> {

			movimientosAlfil(tablero, fila, columna);

		}

		// Si es una Dama llama a la función "movimientosDama"
		case 'D' -> {

			movimientosDama(tablero, fila, columna);

		}

		// Si es un Caballo llama a la función "movimientosCaballo"
		case 'C' -> {

			movimientosCaballo(tablero, fila, columna);

		}

		}

		// Ponemos la pieza en el tablero
		tablero[fila][columna] = pieza;

		// Recorremos las filas de "tablero"
		for (int i = 0; i < tablero.length; i++) {

			// Recorremos las columnas
			for (int j = 0; j < tablero[i].length; j++) {

				// Mostramos los valores
				System.out.print(tablero[i][j] + " ");

			}

			// Hacemos un espacio
			System.out.println();

		}

		// Cerramos el scanner
		sc.close();

	}

	// Creamos la función "movimientosTorre", que recibe un array bidimensional
	// "tablero", un entero "fila" y un entero "columna"
	static void movimientosTorre(char[][] tablero, int fila, int columna) {

		// Recorremos las filas
		for (int i = 0; i < tablero.length; i++) {

			// En todas las filas a la misma coordenada x que la pieza colocamos una X
			tablero[i][columna] = 'X';

		}

		// Recorremos las columnas
		for (int j = 0; j < tablero[0].length; j++) {

			// En todas las columnas a la misma coordenada y que la pieza colocamos una X
			tablero[fila][j] = 'X';

		}

	}

	// Creamos la función "movimientosAlfil", que recibe un array bidimensional
	// "tablero", un entero "fila" y un entero "columna"
	static void movimientosAlfil(char[][] tablero, int fila, int columna) {

		// Creamos una variable "distancia" que nos ayudará a hacer una diagonal
		int distancia = 0;

		// Recorremos las columnas hacia la derecha
		for (int j = columna; j < tablero[0].length; j++) {

			// Si la fila + la distancia (hacia arriba) se encuentra en el tablero entramos
			// al if
			if (fila + distancia < tablero.length) {

				// Colocamos una X en la coordenada y de la pieza más la distancia, y en la
				// coordenada x que nos encontremos (j)
				tablero[fila + distancia][j] = 'X';
			}

			// Repetimos pero esta vez hacia abajo
			if (fila - distancia >= 0) {
				tablero[fila - distancia][j] = 'X';
			}

			// Incrementamos la distancia
			distancia++;

		}

		// Reiniciamos la distancia
		distancia = 0;

		// Repetimos el proceso anterior esta vez yendo hacia la izquierda
		for (int j = columna; j >= 0; j--) {

			if (fila + distancia < tablero.length) {
				tablero[fila + distancia][j] = 'X';
			}

			if (fila - distancia >= 0) {
				tablero[fila - distancia][j] = 'X';
			}

			distancia++;

		}

	}

	// Creamos la función "movimientosDama", que recibe un array bidimensional
	// "tablero", un entero "fila" y un entero "columna". Esta función es
	// simplemente "movimientosTorre" y "movimientosAlfil" juntas.
	static void movimientosDama(char[][] tablero, int fila, int columna) {

		int distancia = 0;

		// La parte de la torre es de aquí
		for (int i = 0; i < tablero.length; i++) {

			tablero[i][columna] = 'X';

		}

		for (int j = 0; j < tablero[0].length; j++) {

			tablero[fila][j] = 'X';

		}

		// Hasta aquí, donde ahora comienza la parte del alfil, desde aquí hasta acabar

		for (int j = columna; j < tablero[0].length; j++) {

			if (fila + distancia < tablero.length) {
				tablero[fila + distancia][j] = 'X';
			}

			if (fila - distancia >= 0) {
				tablero[fila - distancia][j] = 'X';
			}

			distancia++;

		}

		distancia = 0;

		for (int j = columna; j >= 0; j--) {

			if (fila + distancia < tablero.length) {
				tablero[fila + distancia][j] = 'X';
			}

			if (fila - distancia >= 0) {
				tablero[fila - distancia][j] = 'X';
			}

			distancia++;

		}

	}

	// Creamos la función "movimientosCaballo", que recibe un array bidimensional
	// "tablero", un entero "fila" y un entero "columna"
	static void movimientosCaballo(char[][] tablero, int fila, int columna) {

		// Recorremos la fila
		for (int i = 0; i < tablero.length; i++) {

			// Si la fila en la que nos encontramos está 2 filas arriba o 2 filas abajo que
			// la pieza, entramos al condicional
			if (i == (fila - 2) || i == (fila + 2)) {

				// Revisamos si las posiciones perpendiculares de al lado se encuentran en el
				// tablero, y si es el caso, ponemos las X

				if (columna - 1 >= 0) {
					tablero[i][columna - 1] = 'X';
				}

				if (columna + 1 < tablero[i].length) {
					tablero[i][columna + 1] = 'X';
				}

			}

		}

		// Recorremos las columnas
		for (int j = 0; j < tablero[0].length; j++) {

			// Si la columna en la que nos encontramos está 2 columnas a la derecha o a la
			// izquierda de la pieza, entramos al condicional
			if (j == (columna - 2) || j == (columna + 2)) {

				// Revisamos si las posiciones perpendiculares de al lado se encuentran en el
				// tablero, y si es el caso, ponemos las X
				if (fila + 1 < tablero.length) {
					tablero[fila + 1][j] = 'X';
				}

				if (fila - 1 >= 0) {
					tablero[fila - 1][j] = 'X';
				}

			}

		}

	}

}
