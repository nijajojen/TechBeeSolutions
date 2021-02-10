package com.techbsolutions.string;

import java.util.HashSet;
import java.util.Set;

public class Consonants {

	private static int countConsonants(String sentence) {
		Set<Character> set= new HashSet<Character>();
		set.add('A');set.add('a');
		set.add('E');set.add('e');
		set.add('I');set.add('i');
		set.add('O');set.add('o');
		set.add('U');set.add('u');
		
		int count=0;
		String newChar="*";
		char[] charArray= sentence.toCharArray();
		for(int i=0; i< sentence.length(); i++) {
			if((set.contains(charArray[i])== false)&& (charArray[i]!=' ')) {
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
