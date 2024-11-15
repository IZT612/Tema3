package parte3;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		// Creamos el array bidimensional "tabla" con tamaño 10x10
		int tabla[][] = new int[10][10];
		
		// creamos un for que recorrerá las filas (Este se encargara de introducir valores)
		for (int fila = 0; fila < tabla.length ; fila++) {
			
			// Creamos otro que recorrerá las columnas
			for (int columna = 0; columna < 10 ; columna++) {
				
				// Introducimos en la posición correspondiente su valor
				tabla[fila][columna] = ((fila + 1) * (columna + 1));
				
			}
	
		}
		
		// creamos un for que recorrerá las filas (este se encargará de mostrar los valores)
		for (int fila = 0; fila < tabla.length ; fila++) {
			
			// Mostramos el número en el que nos encontramos
			System.out.print((fila + 1) + ":");
			
			// Recorremos las columnas
			for (int columna = 0; columna < 10 ; columna++) {
				
				// Mostramos el valor que corresponde
				System.out.print("  " + tabla[fila][columna] + "  ");
				
			}
			
			// Ponemos un espacio al cambiar de número
			System.out.println();
			
		}

	}

}
