package parte3;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Creamos el array "tabla" para guardar los valores que el ejercicio nos da
		int tabla[][] = new int[3][6];
		
		// Guardamos los valores en la tabla
		tabla[0][0] = 0;
		tabla[0][1] = 30;
		tabla[0][2] = 2;
		tabla[0][5] = 5;
		tabla[1][0] = 75;
		tabla[1][4] = 0;
		tabla[2][2] = -2;
		tabla[2][3] = 9;
		tabla[2][5] = 11;
		
		// Hacemos un bucle que recorrerá las filas
		for (int fila = 0 ; fila < tabla.length ; fila++) {
			
			// Hacemos un espacio para mostrar la próxima fila debajo
			System.out.println();
			
			// Hacemos un bucle que recorrerá las columnas
			for (int columna = 0 ; columna < 6 ; columna++) {
				
				// Mostramos el número que se encuentre en la posición correspondiente con un espacio
				System.out.print(tabla[fila][columna] + " ");
				
			}
			
		}

	}

}
