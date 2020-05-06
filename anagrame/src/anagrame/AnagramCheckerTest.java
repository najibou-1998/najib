package anagrame;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AnagramCheckerTest {

    @Test
    public void isAnagram() {
    	anagramechecker checker = new anagramechecker();
    	
    	 
    	 
    	 
    	 
        assertThat(checker.isAnagram("cuming", "noted"), equalTo(true));
        assertThat(checker.isAnagram("cuming", "toned"), equalTo(true));

        assertThat(checker.isAnagram("nugent", "domic"), equalTo(true));
        
        assertThat(checker.isAnagram("ceding", "mount"), equalTo(true));
        assertThat(checker.isAnagram("ceding", "muton"), equalTo(true));

        assertThat(checker.isAnagram("centimo", "dung"), equalTo(true));
        
        assertThat(checker.isAnagram("ceding", "peek"), equalTo(false));
        assertThat(checker.isAnagram("testing", "mount"), equalTo(false));

        assertThat(checker.isAnagram("noted", "worse"), equalTo(false));
        
    }
}