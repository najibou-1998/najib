import org.junit.Assert;
	import org.junit.Test;

	import java.util.ArrayList;

public class String_Calculator {
	
	    private static int Add(String numbers) {

	        //Empty string should return 0
	        if (numbers.trim().isEmpty()) {
	            return 0;
	        }
	       
	        
	        
	        int Addition = 0;
	        ArrayList<Integer> intArrayList = new ArrayList<>();
	        ArrayList<Integer> negativeArrayList = new ArrayList<>();

	        //Splitting the string and putting the values in an Array
	        String[] strValues = numbers.split("\\s*,\\s*|\\r?\\n");

	        //Parsing the Array's values into integers and then putting them in an ArrayList
	        for (String z : strValues) {
	            intArrayList.add(Integer.parseInt(z));
	        }

	        //Browsing through the ArrayList and summing all of its values
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

	        return Addition;
	    }
	    
	    
	    
	    //Default delimiter ";"
        public static int add(final String numbers) {
            String delimiter = ",|n";
            String numbersWithoutDelimiter = numbers;
            if (numbers.startsWith("//")) {
                int delimiterIndex = numbers.indexOf("//") + 2;
                delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
                numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
            }
            return add(numbersWithoutDelimiter, delimiter);
        }

        private static int add(final String numbers, final String delimiter) {
            int returnValue = 0;
            String[] numbersArray = numbers.split(delimiter);
            for (String number : numbersArray) {
                if (!number.trim().isEmpty()) {
                    returnValue += Integer.parseInt(number.trim());
                }
            }
            return returnValue;
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
	        Assert.assertEquals(3+6+15, add("//;n3;6;15"));
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
