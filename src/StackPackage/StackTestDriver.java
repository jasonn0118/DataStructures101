package StackPackage;

import java.util.Stack;

/**
 * A driver that demonstrates the class VectorStack.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Added test of java library Stack.
 * Created display methods for Stack and StackInterface using
 * toArray() and size()
 */
public class StackTestDriver {
	public static void main(String[] args) {

		System.out.println("Creating a stack");

		// Uncomment out one of the following to test your implementation

		// test To-be-done versions
		StackInterface<String> myStack = new VectorStack<>();
//		StackInterface<String> myStack = new ArrayStack<>();
//		StackInterface<String> myStack = new LinkedStack<>();

		// comment this out to test use of java library Stack class
		// note this will throw an exception for peek() pop()
		// on an empty stack
//		Stack<String> myStack = new Stack<>();

		// test completed versions 
//		StackInterface<String> myStack = new CompletedVectorStack<>();
//		StackInterface<String> myStack = new CompletedLinkedStack<>();
//		StackInterface<String> myStack = new CompletedArrayStack<>();

		System.out.println("isEmpty() returns " + myStack.isEmpty() + 
				" size " + myStack.size());

		System.out.println("Adding Joe Jane Jill Jess Jim to stack");
		myStack.push("Jim");
		myStack.push("Jess");
		myStack.push("Jill");
		myStack.push("Jane");
		myStack.push("Joe");
		
		displayStack(myStack);

		System.out.println("isEmpty() returns " + myStack.isEmpty());

		System.out.println("Testing peek and pop:");
		while (!myStack.isEmpty()) {
			String top = myStack.peek();
			System.out.println(top + " is at the top of the stack.");

			top = myStack.pop();
			System.out.println(top + " is removed from the stack.");
		}

		System.out.print("The stack should be empty: ");
		System.out.println("isEmpty() returns " + myStack.isEmpty());

		System.out.println("Adding Jim Jess Joe");
		myStack.push("Joe");
		myStack.push("Jess");
		myStack.push("Jim");

		displayStack(myStack);
		System.out.println("Testing clear:");
		myStack.clear();

		System.out.println("The stack should be empty: ");
		System.out.println("isEmpty() returns " + myStack.isEmpty());

		System.out.println("peek() should return null");
		
		if(myStack.peek() == null)
			System.out.println("peek() returned null");
		else System.out.println("peek() did not return null");
		
		System.out.println("pop() should return null");
		if(myStack.pop() == null)
			System.out.println("pop() returned null");
		else System.out.println("pop() did not return null");
	} 
	
	/**
	 * Display the stack using StackInterface
	 * @param stack StackInterface object
	 */
	static <T> void displayStack(StackInterface<T> stack) {
		T[] stackEntries = stack.toArray();
		displayStack(stackEntries, stack.size());
	}
	
	/**
	 * Display the stack from the standard Java library
	 * @param stack Stack object
	 */
	static <T> void displayStack(Stack<T> stack) {
		@SuppressWarnings("unchecked")
		T[] stackEntries = (T[]) stack.toArray();
		
		displayStack(stackEntries, stack.size());
	}

	static <T> void displayStack(T[] stack, int size) {		
		System.out.println("displayStack() size " + size);
		for(int index = 0; index < size; index++)
			System.out.print(" " + stack[index]);
		System.out.println();		
	
	}
}

/*
Creating a stack
isEmpty() returns true size 0
Adding Joe Jane Jill Jess Jim to stack
displayStack() size 5
 Jim Jess Jill Jane Joe
isEmpty() returns false
Testing peek and pop:
Joe is at the top of the stack.
Joe is removed from the stack.
Jane is at the top of the stack.
Jane is removed from the stack.
Jill is at the top of the stack.
Jill is removed from the stack.
Jess is at the top of the stack.
Jess is removed from the stack.
Jim is at the top of the stack.
Jim is removed from the stack.
The stack should be empty: isEmpty() returns true
Adding Jim Jess Joe
displayStack() size 3
 Joe Jess Jim
Testing clear:
The stack should be empty: 
isEmpty() returns true
peek() should return null
peek() returned null
pop() should return null
pop() returned null

*/
