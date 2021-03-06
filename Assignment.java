package edu.uoc.prac;

import java.util.ArrayList;

/**
 * who assignment each group with each organizator
 * @author OscarPC
 *
 */

public class Assignment {
	//attribute
	private Integer fixedFee;
	private double percentage;
	private Organizer organizer;
	
	private ArrayList<MeetingGroup> meetingGroups;
	
	
	public Assignment(Integer fixedFee, double percentage, Organizer organizer){
		this.fixedFee = fixedFee;
		this.percentage = percentage;
		this.organizer = organizer;
		this.meetingGroups = new ArrayList<MeetingGroup>();
	}
	/**
	 * Add a new meetingGroup for a one assignment
	 * @param meetingGroup type of MeetingGroup
	 */
	public void addMeetingGroup(MeetingGroup meetingGroup) {
		meetingGroups.add(meetingGroup);
		
	}
	/**
	 * Getter of FixedFee
	 * @return fixedFee type of Integer
	 */
	public Integer getFixedFee(){
		return this.fixedFee;
	}
	/**
	 * Getter of percentage
	 * @return percentage type of Integer
	 */
	public double getPercentage(){
		return this.percentage;
	}
	/**
	 * Getter of Organizer
	 * @return organizer type of Organizer
	 */
	public Organizer getOrganizer(){
		return this.organizer;
	}
	/**
	 * String conversor of values on
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Email:"+ organizer.getEmail()+" Pwd:"+organizer.getPassword()+" Phone:"+organizer.getPhone()+"\n");
		sb.append("Fixed Fee:"+ fixedFee+" Percentage: "+percentage+"\n");
		return sb.toString();
	}
}
