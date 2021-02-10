package com.techbsolutions.string;

import java.util.HashSet;
import java.util.Set;

public class Vowels {

	public static int countVowels(String sentence) {
		
		Set<Character> set= new HashSet<>();
		int count = 0;
		set.add('A');set.add('a');
		set.add('E');set.add('e');
		set.add('I');set.add('i');
		set.add('O');set.add('o');
		set.add('U');set.add('u');
		for(int i=0; i<sentence.length(); i++) {
			if(set.contains(sentence.charAt(i))) {
				count++;
			}
		}
		return count;
		
	}
	public static void main(String[] args) {
		System.out.println(countVowels("How many vowels here?"));

	}

}
