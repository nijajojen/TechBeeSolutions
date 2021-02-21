package com.techbsolutions.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 4. Create Consonants class in JAVA and then do the following:
- Ask User to enter a sentence or create a String variable 
to assign a sentence to it
- Count all consonants in a String and display the count
- Replace all consonants with '*' in a String
 * @author nija
 *
 */
public class Consonants {

	private static int countConsonants(String sentence) {
		if(sentence==null || sentence.trim().length()==0) {
			return 0;
		}
		Set<Character> vowelset= new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
		
		int count=0;
		String newChar="*";
		char[] charArray= sentence.toCharArray();
		for(int i=0; i< sentence.length(); i++) {
			if(!vowelset.contains(charArray[i])&& (charArray[i]!=' ')) {
				count++;
				charArray[i]='*';				
			}
		}
		
		System.out.println("Consonants replace by * : "+String.valueOf(charArray));
		return count;
		
	}
	public static void main(String[] args) {
		String string="Hello";
		System.out.println("The number of consonants in " + string + " is: "+countConsonants(string));

	}

}
