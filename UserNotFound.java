package edu.uoc.prac;

/**
 * User no found in Meeting group
 * @author OscarPC
 *
 */

public class UserNotFound extends MeetingException{
	//error 17
	public UserNotFound() {
		super(USER_NOT_FOUND);
	}

}
