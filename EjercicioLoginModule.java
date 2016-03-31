import java.io.IOException;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
 
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.swing.text.StyledEditorKit.BoldAction;


/**
 * Login module that simply matches name and password to perform authentication.
 * If successful, set principal to name and credential to "admin".
 *
 * @author Oscar Cuellas
 * 
 */
public class EjercicioLoginModule implements LoginModule {
	
	/**
	 * Definimos donde estaran nuestros archivos de logeo:
	 * 	contiene información sobre username, y lo roles que puede tener un usuario
	 * 	shdow, contiene el salt y el hash de la contraseña sobre la que nos logearemos
	 */
	private String passwrdFile = "/opt/tomcat7/conf/passwrd";
	private String ShadowFile = "/opt/tomcat7/conf/shdow";
	
	private ArrayList<String> roles =null;
	
    /** Callback handler to store between initialization and authentication. */
    private CallbackHandler handler;
 
    /** Subject to store. */
    private Subject subject;
 
    /** Login name. */
    private String login;
   
 
    /**
     * This implementation always return false.
     *
     * @see javax.security.auth.spi.LoginModule#
     */
    @Override
    public boolean abort() throws LoginException {
 
        return false;
    }
    
    public  EjercicioLoginModule(Subject aSubject, CallbackHandler aCallbackHandler, Map aSharedState, Map aOptions){
    	this.initialize(aSubject, aCallbackHandler, aSharedState, aOptions);
    	
    }
    /**
     * This is where, should the entire authentication process succeeds,
     * principal would be set.
     *
     * @see javax.security.auth.spi.LoginModule#commit()
     */
    @Override
    public boolean commit() throws LoginException {
 
        try {
 
            PlainUserPrincipal user = new PlainUserPrincipal(login);
            subject.getPrincipals().add(user);
            
            for(String role: roles){
            	subject.getPrincipals().add(new PlainRolePrincipal(role));
   
            }
            return true;
 
        } catch (Exception e) {
 
            throw new LoginException(e.getMessage());
        }
    }
 
    /**
     * This implementation ignores both state and options.
     *
     * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject,
     *      javax.security.auth.callback.CallbackHandler, java.util.Map,
     *      java.util.Map)
     */
    @Override
    public void initialize(Subject aSubject, CallbackHandler aCallbackHandler, Map aSharedState, Map aOptions) {
 
        handler = aCallbackHandler;
        subject = aSubject;
    }
 
    /**
     * This method checks whether the name and the password are the same.
     *
     * @see javax.security.auth.spi.LoginModule#login()
     */
    @Override
    public boolean login() throws LoginException {
 
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("login");
        callbacks[1] = new PasswordCallback("password", true);
        Boolean ko = false; /* por defecto el login esta siempre inabilitado*/
        Boolean ok = false;
        try {
 
            handler.handle(callbacks);
 
            String name = ((NameCallback) callbacks[0]).getName();
            String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());
            ArrayList<String> uroles = new ArrayList<String>();
            String salt = "";
            String hash = "";
            String hash_digest = "";	
    			 File password1 = new File(passwrdFile);
    	         Scanner sPassword = null;
    	         sPassword = new Scanner(password1);
    	         while(sPassword.hasNext()){
    	  	       String sPasswordLine = sPassword.nextLine();
               	   StringTokenizer tokens = new StringTokenizer(sPasswordLine, ":");
               	   String str = tokens.nextToken().toString();
               	   if(name.equalsIgnoreCase(str)){
               			 	while(tokens.hasMoreTokens()){
               			 		uroles.add(tokens.nextToken().toString());
               			 		ok = true;
               			 		break;
               			 	}
               	   	}
    	         }
    	         sPassword.close();
    	        
    	         File shadow1 = new File(ShadowFile);
    	         Scanner sPassword2 = null;
    	         sPassword2 = new Scanner(shadow1);
    	         
    	         while(sPassword2.hasNext()){
    	  	       String sPasswordLine = sPassword2.nextLine();
              	   StringTokenizer tokens = new StringTokenizer(sPasswordLine, ":");
              	   String str = tokens.nextToken().toString();
              	   if(name.equalsIgnoreCase(str)){
              		   	 salt = tokens.nextToken().toString();
              		     hash = tokens.nextToken().toString();
              		     
              		}
    	         }
    	         sPassword.close();
    		     
    		 	
    	     try{
    			
            	MessageDigest md = MessageDigest.getInstance("MD5");
    			md.reset();
    			md.update((salt+password).getBytes());
    			for(byte aux : md.digest()) {
    				          int b = aux & 0xff;
    						  if (Integer.toHexString(b).length() == 1) {
    							  hash_digest += "0";
    						  }else{
    							    hash_digest += Integer.toHexString(b);
    						  }
    			          
    			}            
    		 } catch (Exception e) {
    		 		// TODO: handle exception
    		 }
            if (!hash_digest.equals(hash)) {
 
                throw new LoginException("Authentication failed");
            }
 
            login = name;
            roles = uroles;
            return ok;
 
        } catch (IOException e) {
 
            throw new LoginException(e.getMessage());
 
        } catch (UnsupportedCallbackException e) {
 
            throw new LoginException(e.getMessage());
        }
    }
 
    /**aSubject
     * Clears subject from principal and credentials.
     *
     * @see javax.security.auth.spi.LoginModule#logout()
     */
    @Override
    public boolean logout() throws LoginException {
 
        try {
 
            PlainUserPrincipal user = new PlainUserPrincipal(login);
            subject.getPrincipals().remove(user);
            
            for(String role1: roles){
            	subject.getPrincipals().remove(new PlainRolePrincipal(role1));
   
            }
 
            return true;
 
        } catch (Exception e) {
 
            throw new LoginException(e.getMessage());
        }
    }
}
