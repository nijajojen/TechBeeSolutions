package com.techbsolutions.string;

import java.util.Arrays;

/**
 * 5. Create LastLetterCount class in JAVA and then do the following:
- Ask User to enter a sentence or 
create a String variable to assign a sentence to it
- Count all words that ends in 's' in a String and 
words that ends in 'y' in a String
- Switch the first instance of word that end with 's' and 'y'
- Display the new sentence where words are switched
 * @author nija
 *
 */
public class LastLetterCount {

	private static void countWordsEndInYAndS(String sentence)
	{
		if(sentence==null || sentence.trim().length()==0) {
			System.out.println("sentence is not valid");
		}
		String[] wordArray= sentence.split(" ");
		int countS = 0,countY=0;
		boolean firstS=false, firstY=false;
		int firstSIndex=0, firstYIndex=0;
		StringBuffer sb= new StringBuffer();
		for(int i=0; i<wordArray.length; i++) {
			if(wordArray[i].endsWith("s")) {
				countS++;
				if(!firstS) {
					firstS=true;
					firstSIndex=i;
				}
			}
			else if(wordArray[i].endsWith("y"))
				countY++;
			if(!firstY) {
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
