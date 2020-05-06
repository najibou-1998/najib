package anagrame;

import java.util.Arrays;

public class anagramechecker {

    public static boolean isAnagram(String input1, String input2) {
    	String input3 = input1 + input2;
        char[] sortedWord1 = input3.toCharArray();
        Arrays.sort(sortedWord1);

        char[] sortedWord2 = "documenting".toCharArray();
        Arrays.sort(sortedWord2);

        return Arrays.equals(sortedWord1,sortedWord2);
    }

	

}
