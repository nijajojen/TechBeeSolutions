package com.techbsolutions.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 1. Create Vowels class in JAVA then do the following:
- Ask User to enter a sentence 
or create a String variable to assign a sentence to it
- Count all the vowels in a sentence and display the count
 */
public class Vowels {

	public int countVowels(String sentence) {
		//validating boundary conditions
		if(sentence==null || sentence.trim().length()==0) {
				return 0;
			}
			
		Set<Character> vowelSet= new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
		int count = 0;
		
		for(int i=0; i<sentence.length(); i++) {
			if(vowelSet.contains(sentence.charAt(i))) {
				count++;
			}
		}
		return count;
		
	}
	public static void main(String[] args) {
		Vowels objVowel= new Vowels();
		System.out.println(objVowel.countVowels("How many vowels here?"));
		System.out.println(objVowel.countVowels("bcd"));
		System.out.println(objVowel.countVowels(null));

	}

}
