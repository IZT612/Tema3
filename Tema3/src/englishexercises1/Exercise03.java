package englishexercises1;

import java.util.Random;
import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		int length = 10;
		
		int fly;
		
		int userInput = -1;
		
		boolean adjacent = false;
		
		int array[]; 
		
		System.out.println("Which do you want the length to be?");
		
		length = sc.nextInt();
		
		array = new int[length];
		
		fly = rand.nextInt(0, array.length);
		
		array[fly] = 1;
		
		System.out.println("Where do you think the fly is?");
		
		userInput = sc.nextInt();
		
		while (array[userInput] != 1) {
			
			if (((userInput != 0) && (userInput != (array.length - 1))) && ((array[(userInput - 1)] == 1) || (array[(userInput + 1)] == 1))) {
				
				adjacent = true;
				
			} else if (userInput == 0 && (array[(userInput + 1)] == 1)) {
				
				adjacent = true;
				
			} else if ((userInput == (array.length - 1)) && (array[(userInput - 1)] == 1)) {
				
				adjacent = true;

			}
			
			if (adjacent) {
				
				System.out.println("The fly was in a contiguous position, but it changed its position");
				
				array[fly] -= 1;
				
				fly = rand.nextInt(0, array.length);
				
				array[fly] = 1;
				
				adjacent = false;
				
			} else {
				
				System.out.println("The fly was not in a contiguous position, it has not changed its position");
				
			}
			
			System.out.println("Where do you think the fly is?");
			
			userInput = sc.nextInt();
			
		}
		
		System.out.println("¡You win!");
		
		sc.close();
		
	}
	


}
