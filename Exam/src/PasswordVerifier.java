import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Test;

import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.log.SysoLogger;


public class PasswordVerifier {
	

	  public static ArrayList<String> errors;

	
	public static List verify(String passwordhere) {
		
		
		Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    List Decision = new ArrayList();
	     errors = new ArrayList<String>();
	     
	    boolean flag=true;
	    int Correct_cases = 0;
	    int Cases_should_be_true =0;

	    if (passwordhere.trim().isEmpty()) {
	    	errors.add("Password must not be null !!");
	    	throw new IllegalArgumentException("Password must not be null !!");
	    	
        }
	    	
	    else Correct_cases++; 
	   
	 
	   if (passwordhere.length() < 8) {
		   errors.add("Password lenght must have at least 8 character !!");
		   throw new IllegalArgumentException("Password lenght must have at least 8 character !!");
		  
	    	  }
	    else { Correct_cases++; Cases_should_be_true++; }
	   
	   
	    if (!lowerCasePatten.matcher(passwordhere).find()) {
	    	errors.add("Password must have atleast one lowercase character !!");
	    	throw new IllegalArgumentException("Password must have atleast one lowercase character !!");
	    	
	    	 }
	    else { Correct_cases++; Cases_should_be_true++; }
	    
	    
	    if (!UpperCasePatten.matcher(passwordhere).find()) {
	    	errors.add("Password must have atleast one uppercase character !!");
	    	throw new IllegalArgumentException("Password must have atleast one uppercase character !!");
	    
	    	 }
	    else Correct_cases++; 
	    
	     
	     if (!digitCasePatten.matcher(passwordhere).find()) {
	    	 errors.add("Password must have atleast one digit character !!");
	    		throw new IllegalArgumentException("Password must have atleast one digit character !!");
	    		
	    	  }
	     else Correct_cases++; 
	  


         Decision.add(Correct_cases);
         Decision.add(Cases_should_be_true);
	    return Decision;

		
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
	            verify("messiMessi");
	        } catch (RuntimeException e) {
	            exception = e;
	        }
	        Assert.assertNotNull(exception);
	    	Assert.assertEquals("Password must have atleast one digit character !!", exception.getMessage());
	    }
    
    
 
    public static void main(String[] args) throws ArithmeticException {
	
    	
    	Frame f=new Frame("Button Example");  
        Button b=new Button("Click Here");  
        JPasswordField pass  = new JPasswordField();  
        b.setBounds(50,100,80,30); 
        pass.setBounds(50, 50, 150, 50);
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            
         	    List Desision_array = new ArrayList();
         	    
         	    Desision_array=verify(pass.getText());
         	    int Correct_cases=(int) Desision_array.get(0);
         	    int Cases_should_be_true=(int) Desision_array.get(1);

         	    
         	    
                 for (String error : errors) {
                     System.out.println(error);
                 }

         	    
             	if(Cases_should_be_true!=2)
             	{

             		System.out.println("password is never ok");
             	}
         	    else
         	        if(Correct_cases>=3)
         		    {

         		    	System.out.println("password ok");
         		    	
         		    }  
                }  
            });  
        f.add(b);  
        f.add(pass);
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true); 
       
  	

	  
    }

}
