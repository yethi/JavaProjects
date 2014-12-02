package edu.uoc.prac;

import java.util.ArrayList;

public class Organizer extends User {
	//attribute
	private String phone;
	private ArrayList<Assignment> assignments;
	
	//method
	/**
	 * Constructor
	 * @param email type of string
	 * @param password type of string
	 * @param phone type of string
	 */
	public Organizer(String email, String password, String phone) {
		super((String) email,(String) password);
		this.phone = phone;
		
	}
	/**
	 * add a new assignment to a one organizator
	 * @param assignment
	 */
	public void addAssignments(Assignment assignment){
		try{
			for(Assignment a : assignments){
				if(a.getFixedFee().equals(assignment.getFixedFee())&&a.getPercentage().equals(assignment.getPercentage())){
					throw new DuplicateAssignment();
				}else{
					assignments.add(assignment);
				}
			}
		}catch(Exception e){
			 System.out.println(e.getMessage());
		}
	}
	/**
	 * Getter for phone
	 * @return phone type of string
	 */
	public String getPhone() {
		// TODO Auto-generated method stub
		return this.phone;
	}
}
