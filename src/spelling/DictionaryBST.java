package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 * @author Mickael Grivolat
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
 	// You'll need a constructor here
	public DictionaryBST() {
		dict = new TreeSet<String>();
	}
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	String wordLower = word.toLowerCase();
    	
    	if(!dict.contains(wordLower)) {
    		dict.add(wordLower);
    		return true;
    	}
    	
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//return !(s.indexOf("!") >=0 || s.indexOf(".") >=0 || s.indexOf("?")>=0);
    	String wordLower = s.toLowerCase();
    	
    	if(dict.contains(wordLower)) {
    		return true;
    	}

        return false;
    }

}
