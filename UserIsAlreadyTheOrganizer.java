package edu.uoc.prac;
/**
 * Exception User is Already the organizer of the Meeting Group
 * @author Oscar Cuellas Cuellas
 *
 */
public class UserIsAlreadyTheOrganizer extends MeetingException {
	//error 6
	public UserIsAlreadyTheOrganizer() {
		super(USER_IS_ALREADY_THE_ORGANIZER);
	}

}
