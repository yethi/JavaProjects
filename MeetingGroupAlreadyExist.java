package edu.uoc.prac;

/**
 * Exception for meeting group already exist
 * @author Oscar Cuellas
 *
 */

public class MeetingGroupAlreadyExist extends MeetingException {
	//error 2
	public MeetingGroupAlreadyExist(){
		super(MEETING_GROUP_ALREADY_EXISTS);
	}
}
