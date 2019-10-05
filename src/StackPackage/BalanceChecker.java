package StackPackage;

import java.util.Stack; // use the library Stack instead of our interface

/**
 * A class that checks whether the parentheses, brackets, and braces in a string
 * occur in left/right pairs.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */

public class BalanceChecker {
	/**
	 * Decides whether the parentheses, brackets, and braces in a string occur in
	 * left/right pairs.
	 * 
	 * @param expression A string to be checked.
	 * @return True if the delimiters are paired correctly.
	 */
	public static boolean checkBalance(String expression) {
		// We will use the standard Stack class here
		 Stack<Character> openDelimiterStack = new Stack<Character>();
		
		// But use the following and comment out the above after implementations are done
//		 StackInterface<Character> openDelimiterStack = new ArrayStack<>();
//		 StackInterface<Character> openDelimiterStack = new LinkedStack<>();
//		 StackInterface<Character> openDelimiterStack = new VectorStack<>();
		 
//		 StackInterface<Character> openDelimiterStack = new CompletedArrayStack<>();
//		 StackInterface<Character> openDelimiterStack = new CompletedLinkedStack<>();
//		 StackInterface<Character> openDelimiterStack = new CompletedVectorStack<>();		 
		
		boolean isBalanced = true; // assume it is balanced to start

		// this can be done simpler with a for loop
		// continue as long as it is balanced and we have characters in the expression
		
		for(int i = 0; isBalanced && (i < expression.length()); i++) {
			char c = expression.charAt(i); // get the character
			switch (c) {
			case '(':
			case '[':
			case '{':
				// it is an opening symbol
				openDelimiterStack.push(c);
				break;
			case ')':
			case ']':
			case '}':
				// it is a closing symbol
				// did we already see the opening one?
				if (openDelimiterStack.isEmpty())
					isBalanced = false;
				else {
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, c);
				} // end if
				break;
			default:
				break; // Ignore unexpected characters
			} 		
		}

		// if the stack still has elements left, it is unbalanced!

		if (!openDelimiterStack.isEmpty())
			isBalanced = false;

		return isBalanced;
	} 

	/**
	 * Returns true if the given characters, open and close, 
	 * form a pair of parentheses, brackets, or braces.
	 * @param open first character
	 * @param close second character
	 * @return
	 */
	private static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')') || 
				(open == '[' && close == ']') || 
				(open == '{' && close == '}');
	}
}
