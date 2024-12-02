package englishexercises2;

import java.util.Scanner;

public class exercise01 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String[][] table = new String[3][3];

		int[] position = new int[2];

		int player = 1;
		
		boolean continueGame;

		for (int i = 0; i < table.length; i++) {

			for (int j = 0; j < table[i].length; j++) {

				table[i][j] = "-";

			}

		}

		while (player <= 2) {

			System.out.println("Turn of player " + player);

			for (int i = 0; i < table.length; i++) {

				for (int j = 0; j < table[i].length; j++) {

					System.out.print(table[i][j] + " ");

				}

				System.out.println();

			}

			position = positionFc(table);
			
			continueGame = end(table);

			if (player == 1) {

				table[position[0]][position[1]] = "X";
				player = 2;

			} else {

				table[position[0]][position[1]] = "O";
				player = 1;

			}

		}

	}

	static int[] positionFc(String[][] table) {

		int[] position = new int[2];

		int row;
		int column;

		do {

			System.out.println("Introduce the row where you want to put your mark (Has to be empty)");
			row = sc.nextInt();

			System.out.println("Now the column");
			column = sc.nextInt();
			
			position[0] = row;
			position[1] = column;


		} while(!table[position[0]][position[1]].equals("-"));

		return position;
	}
	
	static boolean end(String[][] table) {
		
		boolean continueGame = true;
		
		for (int i = 0; i < table.length && continueGame; i++) {
			
			if (table[i][0].equals(table[i][1]) && table[i][0].equals(table[i][2])) {
				
				continueGame = false;
				
			}
			
		}
		
		for (int j = 0; j < table.length && continueGame; j++) {
			
			if (table[0][j].equals(table[1][j]) && table[0][j].equals(table[2][j])) {
				
				continueGame = false;
				
			}
			
		}
		
		if (table[0][0].equals(table[1][1]) && table[0][0].equals(table[2][2])) {
			
			continueGame = false;
			
		}
		
		if (table[0][2].equals(table[1][1]) && table[0][2].equals(table[2][0])) {
			
			continueGame = false;
			
		}
		
		for (int i = 0; i < table.length && continueGame; i++) {
			
			for (int j = 0; j < table[i].length && continueGame; j++)  {
				
				if (table[i][j].equals("-")) {
					
					continueGame = false;
					
				}
				
			}
			
			
		}
		
		return continueGame;
	}

}
