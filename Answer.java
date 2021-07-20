package edu.uoc.prac;
import java.util.Date;

/**
 * 
 * Answer of one user about one meeting.
 * @author Oscar cuellas
 *  Cuellas
 *
 */

public class Answer {

  private Boolean attending;

  private Integer guests;

  private AttendingResult result;
 
  private Meeting meeting;

  private User user;

    /**
     * Constructor
     * @param attending type of boolean
     * @param guests type of integer
     * @param result type of AttendingResult
     * @param meeting type of Meeting
     * @param user type of User
     */

    public Answer( Boolean attending, Integer guests, AttendingResult result, Meeting meeting, User user){
	
	this.attending=attending;
	this.guests=guests;
	this.result=result;
	this.meeting=meeting;
	this.user=user;
    }
    
    /**
     * Getter of Attending
     * @return attending type of boolean
     */
    public Boolean getAttending() {
		return this.attending;
	}

    /**
     * Setter of Attending
     * @param attending type of boolean
     */
	public void setAttending(Boolean attending) {
		this.attending = attending;
	}
	/**
     * Getter of Guests
     * @return Guests type of Integer
     */

	public Integer getGuests() {
		return this.guests;
	}
	/**
     * Setter of Guests
     * @param guests type of Integer
     */

	public void setGuests(Integer guests) {
		this.guests = guests;
	}

	/**
     * Getter of Result
     * @return result type of AttendingResult
     */

	public AttendingResult getResult() {
		return this.result;
	}
	/**
     * Setter of Result
     * @param result type of AttendingResult
     */

	public void setResult(AttendingResult result) {
		this.result = result;
	}
	/**
     * Getter of Meeting
     * @return meeting type of Meeting
     */
	
	public Meeting getMeeting() {
		return this.meeting;
	}
	/**
     * Setter of Meeting
     * @param meeting type of Meeting
     */

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	/**
     * Getter of User
     * @return user type of User
     */

	public User getUser() {
		return user;
	}
	/**
     * Setter of User
     * @param user type of User
     */

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * String out to info in Answer
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		String results = new String();
		sb.append("\nUser information: "+user.toString()+"Guests Coming: "+guests+"\nAttending Result: "+result);
		sb.append("\nInformation Meeting :"+meeting.toString());
		return sb.toString();
	}
}
