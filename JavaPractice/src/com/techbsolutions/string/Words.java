package com.techbsolutions.string;

/**
 * Create Words class in JAVA and then do the following:
- Ask User to enter a sentence or create a String variable to assign
 a sentence to it
- Count all Words in a String and display the count
- Display the count of word in a sentence
 * @author nija
 *
 */
public class Words {

	private static int countWords(String sentence) {
		if(sentence==null || sentence.trim().length()==0) {
			return 0;
		}
		String[] array=sentence.trim().split("\\s+");
		return array.length;
		
	}
	public static void main(String[] args) {
		System.out.println(countWords("Can      you count how many words here?"));
	}

}
