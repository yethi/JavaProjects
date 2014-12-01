package edu.uoc.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Main class, which manager the program.
 * @author Oscar Cuellas Cuellas 
 *
 */

public class MeetingManager {

    private ArrayList<User> users;
    private ArrayList<Meeting> meetings;
    private ArrayList<MeetingGroup> meetingGroups;    
    private ArrayList<Answer> answers;
    private ArrayList<Place> places;
    
    /**
     * Constructor   
     */

    public MeetingManager(){	
    }
    
  
    /**
     * 1. Add a new user to the system
     * @param email type of string
     * @param password type of string
     * @return user type of user
     */
    public  User addUser (String email, String password) throws MeetingException {
    	User u=null;
    	if(this.isUserInArrayLisyOfUsers(email, password, users)){
    			throw new UserAlreadyExists();
    	}else{	
    			u = new User(email,password);
    			users.add(u);
    			System.out.println("+ New user:"+u.getEmail()+" pwd:"+u.getPassword());
    	}
    	return u;
    }
    /**
     * 2. List the  user in the MeetingManager, include .
     */
    public void listUser(){
    	
    	if(users.isEmpty()){
    		System.out.println("No existing Users yet");
    	}else{
    		System.out.println("Meeting Manager Users:");
    		for(User u : users){
    			System.out.println("*"+u.toString());
    			u.listInterests();
    		}
    	}
    }
    /**
     * 3. Create a meeting group at same time that assignment a organizator 
     * @param meetingGroup type of MeetingGroup
     * @param email type of String
     * @param password type of String
     * @param phone type of string
     * @return meetingGroup type of meeting Group
     */
    public MeetingGroup addMeetingGroup(String meetingGroup,String email, String password, String phone) throws MeetingException{
    	MeetingGroup mG = null;
    	//Does coordinator in meetingManager?
    	if(this.isUserInArrayLisyOfUsers(email, password, users)){
    			throw new NotExistingUserCoordinator();
    	}else{
    			//Does MeetingGroup exit yet?
        		if(this.isMeetingGroupInArrayListMG(meetingGroup, meetingGroups)){
        				throw new MeetingGroupAlreadyExist();
        		}else{
        			Organizer organizer = new Organizer(email, password, phone);
        			Assignment assignment = new Assignment(fixedFee, percentage, organizer);
        			mG = new MeetingGroup(meetingGroup, assignment);
        			meetingGroups.add(mG);
        
        	}	
    	}
    	return mG;
    }
    /**
     * 4. Add a coorganizer to the meeting group
     * @param meetingGroup type of MeetingGroup
     * @param email type of string
     * @param password type of string
     * @return meetingGroup type of MeetingGroup
     */
    public MeetingGroup addCoorganizer(MeetingGroup meetingGroup, String email, String password) throws MeetingException {
    	//Does user include in MeetingManager
    	if(this.isUserInArrayLisyOfUsers(email, password, users)){
    		throw new NotExistingUserCoordinator();
    	//Is member include in MeetingGroup?
    	}else if(this.isUserInArrayLisyOfUsers(email, password, meetingGroup.getMembers())){
    		throw new NotExistingUserMember();
    	//MeetingGroup exit?
    	}else if(meetingGroups.contains(meetingGroup)==false){
    		throw new NotExistingMeetingGroup();
    	}else if(meetingGroup.getAssignment().getOrganizer().getEmail().equals(email) &&
    			meetingGroup.getAssignment().getOrganizer().getPassword().equals(password)){
    		//Is user a organizer? error 6
    		throw new UserIsAlreadyTheOrganizer();
    	}else if(this.isUserInArrayLisyOfUsers(email, password, meetingGroup.getCoorganizator())){
    		throw new UserIsAlreadyACoorganizer();
    	}else{
    		meetingGroup.addCoorganizer(new User(email,password));
    	}			
    	return meetingGroup;
    }
    /**
     * 5. Add a member in a meeting group
     * @param nombreMeetingGroup type of String
     * @param email type of String
     * @param password type of String
     * @return type of meeting group
     */
    public MeetingGroup addMember(String nameMeetingGroup, String email,String password) throws MeetingException{
    	
    	if(this.isMeetingGroupInArrayListMG(nameMeetingGroup, meetingGroups)){
    		throw new NotExistingMeetingGroup();
    	}else if(this.isUserInArrayLisyOfUsers(email, password, users)){
    		throw new UserNotFound();
    	}else if(this.isUserInArrayLisyOfUsers(email, password,this.getMeetingGroup(nameMeetingGroup).getMembers())){
    		throw new UserIsAlreadyAMember();
    	}else if(this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getEmail().equals(email) &&
    			this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getPassword().equals(password)){
    		throw new UserIsAlreadyTheOrganizer();
    	}else if(this.isUserInArrayLisyOfUsers(email, password, this.getMeetingGroup(nameMeetingGroup).getCoorganizator())){
    		throw new UserIsAlreadyACoorganizer();
    	}else{
    		this.getMeetingGroup(nameMeetingGroup).addMember(new User(email,password));
    	}
    	return this.getMeetingGroup(nameMeetingGroup);
    }
    /**
     * 6. List all the info about one meeting group
     * @param nameMeetingGroup type of String
     */
    public void listAll(String nameMeetingGroup){
    	ArrayList<User> usersMG = this.getMeetingGroup(nameMeetingGroup).getMembers();
    	int i = this.getMeetingGroup(nameMeetingGroup).getMembers().size();
    	
    	if(i ==0){
    		while(i > 0){
    			User userPrimero = this.getMeetingGroup(nameMeetingGroup).getMembers().get(i);
    			for(User u : usersMG){
    				if(u.getEmail().compareToIgnoreCase(userPrimero.getEmail())<0){
    					userPrimero = u;
    				}
    			}
    			System.out.println(userPrimero.toString());
    			usersMG.remove(userPrimero);
    			i = this.getMeetingGroup(nameMeetingGroup).getMembers().size(); 
    		}
    	}else{
    		System.out.println("No User to show");
    	}
    	this.getMeetingGroup(nameMeetingGroup).listCoorganizer();
    	this.getMeetingGroup(nameMeetingGroup).listOrganizer();
    }
    /**
     * 7. Add a new interest to one User
     * @param email type of String
     * @param password type of String
     * @param interest type of string (Interest)
     * @return user type of User
     */
    public User addInterest(String email,String password, String interest) throws MeetingException{
    	if(this.isUserInArrayLisyOfUsers(email, password, users)){
    		throw new UserNotFound();
    	//IF there are more than 5 interest or one is yet count	
    	}else if((this.getUserFromUsersBy(email, password).getNumberInterest() >=5)||
    			(this.getUserFromUsersBy(email, password).getInterest().contains(interest))){
    		throw new MaximunNumberOfInterestPerUser();
    	}else{
    		this.getUserFromUsersBy(email, password).addInterest(interest);
    	}
    	return null;
    }
    /**
     * 8. List the meeting Group which are interesting for a user.
     * @param email type of string
     * @param password type of String
     */
    public void searchMeeting(String email, String password) throws MeetingException{
    	
    }
    
    
    /**
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString(){
	StringBuilder sb = new StringBuilder();	
	return sb.toString();
    }
    
    /**
     * Check if user in include yet in Meeting Manager
     * @param email type of string
     * @param password type of String
     * @param userss type of ArrayList<User>
     * @return type of Boolean
     */
    public boolean isUserInArrayLisyOfUsers( String email,String password, ArrayList<User> userss){
    	boolean isInsideMM = false;
    	for(User u : userss){
    		if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
    			isInsideMM = true;
    		}
    	}
    	return isInsideMM;
    }
    /**
     * Check if meeting group is include in a Meeting group arraylist
     * @param nameObject type of String
     * @param arrayList type of ArrayList<MeetingGroup>
     * @return isInsideAl type of boolean
     */
    public boolean isMeetingGroupInArrayListMG(String nameObject, ArrayList<MeetingGroup> arrayList){
    	boolean isInsideAL = false;
    	for(MeetingGroup mG : arrayList){
			//Does MeetingGroup exit yet?
    		if(mG.getName().equals(nameObject)){
    			isInsideAL = true;
    		}
    	}	
    	return isInsideAL;
    }
    /**
     * Get the Meeting Group with the name given
     * @param nameMeetingGroup type of String
     * @return Mg type of MeetingGroup
     */
    public MeetingGroup getMeetingGroup(String nameMeetingGroup){
    	MeetingGroup Mg = null;
    	for(MeetingGroup mG : meetingGroups){
    		if(mG.getName().equals(nameMeetingGroup)){
    			Mg=mG;
    		}
    	}
    	return Mg;
    }
    /**
     * Getter of user in users
     * @param email type of String
     * @param password type of String
     * @return user type of User
     */
    public User getUserFromUsersBy(String email, String password){
    	User user=null;
    	for(User u : users ){
    		if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
    			user = u;
    		}
    	}
    	return user;
    }

}
