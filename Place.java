package edu.uoc.prac;

import java.util.ArrayList;

/**
 * Place where user can use to met toguether
 * @author Oscar Cuellas
 *
 */

public class Place {
 //attribute
  private String name;

  private String address;

  private String zone;

  private Boolean privateResidence;
  
  private Integer id; 

  private Country country; 

  private ArrayList<Meeting> meetings;

  //methods	
  /**
     * Constructor
     * @param name type of the String
     * @param address type of String
     * @param zone type of the String
     * @param privateResidence type of boolean
     * @param id type of Integer
     * @param country type of Country      
     */

    public Place(String name, String address, String zone, boolean privateResidence, Integer id, Country country){
		this.name=name;
		this.address=address;
		this.zone=zone;
		this.privateResidence=privateResidence;
		this.country=country;	
	
    }
    

	/**
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append("\nPlace Name: "+name+"\nAddress: "+address+"\nPrivate Residence: "+((privateResidence==false) ? "No":"Yes")+"\nCountry: "+country+"\n");	
	return sb.toString();
    }


}
