package QueueDemoPackage;

import java.util.PriorityQueue;
import java.sql.Date;

/**
 * A class that represents a log of assignments ordered by priority.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * Added display method
 */
public class AssignmentLogUsingLibraryPQ {

	// Use java library PQ for the log
	private PriorityQueue<Assignment> log;

	/**
	 * Create a new Assignment log
	 */
	public AssignmentLogUsingLibraryPQ() {
		log = new PriorityQueue<>();
	} 

	/**
	 * Add an assignment to the log
	 * @param newAssignment
	 */
	public void addProject(Assignment newAssignment) {
		log.offer(newAssignment);
	} 

	/**
	 * Add a new assignment from course code, task, and due date
	 * @param courseCode
	 * @param task
	 * @param dueDate
	 */
	public void addProject(String courseCode, String task, Date dueDate) {
		Assignment newAssignment = new Assignment(courseCode, task, dueDate);
		addProject(newAssignment);
	} 

	/**
	 * Get the next assignment to be done according to priority
	 * @return
	 */
	public Assignment getNextProject() {
		return log.peek();
	} 

	/**
	 * Remove the top priority project from the queue
	 * @return assignment
	 */
	public Assignment removeNextProject() {
		return log.poll();
	} 

	/**
	 * Get the number of assignments in the queue
	 * @return
	 */
	public int getNumberOfAssignments() {
		return log.size();
	}
	
	/**
	 * Display all assignments in the queue
	 */
	public void displayAssignments() {
		
		// this allows toArray() to determine type without giving size
		
		Assignment[] assignments = log.toArray(new Assignment[0]);
		
		System.out.println("Assignment log");
		for(Assignment assignment : assignments)
			System.out.println(assignment);
		System.out.println();

	}
} 
