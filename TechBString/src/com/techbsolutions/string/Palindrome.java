package com.techbsolutions.string;

/*
 * 
2. Create Palindrome class in JAVA and then do the following:
- Ask User to enter a word or create a String variable 
and assign a word to it
- Reverse a String and check if string in Palindrome
Definition of Palindrome: https://www.dictionary.com/browse/palindrome
 */
public class Palindrome {

	private static boolean isPalindrome(String word) {
		if(word==null || word.trim().length()==0) {
			return false;
		}
		String reverse = reverseWord(word);
		if(word.equalsIgnoreCase(reverse))
			return true;
		return false;
		
	}

	/**
	 * This method reverses a given input string.
	 * @param word
	 * @return
	 */
	private static String reverseWord(String word) {
		StringBuilder sb= new StringBuilder();
		for(int i=word.length()-1; i>=0; i--) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		boolean status=isPalindrome("wow");
		if(status==true)
			System.out.println("It is a palindrome");
		else
			System.out.println("not a palindrome");

	}

}
