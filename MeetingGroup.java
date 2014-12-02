package edu.uoc.prac;

import java.util.ArrayList;

/**
 * Group which contain the user, meeting and places.
 * @author Oscar Cuellas Cuellaas
 *
 */

public class MeetingGroup {

  private String name;
  
  private Assignment assignment;

  private ArrayList<Meeting> meetings;
 
  private ArrayList<Place> places;
  
  private ArrayList<User> members; 
  
  private ArrayList<User> coorganizers;
 

    /**
     * Constructor
     * @param name type of String
     * @param assignment type of Assignment     
     */

    public MeetingGroup(String name, Assignment assignment){
    	this.name=name;
    	this.assignment = assignment;
    	assignment.addMeetingGroup(this);
	
    } 
    /**
     * Constructor
     * @param name type of String   
     */
    public MeetingGroup(String name){
    	this.name=name;
	
    }  

    public String getName(){
    	return name;
    }
 
    public void addMember(User u){
		if (u!=null){
		    if (members.contains(u)){
			System.out.println("Member already in MeetingGroup. Info User: "+u);
		    }
		    else{
			members.add(u);
			System.out.println("New User added.");
		    }
		}
		else{
		    System.out.println("Member null not allowed. Check User inicialization. ");
		    }
	}
    public void addMeeting(Meeting u){	
		if (u!=null){
		    if (meetings.contains(u)){
			System.out.println("Meeting already in Meeting Group. Not added. "+u.getDescription());
		    }
		    else{
			meetings.add(u);
			System.out.println("New Meeting added");
		    }
		}
    }
    /**
     * Getter of coorganizers
     * @return coorganizers type of ArrayList<User>
     */
    public ArrayList<User> getCoorganizator(){
    	return coorganizers;
    }
    /**
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString(){
		StringBuilder sb = new StringBuilder();
		if (this!=null){	    
		    sb.append("Meeting group info -------------------------------------------- Name: "+this.name);
		    sb.append("Users info: ");
		    for (User u:members){
			sb.append(u);
		    }
		    sb.append("Meetings info ------- ");
		    for (Meeting u:meetings){
			sb.append(u);
		    }
		}
		return sb.toString();
    }
    /**
     * Getter of Assignment
     * @return assignment type of Assignment
     */
    
	public Assignment getAssignment() {
		return this.assignment;
	}
	/**
	 * Getter of members
	 * @return members type of ArrayList<User>
	 */
	public ArrayList<User> getMembers() {
		
		return this.members;
	}
	/**
	 * Add a coorganizer to the meeting group
	 * @param user type of User
	 */
	public void addCoorganizer(User user) {
		this.coorganizers.add(user);
	}
	/**
	 * List of coorganizers
	 */
	public void listCoorganizer() {
		if(this.coorganizers.isEmpty()){
			System.out.println("No coorganizer to show");
		}else{
			for(User u : this.coorganizers){
				System.out.println(" Email: "+u.getEmail()+"Pwd: "+u.getPassword());
			}
		}
		
	}
	/**
	 * List the organizers
	 */
	public void listOrganizer(){
		if(this.assignment.getOrganizer().equals(null)){
			System.out.println("No Organizer to show");
		}else{
			System.out.println(" Email: "+this.assignment.getOrganizer().getEmail()+"Pwd: "+this.assignment.getOrganizer().getPassword()+" phone: "+this.assignment.getOrganizer().getPhone());
		}
	}
	/**
	 * Getter of meeting
	 * @return meeting type of ArrayList<Meeting>
	 */
	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

      
}
