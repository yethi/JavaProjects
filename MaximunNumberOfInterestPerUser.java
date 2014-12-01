package edu.uoc.prac;
/**
 * Exception if user have more than 5 interest or one of then is ducplicate
 * @author Oscar Cuellas Cuellas
 *
 */

public class MaximunNumberOfInterestPerUser extends MeetingException  {
	//error 10
	public MaximunNumberOfInterestPerUser() {
		super(MAXIMUM_NUMBER_OF_INTERESTS_PER_USER);
	}

}
