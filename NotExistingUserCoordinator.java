package edu.uoc.prac;
/**
 * Exception not esiting user coordinator
 * @author Oscar Cuellas Cuellas
 *
 */

public class NotExistingUserCoordinator extends MeetingException {
	//error 3
	public NotExistingUserCoordinator(){
		super(NOT_EXISTING_USER_COORDINATOR);
	}
}
