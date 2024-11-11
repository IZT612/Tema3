package englishexercises1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise01 {

	public static void main(String[] args) {

		// We create the scanner
		Scanner sc = new Scanner(System.in);

		// We create the variable "value" where we are going to store the value user
		// wants to introduce
		int value = 0;

		// We create the variable "position" where we are going to store
		int position = 0;

		/*
		 * We create the array "array" with a size of 10 where we are going to store the
		 * numbers the user wants to introduce
		 */
		int array[] = new int[10];

		// We create the boolean variable "error" to store if there is an error while
		// introducing values
		boolean error;

		boolean exit = false;

		// We create the String variable "option" to store the option chosen by the user
		String option = "";

		// We create a do-while loop which will repeat until the user introduces a
		// correct option
		do {

			System.out.println("Introduce which of the following options you want to do:");
			System.out.println();
			System.out.println("a. Show the values");
			System.out.println("b. Introduce a value");
			System.out.println("c. Exit the program");
			System.out.println();
			
			option = sc.nextLine();

			switch (option) {

			case "a" -> {

				System.out.println(Arrays.toString(array));
				System.out.println();

			}

			case "b" -> {

				do {

					error = false;

					try {

						System.out.println("Which value do you want to introduce?");

						value = sc.nextInt();

					} catch (InputMismatchException e) {

						System.out.println("You have to introduce a number");
						error = true;

					}

					if (error) {

						sc.next();

					}

				} while (error);

				do {

					error = false;

					try {

						System.out.println("In which position do you want to introduce that value?");

						position = sc.nextInt();
						
						assert (position >= 0 && position <= (array.length - 1)) : "The position has to be between 0 and " + (array.length - 1);

					} catch (InputMismatchException e) {

						System.out.println("You have to introduce a number");
						error = true;

					} catch (AssertionError e) {
						
						System.out.println(e.getLocalizedMessage());
						error = true;
						
					}

					if (error) {

						sc.next();

					}

				} while (error);

				array[position] = value;
				
				System.out.println("The value has been introduced correctly");

			}

			case "c" -> {

				System.out.println("Exiting the program...");
				exit = true;

			}

			default -> {

				System.out.println("You have to introduce a correct option");
				System.out.println();

			}

			}

		} while (!exit);

		sc.close();

	}

}
