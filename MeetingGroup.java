package edu.uoc.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    	this.meetings = new ArrayList<Meeting>();
    	this.places = new ArrayList<Place>();
    	this.members = new ArrayList<User>();
    	this.coorganizers = new ArrayList<User>();
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
			meetings.add(u);
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
		    sb.append("\nInformation Meeting group Name: "+this.name);
		    sb.append("\n");
		    
		    if(members.isEmpty()){
		    	sb.append("\nNo members to show\n");
		    }else{
		    	sb.append("\nMeetingGroup Members in alphabetical email order\n");
		    	sb.append("\n");
		    	List<String> emails = new ArrayList<String>();
		    	for (User u: members){
		    		emails.add(u.getEmail());
		    	}
		    	Collections.sort(emails);
		    	for(String s : emails){
		    		for(User u : members){
		    			if(u.getEmail().equals(s)&&this.isMemberCoordinatorOfMeetingGroup(s)==false){
		    				sb.append(u.toString() + "\n");
		    				sb.append("\n");
		    				
		    			}
		    		}
		    	}
		    }		    
		    //coorganizers list
		    if(coorganizers.isEmpty()){
		    	
		    	sb.append("No coorganizers to show\n");
		    	sb.append("\n");
		    }else{
		    	sb.append("MeetingGroup Coorganizer in insertion order:\n");
		    	for (User u: coorganizers){
		    		sb.append(u + "\n");
		    	}
		    	sb.append("\n");
		    }
		    if(assignment.getOrganizer() == null){
		    	sb.append("No Organizers to show\n");
		    }else{
		    	sb.append("MeetingGroup Organizer Information \n");
		    	sb.append(assignment.toString());
		    	sb.append("\n");
		    }
		    if(places.isEmpty()){
    			sb.append("Not Place to show\n");
    			sb.append("\n");
    		
	    	}else{ 
	    		sb.append("List of available places------------------\n");
	    		for (Place p : places){
	    			sb.append(p +"\n");

	    		}
		    }
		    
		    if(meetings.isEmpty()){
		    	sb.append("\nNo Meetings to show\n");
		    	sb.append("\n");
		    }else{
		    	sb.append("MG Meetings Information------------------\n");
		    	for (Meeting m : meetings){
			    	sb.append(m.toString()+"\n");
			    }
		    	sb.append("\n");
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
	/**
	 * Exist this place in meetingGroup
	 * @param name type of String
	 * @return exist type of booelan
	 */
	
	public boolean existThisIdPlace(Integer identifierPlace){
		boolean exist= false;
		if(places.isEmpty()==false){
			for(Place p : places){
				if(p.getId().equals(identifierPlace)){
					exist = true;
				}
			}
		}
		return exist;
	}
	
	/**
	 * Exist this place in meetingGroup
	 * @param name type of String
	 * @return exist type of booelan
	 */
	
	public boolean existPlace(Integer idPlace){
		boolean exist= false;
		for(Place p: places){
			if(p.getId().equals(idPlace)){
				exist = true;
			}
		}
		return exist;
	}
	/**
	 * Add a new place in MeetingGroup
	 * @param place type of Place
	 */
	public void addPlace(Place place) {
		places.add(place);
	}
	/**
	 * Exist meeting on meeting Group
	 * @return exist type of Boolean
	 */
	public Boolean existMeeting(String description){
		boolean exist = false;
		for(Meeting m : meetings){
			if(m.getDescription().equals(description)){
				exist = true;
			}
		}
		return exist;
	}
	/**
	 * Ask to the meeting group about if one user is coorganizer or not
	 * @param email type of String
	 * @return isCoorganizer type of boolean
	 */
    public boolean isMemberCoordinatorOfMeetingGroup(String email){
    	boolean isCoorganizer = false;
    	for (User u : coorganizers ){
    		if(u.getEmail().equals(email)){
    			isCoorganizer = true;
    		}
    	}
    	return isCoorganizer;
    } 
    /**
     * Ask to meeting group about if one user is a organizer.
     * @param email type of String
     * @return isOrganizer type of boolean
     */
    public boolean isMemberOrganizerOfMeetingGroup(String email){
    	boolean isOrganizer = false;
    	if(assignment.getOrganizer().getEmail().equals(email)){
    		isOrganizer = true;
    	}
    	return isOrganizer;
    }
}
