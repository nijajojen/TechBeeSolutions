package com.techbsolutions.string;

public class Palindrome {

	private static boolean isPalindrome(String word) {
		String reverse = "";
		for(int i=word.length()-1; i>=0; i--) {
			reverse+=word.charAt(i);
		}
		if(word.equals(reverse))
			return true;
		return false;
		
	}
	public static void main(String[] args) {
		boolean status=isPalindrome("wow");
		if(status==true)
			System.out.println("It is a palindrome");
		else
			System.out.println("not a palindrome");

	}

}
