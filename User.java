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
    	this.interested = new ArrayList<String>();
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
   public String listInterests(){
	   StringBuilder sb = new StringBuilder();
	   if(interested.isEmpty()){
		   sb.append("Not available Interests for user yet\n");
	   }else{
		   sb.append("List of Interest\n");
		   for(String in : interested){
			   sb.append(in+" ");
		   }
		   sb.append("\n");
	   }
	   return sb.toString();
   }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(email+" "+password+"\n"+ this.listInterests());	
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
