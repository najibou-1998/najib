import org.junit.Assert;
	import org.junit.Test;

	import java.util.ArrayList;

public class String_Calculator {
	
	public static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	    static int Add(String numbers) {

	        //Empty string should return 0
	        if (numbers.trim().isEmpty()) {
	            return 0;
	        }
	       
	        
	        
	        int Addition = 0;
	        ArrayList<Integer> intArrayList = new ArrayList<>();
	        ArrayList<Integer> negativeArrayList = new ArrayList<>();
	        if (numbers.startsWith("//")) {
	        	String delimiter = ",|n";
	            String numbersWithoutDelimiter = numbers;
	            int delimiterIndex = numbers.indexOf("//") + 2;
                delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
                numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
                String[] numbersArray = numbersWithoutDelimiter.split(delimiter);
                for (String number : numbersArray) {
                    if (!number.trim().isEmpty()) {
                    	Addition += Integer.parseInt(number.trim());
                    }
                }
              
	        	
	        }
	        else {
	        String[] strValues = numbers.split("\\s*,\\s*|\\r?\\n");
	       
	        
	      
	    
	        	for (String z : strValues) {
	        	 if (!isNumeric(z) ) {
		 	            throw new RuntimeException("String not allowed");
		 	        }
	            intArrayList.add(Integer.parseInt(z));
	        }

	        for (Integer element : intArrayList) {
	        	
	        	  
	        		 if (element < 0 ) {
	        			 negativeArrayList.add(element);
	        		      
		            }
	        	 else if (element > 0 && element < 1000) {
	            	Addition += element;
	            }
	         }
	       
	        if (negativeArrayList.size() > 0) {
	            throw new RuntimeException("Negatives not allowed: " + negativeArrayList.toString());
	        }
	        }
	        return Addition;
	    }
	    
	    
	    
	   
    
        
	    

	    @Test
	    public void emptyStringShouldReturnZero() {
	        Assert.assertEquals(0, Add(""));
	    }

	    @Test
	    public void singleNumberShouldReturnItsValue() {
	        Assert.assertEquals(4, Add("4"));
	    }
	    @Test
	    public void BadInput() {
	    	 RuntimeException exception = null;
		        try {
		            Add("A\n19");
		        } catch (RuntimeException e) {
		            exception = e;
		        }
		        Assert.assertNotNull(exception);
		        Assert.assertEquals("String not allowed", exception.getMessage());
	        
	    }

	    @Test
	    public void commaDelimited() {
	        Assert.assertEquals(10, Add("7,3"));
	    }

	   
	    @Test
	    public void handleUnknownAmountOfNumbers() {
	        Assert.assertEquals(41, Add("5,20,1,2,3,10"));
	        
	    }
	    @Test
	    public void newLineDelimited() {
	        Assert.assertEquals(32, Add("13\n19"));
	    }
	    
	    
	    @Test
	    public void HandleNewLinesAndCommas() {
	        Assert.assertEquals(13, Add("1,2\n10"));
	    }
	   
	    @Test
	    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
	        RuntimeException exception = null;
	        try {
	            Add("3,-6,15,-18,46,33");
	        } catch (RuntimeException e) {
	            exception = e;
	        }
	        Assert.assertNotNull(exception);
	        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	    }
	    @Test
	    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
	        Assert.assertEquals(3+6+15, Add("//;n3;6;15"));
	    }
	    @Test
	    public void ignoringNumbersGreaterThan1000() {
	        Assert.assertEquals(36, Add("5,20\n10\n1530\n1"));
	    }

	    @Test
	    public void number1000Test() {
	        Assert.assertEquals(0, Add("1000"));
	    }

	}
