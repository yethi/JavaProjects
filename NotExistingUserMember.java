package edu.uoc.prac;
/**
 * Excpetion not existing user member in meeting manager 
 * @author Oscar Cuellas Cuellas
 *
 */
public class NotExistingUserMember extends MeetingException {
	//Error 4
	public NotExistingUserMember() {
		super(NOT_EXISTING_USER_MEMBER);
	}

}
