
import org.junit.Assert;
import org.junit.Test;



import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Password {

	public static ArrayList <String>  List_errors=new ArrayList(); 
    /**
     * This function checks if the password is empty
     */
    public static int isPasswordNotEmpty(String s)  {
        if (s.trim().isEmpty()) {
   		 throw new RuntimeException("Password should not be empty");
        	
        } else
            return 1;
		
    }

    /**
     * This function checks if the password
     * matches the required minimum of 8 characters.
     */
    public static int lengthChecker(String s)  {
        if (s.length() >= 8)
            return 1;
        else
   		 throw new RuntimeException("Password length should be more than 8");
		    
    }

    /**
     * This function uses a regex expression [A-Z]
     * that checks to see if there is an
     * uppercase letter in the password.
     */
    public static int upperCase(String s) {
        Pattern upper = Pattern.compile("[A-Z]");
        Matcher m = upper.matcher(s);
        if (m.find())
            return 1;
        else
   		 throw new RuntimeException("Password should contain at least one uppercase letter");
          
    }

    /**
     * This function uses a regex expression [a-z]
     * that checks to see if there is a
     * lowercase letter in the password.
     */
    public static int lowerCase(String s)  {
        Pattern lower = Pattern.compile("[a-z]");
        Matcher m = lower.matcher(s);
        if (m.find())
            return 1;
        else
   		 throw new RuntimeException("Password should contain at least one lowercase letter");
          
    }

    /**
     * This function uses a regex expression [0-9]
     * that checks to see if there
     * is a number in the password.
     */
    public static int digitize(String s)  {
        Pattern digit = Pattern.compile("[0-9]");
        Matcher m = digit.matcher(s);
        if (m.find())
            return 1;
        else
   		 throw new RuntimeException("Password should contain at least one digit");
            
    }

    public static boolean verify(String password) {
    	
String errors = null;
       
        	
        	
        	try {
                if (lowerCase(password) == 1 && isPasswordNotEmpty(password) + lengthChecker(password)
                        + upperCase(password) + digitize(password) >= 2)
                	return true;
            } catch (Exception e) {
                System.out.print(e);
                
            }
            	
        	 return false;	
       
            	        
    }
    @Test
    public final void passwordShouldBenotbeembpty() {
        try {
            Assert.assertEquals(1, lengthChecker("n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public final void passwordShouldBeAtLeast8Chars() {
        try {
            Assert.assertEquals(1, lengthChecker("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void passwordMustNotBeNull() {
        try {
            Assert.assertEquals(1, isPasswordNotEmpty("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void passwordHaveOneUpperAtLeast() {
        try {
            Assert.assertEquals(1, upperCase("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void passwordHaveOneLowerAtLeast() {
        try {
            Assert.assertEquals(1, lowerCase("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void passwordHaveOneNumberAtLeast() {
        try {
            Assert.assertEquals(1, digitize("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public final void passwordIsneverOkCorrect1() {
        try {
            Assert.assertFalse(verify("najib"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public final void passwordIsneverOkCorrect2() {
        try {
            Assert.assertFalse(verify("NAJIBZAKI"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public final void passwordIsneverOkCorrect3() {
        try {
            Assert.assertFalse(verify("NADJIB1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public final void passwordIsWithoutExceptionsCorrect() {
        try {
            Assert.assertTrue(verify("NadjibZaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
    @Test
    public final void passwordIsCorrectWithUpperCsseException() {
        try {
            Assert.assertTrue(verify("Nadjibzaki1998"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

   
}
