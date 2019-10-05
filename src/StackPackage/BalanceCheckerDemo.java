package StackPackage;

import java.util.Scanner;

/**
 * Takes an input string from the user and determines
 * if it has balanced characters
 * 
 * @author mhrybyk
 *
 */
public class BalanceCheckerDemo {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter string expression:");

		String input = keyboard.nextLine();

		if (BalanceChecker.checkBalance(input))
			System.out.println("OK: " + input);
		else
			System.out.println("FAILED: " + input);

		keyboard.close();

	}

}
