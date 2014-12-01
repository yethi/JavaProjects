package edu.uoc.prac;
/**
 * Interest of the user.
 * @author OscarPC
 *
 */

public class Interest {
	//attribute
	private String interest;
	
	//Method
	/**
	 * Constructor 
	 * @param interest type of String
	 */
	public Interest(String interest){
		this.interest = interest;
	}
	
	/**
	 * Getter of Interest
	 * @return interest type of String
	 */
	public String getInterest() {
		return this.interest;
	}
	/**
	 * Setter of Interest
	 * @param interest type of String
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	

}
