package edu.uoc.prac;
/**
 * Exception with user
 * @author OscarPC
 *
 */
public class UserAlreadyExists extends MeetingException {
	//error 1
	public UserAlreadyExists(){
		super(USER_ALREADY_EXISTS);
	}
}
