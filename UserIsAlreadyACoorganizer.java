package edu.uoc.prac;

/**
 * Excpetion user is a coorganizer yet
 * @author OscarPC
 *
 */

public class UserIsAlreadyACoorganizer extends MeetingException {
	//error 7
	public UserIsAlreadyACoorganizer() {
		super(USER_IS_ALREADY_A_COORGANIZER);
	}

}
