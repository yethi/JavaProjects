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

  //private Country country; 
  
  private String country;

  private ArrayList<Meeting> meetings;
  
  private static int idPlace = 1;



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

    public Place(String name, String address, String zone, boolean privateResidence, String country){
		this.name=name;
		this.address=address;
		this.zone=zone;
		this.privateResidence=privateResidence;
		this.country=country;
		this.id = this.idPlace;
	
    }
    /**
     * Getter for name
     * @return name type of string
     */
    public String getName(){
    	return this.name;
    }
    /**
     * Getter for country
     * @return country type of string
     */
    public String getCountry(){
    	return this.country;
    }
	/**
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("Identifier: "+ id+" name: "+name+ " Address: "+address+" Zone: "+ zone+" Private residence: "+ ((privateResidence==false) ? "No":"Yes")+ " Country: "+ country); 
    	return sb.toString();
    }
    /**
     * Increment the Id.
     */
    public static void newIdPlace(){
    	idPlace++;
    }
    /**
     * Getter of Id
     * @return id type of Integer
     */
	public Integer getId(){
		return this.id;
	}


}
