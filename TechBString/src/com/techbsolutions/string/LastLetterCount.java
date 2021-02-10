package com.techbsolutions.string;

import java.util.Arrays;

public class LastLetterCount {

	private static void countWordsEndInYAndS(String sentence)
	{
		String[] wordArray= sentence.split(" ");
		int countS = 0,countY=0;
		boolean firstS=false, firstY=false;
		int firstSIndex=0, firstYIndex=0;
		StringBuffer sb= new StringBuffer();
		for(int i=0; i<wordArray.length; i++) {
			if(wordArray[i].endsWith("s")) {
				countS++;
				if(firstS==false) {
					firstS=true;
					firstSIndex=i;
				}
			}
			else if(wordArray[i].endsWith("y"))
				countY++;
			if(firstY==false) {
				firstY=true;
				firstYIndex=i;
			}
		}
		String temp=wordArray[firstYIndex];
		wordArray[firstYIndex]=wordArray[firstSIndex];
		wordArray[firstSIndex]= temp;
		
		for(int i=0;i<wordArray.length;i++)
			sb.append(wordArray[i]+" ");
		System.out.println("first instance words switched: "+sb.toString());
		System.out.println("word count that ends in 's': "+countS);
		System.out.println("word count that ends in 'y': "+countY);
	}
	public static void main(String[] args) {
		String value="very very nice flowers , miss";
		System.out.println("Original Sentence: "+ value);
		countWordsEndInYAndS(value);

	}

}
