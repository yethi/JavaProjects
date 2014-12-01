package edu.uoc.prac;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * <p>Main class for testing how the meeting schedule is Done.</p>
 *
 * <p>ONLY implement the needed part of each class. </p>
 * 
 * @author DPOO
 *
 */
public class Main {
	//Defino los metodos listMeetingGruops, listUser y ListMeetings en la clase MeetingGroup, de esta forma los puedo volver a usar
	//en el segundo metodo
	/**
	 * List of the meetings and member of each meeting Group save in the array
	 * @param meetingGroups type of ArrayList<MeetingGroup>
	 */
     private static void listMeeting(ArrayList<MeetingGroup> meetingGroups){
    	 	for(MeetingGroup m: meetingGroups){
        	 		 m.listMeetingGroup();
        	 		 m.listUser();
                     m.listMeetings();     
        	 	}
     }
     //Defino el metodo getMeetingGroupByName en MeetingManager, depeus solo cargo el array en el objeto.
     //Incluyo un try catch, para cuando no exita el grupo y se devuelva un valor nulo.
     /**
 	 * List of the meetings and member of the meeting Group with that name 
 	 * @param meetingGroups type of ArrayList<MeetingGroup>
 	 * @param name type of String
 	 */
    private static void listMeeting(String name, ArrayList<MeetingGroup> meetingGroups){
    	System.out.println("List for meetings with included name "+name);
    	try{	
    		MeetingManager mM = new MeetingManager();
    		mM.setArrayMeetingGroup(meetingGroups);
    		MeetingGroup mG = mM.getMeetingGroupByName(name);
    		mG.listMeetingGroup();
    		mG.listUser();
    		mG.listMeetings();
    		
    	}catch(Exception e){
    		System.out.println("No Meeting Group found with name "+name);
    	}	
    }
  //Defino el metodo addMeetingGroup en la clase meetingManager.
	//a sí solo hace falta cargar el array en un objeto de este tipo con el metotodo set, y depues usar el metodo anteriormente definido para 
	//añadir el objeto MeetingGroup 
    
    /**
     * Add a new group meeting in the Arraylist we are passing througth
     * @param m type od MeetingGroup
     * @param meetingGroups type of ArrayList<MeetingGroup>
     * @return ArrayList<MeetingGroup>
     */
    private static ArrayList<MeetingGroup> addMeetingGroup(MeetingGroup m, ArrayList<MeetingGroup> meetingGroups){
    	
    	MeetingManager mM = new MeetingManager();
    	mM.setArrayMeetingGroup(meetingGroups);
    	mM.addMeetingGroup(m);
    	return (ArrayList<MeetingGroup>) mM.getArrayMeetingGroup();
    	
    }
    private static final String NL=System.getProperty("line.separator");
 
	public static void main(String[] args) {
	    ArrayList<MeetingGroup> meetingGroups=new ArrayList<MeetingGroup>();
		// Create users
	    User u = new User ("johnLennon@gmail.com","123");
	    User j = new User ("Tommy@gmail.com","1234");
	    User z = null;
	
		// Create Meeting group
	    MeetingGroup n1 = new MeetingGroup("Basketball in BCN");	
	    
	    System.out.println("----Adding Member to Meeting Group----");
	    n1.addMember(u);
	
	    System.out.println("----Adding Duplicated Member to Meeting Group----");
	    n1.addMember(u);
	 
	    System.out.println("----Adding Member to Meeting Group----");
	    n1.addMember(j);

	    System.out.println("----Adding Not existing Member to Meeting Group----");
	    n1.addMember(z);
	   	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	  	
	    long t = System.currentTimeMillis();
	    Date d = new Date(t);
	    Date d2=new Date(t+100000000);
	    Date d1=new Date(t+200000000);
	    Country c=new Country("Catalonia");
	    Place p=new Place("The Garden","Diagonal,455","South BCN",false,c);
	    RepetitionPattern r= new RepetitionPattern();

	    Meeting t1=new Meeting("1st match Basket features",d1,t,false,1,1,2,d,d2,125,n1,p,r);
	    
	    System.out.println("----Adding Meeting to Meeting Group----");
	    n1.addMeeting(t1);
	 
	    System.out.println(" ");
	    System.out.println("----Adding Duplicated Meeting to Meeting Group----");
	    n1.addMeeting(t1);
	    System.out.println(" ");
	    System.out.println("----Adding MeetingGroup to ArrayList----");
	    meetingGroups=addMeetingGroup(n1,meetingGroups);
	    
	    System.out.println("----Adding Duplicated MeetingGroup to ArrayList----");
	    meetingGroups=addMeetingGroup(n1,meetingGroups);	   
	   
	    System.out.println(NL+"----List of available MeetingGroups----");
	    listMeeting(meetingGroups);
	
	    System.out.println("----Searching for MeetingGroups----");
	    listMeeting("Basketball in BCN",meetingGroups);
	 
	    System.out.println("----Searching for MeetingGroups----");
	    listMeeting("Cinema Tour",meetingGroups);
	}
}
