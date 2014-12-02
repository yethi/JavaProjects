
package edu.uoc.prac;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @author DPOO
 *
 */

public class Meeting {

  private String description;

  private Date date;

  private boolean isDraft;

  private int attendeeLimit;

  private int waitList;

  private int guestsPerMember;

  private int attendeeTotal;

  private Place place;

  private ArrayList<Answer> answers;

  /**
     * Constructor
     * @param description type of String
     * @param date type of Date
     * @param isDraft type of boolean  
     * @param attendeeLimit type of integer  
     * @param waitList
     *        of the Meeting    
     * @param guestsPerMember
     *        of the Meeting    
     * @param rvspStart
     *        of the Meeting    
     * @param rvspEnd
     *        of the Meeting    
     * @param attendeeTotal
     *        of the Meeting    
     * @param meetingGroup
     *        of the Meeting    
     * @param place
     *        of the Meeting    
     * @param repetitionPattern
     *        of the Meeting    
     */

    public Meeting(String description, Date date, boolean isDraft, int attendeeLimit, int waitList, int guestsPerMember, int attendeeTotal,  Place place){
		this.description=description;
		this.date=date;	
		this.isDraft=isDraft;
		this.attendeeLimit=attendeeLimit;
		this.waitList=waitList;
		this.guestsPerMember=guestsPerMember;
		this.attendeeTotal=attendeeTotal;
		this.place=place;
		
    }
    /**
     * Construction 2
     * @param description type of String
     * @param isDraft type of boolean
     * @param attendeeLimit type of Integer
     * @param waitList type of Integer
     * @param guestsPerMember type of Integer
     * @param attendeeTotal type of Integer
     * @param place type of Place
     */
    public Meeting(String description, boolean isDraft, int attendeeLimit, int waitList, int guestsPerMember, int attendeeTotal,  Place place){
		this.description=description;
		this.isDraft=isDraft;
		this.attendeeLimit=attendeeLimit;
		this.waitList=waitList;
		this.guestsPerMember=guestsPerMember;
		this.attendeeTotal=attendeeTotal;
		this.place=place;
		
    }
    /**
     * Getter for description
     * @return description type of String
     */
    public String getDescription(){
	return description;
    }
    
    /**
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append("Description: "+description+"\nWhen? "+date+"\nDraft? "+((isDraft==false)?"No":"Yes")+"\nMaximum attendance Limit? "+((attendeeLimit==0)?true:false)+"\nAvailable waiting list? "+((waitList==1)?true:false)+"\nNumber of guests per Member: "+guestsPerMember+ "\nExpected attendeeTotal (no anwers computed) "+attendeeLimit+" "+place+"\n");	
	return sb.toString();
    }

  
}
