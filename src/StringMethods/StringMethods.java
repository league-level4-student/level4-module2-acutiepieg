package StringMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		} else if (s2.length() > s1.length()) {
			return s2;
		}
		return "equal";
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			String newS = s.replace(' ', '_');
			return newS;
		}
		return s;

	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String newS1 = s1.trim();
		String newS2 = s2.trim();
		String newS3 = s3.trim();
		String first = newS1;

		if (first.substring(first.length() - 1).compareTo(newS2.substring(newS2.length() - 1)) > 0) {
			first = newS2;
		}
		if (first.substring(first.length() - 1).compareTo(newS3.substring(newS3.length() - 1)) > 0) {
			first = newS3;
		}
		return first;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		if (!s.equals("")) {
			String[] split = new String[s.length()];
			split = s.split("");
			int total = 0;
			for (int i = 0; i < split.length; i++) {
				if (Character.isDigit(split[i].charAt(0))) {
					int newInt = Integer.parseInt(split[i]);
					total = total + newInt;
				}
			}
			return total;
		} else {
			return 0;
		}
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int count = 0;
		int check = s.indexOf(substring);
		if (check != -1) {
			count++;
		}

		while (check != -1) {
			check = s.indexOf(substring, check + substring.length());
			if (check != -1) {
				count++;
			}
		}

		return count;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] split = new byte[s.length()];
		split = s.getBytes();
		String newS = Utilities.encrypt(split, (byte) key);
		return newS;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String newS = Utilities.decrypt(s, (byte) key);
		return newS;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		String[] split = new String[substringCount(s, " ")];
		split = s.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (split[i].endsWith(substring)) {
				count++;
			}
		}
		return count;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int first = s.indexOf(substring);
		int last = s.indexOf(substring);
		int temp;
		while (last != -1) {
			temp = s.indexOf(substring, last + substring.length());
			if (temp != -1) {
				last = temp;
			}
		}
		return last - first;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String newS = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isLetter(s.charAt(i))) {
				newS = newS + Character.toLowerCase(s.charAt(i));
			}
		}
		
		String lower = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				lower = lower + Character.toLowerCase(s.charAt(i));
			}
		}
		
		if (lower.equals(newS)) {
			return true;
		} else {
			return false;
		}
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
