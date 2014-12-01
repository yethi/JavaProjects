package edu.uoc.prac;
import java.util.ArrayList;

/**
 * User of the system.
 * @author Oscar Cuellas Cuellas
 *
 */

public class User{


  private String email;

  private String password;

  private ArrayList<Answer> answers;

  private ArrayList<String> interested;


   /**
     * Constructor
     * @param email
     *        of the User     
     * @param password
     *        of the User           
     */

    public User(String email, String password){
    	this.email=email;
    	this.password=password;
    }
   /**
    * Getter for email
    * @return email type of String
    */
   public String getEmail(){
	   return this.email;
   }
   /**
    * Getter for password
    * @return password type of String
    */
   public String getPassword(){
	   return this.password;
   }
   /**
    * list the interested of user
    */
   public void listInterests(){
	   if(interested.isEmpty()){
		   System.out.println("Not aviable interest for this User");
	   }else{
		   for(String in : interested){
			   System.out.println(in); 
		   }
	   }
   }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(" email "+email+" password "+password);	
    	return sb.toString();
    }
    /**
     * Get number of interest
     * @return size of interested type of integer
     */
	public int getNumberInterest() {
		return this.interested.size();
	}
	/**
	 * Getter of Interested
	 * @return interested type of ArrayList<String>
	 */
	public ArrayList<String> getInterest() {
		return this.interested;
	}
	public void addInterest(String interest) {
		this.interested.add(interest);
		System.out.println("TODO");
		
	}

}
