package edu.uoc.prac;

/**
 * 
 * @author DPOO
 *
 */
public class MeetingException extends Exception {

    private static final long serialVersionUID = -3643037098544095876L;
	
    /** causes */
    public static final String USER_ALREADY_EXISTS = "User already exists"; // error 1
    public static final String MEETING_GROUP_ALREADY_EXISTS = "Meeting Group already exists"; //error 2
    public static final String NOT_EXISTING_USER_COORDINATOR = "The coordinator of the Meeting Group is not an exisiting User"; //error 3
    public static final String NOT_EXISTING_USER_MEMBER = "To be a member of a Meeting Group requires to be an existing user of the Meeting Manager. Check addUser."; //error 4
    public static final String NOT_EXISTING_MEETING_GROUP="The requested Meeting Group does not exists"; //error 5
    public static final String USER_IS_ALREADY_THE_ORGANIZER="The requested User is already the organizer. Not added to coorganizers list"; //error 6
    public static final String USER_IS_ALREADY_A_COORGANIZER="The requested User is already a coorganizer.";//error 7
    public static final String DUPLICATE_ASSIGNMENT="Duplicate Assignment";//error 8
    public static final String USER_IS_ALREADY_A_MEMBER="User is already a member of the meeting group";//error 9
    public static final String MAXIMUM_NUMBER_OF_INTERESTS_PER_USER="Maximum number of interests per user exceeded or duplicated user interest";//error 10
    public static final String PLACE_ALREADY_EXISTS="Already existing place in the same country. Not added";//error 11
    public static final String PLACE_NOT_FOUND="Place not found in Meeting Manager";//error 12
    public static final String MEETING_GROUP_NOT_FOUND="Meeting Group not found in Meeting Manager";//error 13

    public static final String PLACE_ALREADY_IN_MEETING_GROUP="Place already in Meeting Group";//error 14
    public static final String MEETING_ALREADY_IN_GROUP="Meeting with same description in Meeting Group. Not added.";//error 15
    public static final String MEETING_NOT_FOUND="Meeting not found in Meeting Manager";//error 16
    public static final String USER_NOT_FOUND="User not found in Meeting Manager";//error 17
    public static final String USER_NOT_FOUND_IN_MG="User not found as member neither coorganizer nor Organizer of the Meeting Group that organizes the meeting";//error 18
    public static final String ANSWER_ALREADY_FOUND_FOR_USER_MEETING="The User has already answered Meeting Attending";//error 19
    public static final String ANSWER_EXCEEDS_GUESTS_PER_MEETING="The number of guests exceeds the allowed number of guests for meeting";//error 20
    public static final String THE_MEETING_IS_FULL="The meeting is full.";////error 21
    public static final String NO_MEETING_OR_NO_ANSWERS="No existing Meeting or not Answers related to meeting yet";//error 22

    /**
     * 
     * @param cause
     */
    public MeetingException (String cause) {
	super (cause);
    }
}
