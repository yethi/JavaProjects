package edu.uoc.prac;
/**
 * Place already exist in meeting group
 * @author Oscar Cuellas Cuellas
 *
 */
public class PlaceAlreadyExist extends MeetingException{
	//Error 11
	public PlaceAlreadyExist() {
		super(PLACE_ALREADY_IN_MEETING_GROUP);
	}

}
