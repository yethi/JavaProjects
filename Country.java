package edu.uoc.prac;
import java.util.ArrayList;



/**
 * Sve the value of one country.
 * @author Oscar Cuellas
 *
 */

public class Country {

  private String name;


  /**
     * Constructor
     * @param name
     *        of the Country    
     */

    public Country(String name){
	this.name=name;
    }

    /**
     * Getter of Name
     * @return name type of String
     */
    public String getName() {
    	return this.name;
    }

    /**
     * Setter of Name
     * @param name type of String
     */
    public void setName(String name) {
    	this.name = name;
    }
    
   


}
