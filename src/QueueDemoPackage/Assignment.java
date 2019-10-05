package QueueDemoPackage;

import java.sql.Date;

/**
 * An assignment has a course, a task, and a due date.
 * Implements Comparable so that java library PQ can use it to insert
 * @author mhrybyk
 *
 */
public class Assignment implements Comparable<Assignment> {
	
	private String course; // course code
	private String task;   // task or assignment description
	private Date date;     // due date
	
	/**
	 * Create a new assignment from arguments
	 * @param newCourse
	 * @param newTask
	 * @param newDueDate
	 */
	Assignment(String newCourse, String newTask, Date newDueDate) {
		course = newCourse;
		task = newTask;
		date = newDueDate;
	}
	
	/**
	 * Get the course code
	 * @return
	 */
	public String getCourseCode() {
		return course;
	}
	
	/**
	 * Compare due dates for assignment. Sooner is better.
	 */
	@Override
	public int compareTo(Assignment other) {
		return date.compareTo(other.date);
	}

	/**
	 * Get the task
	 * @return
	 */
	public String getTask() {
		return task;
	}

	/**
	 * Get the due date
	 * @return
	 */
	public Date getDueDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "Assignment: " + course + " : " + task + " : " + date;
	}
}
