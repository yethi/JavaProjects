package edu.uoc.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Main class, which manager the program.
 * @author Oscar Cuellas Cuellas 
 *
 */

public class MeetingManager {
	
	private final static int FIXED_FEE = 15;
	private final static double PERCENTAGE = 0.1;	
	
	private int fixedFee = FIXED_FEE;
	private double percentage = PERCENTAGE;
	
    private ArrayList<User> users;
    private ArrayList<Meeting> meetings;
    private ArrayList<MeetingGroup> meetingGroups;    
    private ArrayList<Answer> answers;
    private ArrayList<Place> places;
    
    /**
     * Constructor   
     */

    public MeetingManager(){
    	this.users = new ArrayList<User>();
    	this.meetings = new ArrayList<Meeting>();
    	this.meetingGroups = new ArrayList<MeetingGroup>();
    	this.answers = new ArrayList<Answer>();
    	this.places = new ArrayList<Place>();
    }
    
  
    /**
     * 1. Add a new user to the system
     * @param email type of string
     * @param password type of string
     * @return user type of user
     */
    public  User addUser (String email, String password) throws MeetingException {
    	User u=null;
    	if(this.isUserInArrayLisyOfUsers(email, users)){
    			throw new UserAlreadyExists();
    	}else{	
    			u = new User(email,password);
    			users.add(u);
    	}
    	return u;
    }
    /**
     * 2. List the  user in the MeetingManager, include .
     */
    public String listUsers(){
    	StringBuilder sb = new StringBuilder();
    	if(users.isEmpty()){
    		sb.append("No existing Users yet\n");
    	}else{
    		sb.append("Meeting Manager Users:\n");
    		for(User u : users){
    			sb.append("*"+u.getEmail()+" "+ u.getPassword()+" \n"+u.listInterests()+"\n");
    		}
    	}
    	return sb.toString();
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
    	if(this.isMeetingGroupInArrayListMG(meetingGroup, meetingGroups)){
    			 throw new MeetingGroupAlreadyExist();
    	}else if(this.isUserInArrayLisyOfUsers(email, users)==false){
    		throw new NotExistingUserCoordinator();
    			//Does MeetingGroup exit yet?
    	}else{
    		Organizer organizer = new Organizer(email, password, phone);
			Assignment assignment = new Assignment(this.fixedFee, this.percentage, organizer);
			mG = new MeetingGroup(meetingGroup, assignment);
			meetingGroups.add(mG);			
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
    public MeetingGroup addCoorganizer(String nameMeetingGroup, String email, String password) throws MeetingException {
    	//Does user include in MeetingManager
    	if(this.isUserInArrayLisyOfUsers(email, users)==false){
    		throw new NotExistingUserMember();
    	//MeetingGroup exit?
    	}else if(meetingGroups.contains(this.getMeetingGroup(nameMeetingGroup))==false){
    		throw new NotExistingMeetingGroup();
    	}else if(this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getEmail().equals(email) &&
    			this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getPassword().equals(password)){
    		//Is user a organizer? error 6
    		throw new UserIsAlreadyTheOrganizer();
    	}else if(this.isUserInArrayLisyOfUsers(email, this.getMeetingGroup(nameMeetingGroup).getCoorganizator())){
    		throw new UserIsAlreadyACoorganizer();
    	}else{
    		this.getMeetingGroup(nameMeetingGroup).addCoorganizer(new User(email,password));
    	}			
    	return this.getMeetingGroup(nameMeetingGroup);
    }
    /**
     * 5. Add a member in a meeting group
     * @param nombreMeetingGroup type of String
     * @param email type of String
     * @param password type of String
     * @return type of meeting group
     */
    public MeetingGroup addMember(String nameMeetingGroup, String email,String password) throws MeetingException{
    	
    	if(this.isMeetingGroupInArrayListMG(nameMeetingGroup, meetingGroups)==false){
    		throw new NotExistingMeetingGroup();
    	}else if(this.isUserInArrayLisyOfUsers(email, users)==false){
    		throw new UserNotFound();
    	}else if(this.isUserInArrayLisyOfUsers(email, this.getMeetingGroup(nameMeetingGroup).getCoorganizator())){
    		throw new UserIsAlreadyACoorganizer();
    	}else if(this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getEmail().equals(email) &&
    			this.getMeetingGroup(nameMeetingGroup).getAssignment().getOrganizer().getPassword().equals(password)){
    		throw new UserIsAlreadyTheOrganizer();
    	}else if(this.isUserInArrayLisyOfUsers(email, this.getMeetingGroup(nameMeetingGroup).getMembers())){
    		throw new UserIsAlreadyAMember();
    	}else{
    		this.getMeetingGroup(nameMeetingGroup).addMember(new User(email,password));
    	}
    	return this.getMeetingGroup(nameMeetingGroup);
    }
    /**
     * 6. List all the info about one meeting group
     * @param nameMeetingGroup type of String
     * @return Meetingroup type of MeetingGroup
     */

    public MeetingGroup listAll(String nameMeetingGroup) throws MeetingException{
    	MeetingGroup mG = null;
    	if(this.isMeetingGroupInArrayListMG(nameMeetingGroup, meetingGroups)==false){
    		throw new NotExistingMeetingGroup();
    	}else{
	    	mG = this.getMeetingGroup(nameMeetingGroup);
    	}
    	return mG;
    }
    /**
     * 7. Add a new interest to one User
     * @param email type of String
     * @param password type of String
     * @param interest type of string (Interest)
     * @return user type of User
     */
    public User addInterest(String email,String password, String interest) throws MeetingException{
    	User user = null;
    	if(this.isUserInArrayLisyOfUsers(email, users)==false){
    		throw new NotExistingUserMember();
    	//IF there are more than 5 interest or one is yet count	
    	}else if((this.getUserFromUsersBy(email, password).getNumberInterest() >=5)||
    			(this.getUserFromUsersBy(email, password).getInterest().contains(interest))){
    		throw new MaximunNumberOfInterestPerUser();
    	}else{
    		this.getUserFromUsersBy(email, password).addInterest(interest);
    		user = this.getUserFromUsersBy(email, password);
    	}
    	return user;
    }
    /**
     * 8. List the meeting Group which are interesting for a user.
     * @param email type of string
     * @param password type of String
     */
    public void searchMeeting(String email, String password) throws MeetingException{
    	if(this.isUserInArrayLisyOfUsers(email, users)){
    		User u = this.getUserFromUsersBy(email, password);
    		boolean hasInterest = false;
    		for(String s : u.getInterest()){
    			System.out.println("Checking interest ....."+s);
    			for(MeetingGroup mG : meetingGroups ){
    				for(Meeting m : mG.getMeetings()){
    					if(s.equals(m.getDescription())){
    						System.out.println("Maching MeeetingGroup"+ mG.getName()+" for interest "+s);
    					}
    					else{
    						System.out.println("No Matching meeting group for interest "+s);
    					}
    				}
    			}
    			
    		}
    		
    	}else{
    		throw new UserNotFound();
    	}
    }
    /**
     * 9. Add a place to Meeting manager
     * @param name type of string
     * @param addresstype of string
     * @param zone type of string
     * @param privateResident type of boolean
     * @param country type of Country
     * @return place type of place
     * @throws MeetingException
     */
    public Place addPlace(String name, String address, String zone, String privateResidence,String country) throws MeetingException{
    	Place place = null;
    	if(this.existCountryOrPlace(country, name)){
    		throw new PlaceAlreadyExist();
    	}else{
    		Place p = new Place(name, address, zone, (privateResidence.equals("yes"))?true:false, country);
    		p.newIdPlace();
    		places.add(p);
    	}
    	return place;
    }
    /**
     * 10. Assignment a place in a Meeting Group
     * @param identifierPlace type os string
     * @param nombreMeetingGroup type of string
     * @return mG type of MeetingGroup
     */
    public MeetingGroup assignPlaceMG(String identifierPlace,String nameMeetingGroup) throws MeetingException{
    	MeetingGroup mG=null;
    	if(this.isMeetingGroupInArrayListMG(nameMeetingGroup, meetingGroups)){
    		throw new MeetingGroupNotFound();
    	}else if(this.getMeetingGroup(nameMeetingGroup).existPlace(identifierPlace)){
    		throw new PlaceAlreadyInMeetingGroup();
    	}else if(places.contains(this.getPlace(identifierPlace))){
    		throw new PlaceNotFound();
    	}else{
    		this.getMeetingGroup(nameMeetingGroup).addPlace(this.getPlace(identifierPlace));
    		mG = this.getMeetingGroup(nameMeetingGroup);
    	}
    	return mG;
    }
    /**
     * 11. Add a new meeting in a exit meetingGroup
     * @param nameMeetingGroup type of String
     * @param idPlace type of String
     * @param description type of String
     * @param isDraft type of String
     * @param attendeeLimit type of String
     * @param waitList type of String
     * @param gestMember type of String
     * @param attendeeTotal type of String
     * @return mG type of MeetingGroup
     * @throws MeetingException
     */
    public MeetingGroup addMeetingMG(String nameMeetingGroup, String idPlace, String description,  String isDraft, String attendeeLimit,String waitList, String guestsPerMember, String attendeeTotal) throws MeetingException {
		MeetingGroup mG = null;
		if(this.isMeetingGroupInArrayListMG(nameMeetingGroup, meetingGroups)){
    		throw new MeetingGroupNotFound();
    	}else if(this.getMeetingGroup(nameMeetingGroup).existPlace(Integer.parseInt(idPlace))){
    		throw new PlaceAlreadyInMeetingGroup();
    	}else if(this.getMeetingGroup(nameMeetingGroup).existMeeting(description)){
    		throw new MeetingAlreadyInGroup();
    	}else{
    		this.getMeetingGroup(nameMeetingGroup).addMeeting(new Meeting(description,(Integer.parseInt(isDraft)==0)?true:false,Integer.parseInt(attendeeLimit),Integer.parseInt(waitList),Integer.parseInt(guestsPerMember), Integer.parseInt(attendeeTotal), this.getPlace(Integer.parseInt(idPlace))));
    		mG = this.getMeetingGroup(nameMeetingGroup);
    	}
		return mG;
	}
    /**
     * 12. Add a new answer to a meeting Manager
     * @param description type of String
     * @param email type of String
     * @param password type of String
     * @param guest type of String
     * @param result type of String
     * @return Answer type of Answer
     * @throws MeetingException
     */
    public Answer addAnswer(String description,String email, String password, String guest,String result) throws MeetingException{
    	Answer a = null;
    	
    	return a;
    }
    /**
     * 13. List answer for a meeting
     * @param Meeting type of String.
     */
    public void listMeetingAnswers(String nameMeeting){
    	
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
   private boolean isUserInArrayLisyOfUsers( String email, ArrayList<User> users){
    	boolean isInsideMM = false;
    		for(User u : users){
    			if(u.getEmail().equals(email)&&users.isEmpty()==false){
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
   private boolean isMeetingGroupInArrayListMG(String nameMeetingGroup, ArrayList<MeetingGroup> arrayList){
    	boolean isInsideAL = false;
    	for(MeetingGroup mG : arrayList){
			//Does MeetingGroup exit yet?
    		if(mG.getName().equals(nameMeetingGroup)&&arrayList.isEmpty()==false){
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
    private MeetingGroup getMeetingGroup(String nameMeetingGroup){
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
    private User getUserFromUsersBy(String email, String password){
    	User user=null;
    	for(User u : users ){
    		if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
    			user = u;
    		}
    	}
    	return user;
    }
   /**
    * figure out there are a place in that country
    * @param country type of String
    * @param name type of string
    * @return exist type of boolean
    */
    
    private boolean existCountryOrPlace(String country, String name){
    	boolean exist = false;
    	for(Place p : places){
    		if(p.getName().equals(name)&&p.getCountry().equals(country)){
    			exist = true;
    		}
    	}
    	return exist;
    }
    /**
     * Get place in places
     * @param identifierPlace type of String
     * @return place type of Place
     */
    private Place getPlace(String identifierPlace) {
		Place place = null;
		for(Place p: places ){
			if(p.getName().equals(identifierPlace)){
				place = p;
			}
		}
		return place;
	}
    /**
     * Get place in places
     * @param identifierPlace type of String
     * @return place type of Place
     */
    private Place getPlace(Integer idPlace) {
		Place place = null;
		for(Place p: places ){
			if(p.getId().equals(idPlace)){
				place = p;
			}
		}
		return place;
	}


	
}
