import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class PasswordVerifier {
	public boolean verify(String passwordhere) {
		
		
		Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    boolean flag=true;

	    if (passwordhere.trim().isEmpty()) {
	    	throw new RuntimeException("Password must not be null !!");
        }
	   
	 
	    else if (passwordhere.length() < 8) {
	    	throw new RuntimeException("Password lenght must have at least 8 character !!");
	       
	    }
	    
	    else if (!UpperCasePatten.matcher(passwordhere).find()) {
	    	 throw new RuntimeException("Password must have atleast one uppercase character !!");
	        
	    }
	    else if (!lowerCasePatten.matcher(passwordhere).find()) {
	    	 throw new RuntimeException("Password must have atleast one lowercase character !!");
	       
	    }
	    else if (!digitCasePatten.matcher(passwordhere).find()) {
	    	 throw new RuntimeException("Password must have atleast one digit character !!");
	      
	    }

	    return flag;

		
	}

    @Test
    public final void passwordShouldBeAtLeast8Chars() {
    	RuntimeException exception = null;
        try {
            verify("messi");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    	Assert.assertEquals("Password lenght must have at least 8 character !!", exception.getMessage());
    }
    
    @Test
    public final void passwordMustNotBeNull() {
    	RuntimeException exception = null;
        try {
            verify("");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    	Assert.assertEquals("Password must not be null !!", exception.getMessage());
    }
    @Test
    public final void passwordHaveOneUpperAtLeast() {
    	RuntimeException exception = null;
        try {
            verify("messi1998");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    	Assert.assertEquals("Password must have atleast one uppercase character !!", exception.getMessage());
    }
    
    
    
    @Test
    public final void passwordHaveOneLowerAtLeast() {
    	RuntimeException exception = null;
        try {
            verify("MESSI1998");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    	Assert.assertEquals("Password must have atleast one lowercase character !!", exception.getMessage());
    }
    
    
    
    @Test
    public final void passwordHaveOneNumberAtLeast() {
    	RuntimeException exception = null;
        try {
            verify("MESSImessi");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    	Assert.assertEquals("Password must have atleast one digit character !!", exception.getMessage());
    }
    
    
 

}
