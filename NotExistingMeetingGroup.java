package edu.uoc.prac;
/**
 * Exception no exit meeting group
 * @author Oscar cuellas cuellas
 *
 */
		
public class NotExistingMeetingGroup extends MeetingException {
	//error 5
	public NotExistingMeetingGroup() {
		super(NOT_EXISTING_MEETING_GROUP);
	}

}
