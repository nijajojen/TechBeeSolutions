package com.techbsolutions.string;

public class Words {

	private static int countWords(String sentence) {
		String[] array=sentence.split(" ");		
		return array.length;
		
	}
	public static void main(String[] args) {
		System.out.println(countWords("Can you count how many words here?"));
	}

}
