package StackPackage;

import java.util.Scanner;
import java.util.Stack;

/**
 * Simple calculator that first converts infix string to postfix string
 * then evaluates and returns the result
 * 
 * @author mhrybyk
 *
 */
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// loop to get input until q is typed
		
		String input = "";

		while (true) {
			System.out.println("Enter infix expression or q to quit: ");
			input = scanner.nextLine();

			if (input.equals("q") == true)
				break;

			// convert the string to postfix and display
			
			String postfix = infixToPostfix(input);
			System.out.println("postfix: " + postfix);
			
			// now evaluate it and display the result
			System.out.println("value: " + evalPostfix(postfix));
		}

		System.out.println("Finished");
		scanner.close();
	}

	/**
	 * Determine the precedence of operators
	 * Higher is more
	 * Note that parentheses are the lowest
	 * @param op
	 * @return
	 */
	static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 5;
		case '*':
		case '/':
			return 10;
		case '^':
			return 20;
		case '(':
		case ')':
			return 0;
		default:
			throw new IllegalArgumentException("invalid operator");
		}
	}

	/**
	 * evaluate infix string and return a postfix
	 * 
	 * @param infix
	 * @return postfix string with spaces between tokens
	 */
	public static String infixToPostfix(String infix) {
		// first remove all whitespace and convert to an array of characters
		char tokens[] = infix.replaceAll("\\s", "").toCharArray();
		
		String postfix = ""; // for the output
		
		// operatorStack holds all of the operators
		
//		Stack<Character> operatorStack = new Stack<>(); // change isEmpty() to empty() to use
		
		 StackInterface<Character> operatorStack = new ArrayStack<>();
//		 StackInterface<Character> operatorStack = new LinkedStack<>();
//		 StackInterface<Character> operatorStack = new VectorStack<>();
		 
//		 StackInterface<Character> operatorStack = new CompletedArrayStack<>();
//		 StackInterface<Character> operatorStack = new CompletedLinkedStack<>();
//		 StackInterface<Character> operatorStack = new CompletedVectorStack<>();	

		// for each character, if it is a digit, pass it through
		// if an operator, and there are some on the stack, look to see
		//   if the top is higher than what we have, if so pop the stack, and do over
		//   finally push the operator onto the stack.
		// if an open parens, push it onto the stack
		// if a close parens, pop the stack until an open parens is found
		
		for (char c : tokens) {
			if (Character.isDigit(c)) {
				postfix += c; // just build up an integer
			} else {
				postfix += " "; // output tokens are separated by blanks
				
				switch (c) {
				case '+':
				case '-':
				case '/':
				case '*':
				case '^':
					// This is an operator. If the top of the operator stack
					// is of higher or equal precedence to what we have,
					// pass the operator through to output and pop the stack
					while (!operatorStack.isEmpty()) {
						char top = operatorStack.peek();
						if (precedence(top) >= precedence(c)) {
							postfix += (top + " ");
							operatorStack.pop();
						} else {
							break;
						}
					}
					operatorStack.push(c);
					break;
				case '(':
					operatorStack.push(c);
					break;
				case ')':
					// closing parenthesis is the finish of an expression
					// so just pop the stack until an open parenthesis is found
					char top = operatorStack.pop();
					while(top != '(' ) {
						postfix += (top + " ");
						top = operatorStack.pop();
					}
					break;
				default:
					throw new IllegalArgumentException("invalid operator in infix expression");
						
				}
			}
		}

		// anything left in the stack, pop it

		while (!operatorStack.isEmpty()) {
			char top = operatorStack.pop();
			postfix += (" " + top);
		}

		// clean up the output string, replacing multiple whitespace with single
		
		return postfix.replaceAll("\\s+", " ").trim();
	}

	/**
	 * Evaluate the postfix expression, and return the result
	 * @param postfix
	 * @return
	 */
	public static int evalPostfix(String postfix) {
		// split input string into tokens removing all whitespace
		String tokens[] = postfix.split("\\s+");
		
//		Stack<Integer> valuesStack = new Stack<Integer>();
		
		 StackInterface<Integer> valuesStack = new ArrayStack<>();
//		 StackInterface<Integer> valuesStack = new LinkedStack<>();
//		 StackInterface<Integer> valuesStack = new VectorStack<>();
		 
//		 StackInterface<Integer> valuesStack = new CompletedArrayStack<>();
//		 StackInterface<Integer> valuesStack = new CompletedLinkedStack<>();
//		 StackInterface<Integer> valuesStack = new CompletedVectorStack<>();			
		

		for (String token : tokens) {
			char c = token.charAt(0);
			// if a number, push it onto value stack
			
			// should really use parse and catch exception here

			if (Character.isDigit(c)) {
				valuesStack.push(Integer.parseInt(token));
			} else {

				// it is an operator, so pop the values,
				// perform the operation, and push the result back
				// on the stack

				Integer rightValue = valuesStack.pop();
				Integer leftValue = valuesStack.pop();
				
				Integer result;

				switch (c) {
				case '+':
					result = leftValue + rightValue;
					break;
				case '-':
					result = leftValue - rightValue;
					break;
				case '*':
					result = leftValue * rightValue;
					break;
				case '/':
					result = leftValue / rightValue;
					break;
				case '^':
					result = (int) Math.pow(leftValue, rightValue);
					break;
				default:
					throw new IllegalArgumentException("invalid postfix expression to evaluate");
				}

				valuesStack.push(result);
			}
		}

		// the last entry is the result
		// if the stack is not empty, there is something wrong with the postfix

		Integer result = valuesStack.pop();
		if (!valuesStack.isEmpty()) {
			throw new IllegalArgumentException("invalid postfix expression to evaluate");
		}

		return result;
	}

}
