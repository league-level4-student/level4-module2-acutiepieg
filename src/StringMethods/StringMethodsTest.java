package StringMethods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringMethodsTest {

	@Test 
	void testLongerString() {
		assertEquals("A", StringMethods.longerString("", "A"));
		assertEquals("A", StringMethods.longerString("A", ""));
		assertEquals("equal", StringMethods.longerString("equal", "equal"));
	}
	
	@Test
	void testFormatSpaces() {
		assertEquals("This String should not chage", StringMethods.formatSpaces("This String should not chage"));
		assertEquals("This_String_should_have_its_spaces_filled_with_underscores", StringMethods.formatSpaces("This String should have its spaces filled with underscores"));
		assertEquals("x_x_x_x_x_x_x_underscores_x_x_x_x_x_x", StringMethods.formatSpaces("x x x x x x x underscores x x x x x x"));
	}
	
	@Test 
	void testLineLeader() {
		assertEquals("John A", StringMethods.lineLeader("John C", "John B", "John A"));
		assertEquals("John A", StringMethods.lineLeader(" John C   ", "     John B ", "           John A  "));
		assertEquals("Charley F", StringMethods.lineLeader("  Allison Z", " Brad H ", " Charley F "));
	}
	
	@Test
	void testNumeralSum() {
		assertEquals(0, StringMethods.numeralSum(""));
		assertEquals(5, StringMethods.numeralSum("11111"));
		assertEquals(3, StringMethods.numeralSum("a1b2c"));
		assertEquals(45, StringMethods.numeralSum("x1x2x3x4x5x6x7x8x9x"));
	}

	@Test
	void testSubstringCount() {
		assertEquals(3, StringMethods.substringCount("subsubsub", "sub"));
		assertEquals(2, StringMethods.substringCount("s ubsubsu bsubs ub", "sub"));
		assertEquals(3, StringMethods.substringCount("Here I'm counting spaces"," "));
		assertEquals(0, StringMethods.substringCount("There shoudn't be matches here", "tuna"));
	}
	
	@Test
	void testEncrypt() {
		assertEquals("KwYPDww=", StringMethods.encrypt("Hello", 'c'));
		assertEquals("FCglYAwlISc1JWAvJmABLSE6KS4nYBAyLycyIS0tJTIz", StringMethods.encrypt("The League of Amazing Programmers", '@'));
		assertEquals("JBkdFVAEH1AVEQRQAx8dFVAAAhUEChUcAw==", StringMethods.encrypt("Time to eat some pretzels", 'p'));
	}
	
	@Test
	void testDecrypt() {
		assertEquals("Hello", StringMethods.decrypt("KwYPDww=", 'c'));
		assertEquals("The League of Amazing Programmers", StringMethods.decrypt("FCglYAwlISc1JWAvJmABLSE6KS4nYBAyLycyIS0tJTIz" , '@'));
		assertEquals("Time to eat some pretzels", StringMethods.decrypt("JBkdFVAEH1AVEQRQAx8dFVAAAhUEChUcAw==", 'p'));
	}
	
	@Test
	void testWordsEndWithSubstring() {
		assertEquals(3, StringMethods.wordsEndsWithSubstring("He quietly and slowly backed away from the bear that was hungrily looking at him", "ly"));
		assertEquals(2, StringMethods.wordsEndsWithSubstring("He was visiting The League of Amazing Programmers.", "ing"));
		assertEquals(7, StringMethods.wordsEndsWithSubstring("Here are multiple words that have the same letter at the end.", "e"));
		assertEquals(0, StringMethods.wordsEndsWithSubstring("This should give us zero matches", "lemonade"));
	}
	
	@Test
	void testDistance() {
		assertEquals(6, StringMethods.distance("subsubsubsub", "sub"));
		assertEquals(7, StringMethods.distance("subsubsubsub", "ub"));
		assertEquals(28, StringMethods.distance("The League The Le ague TheLeag ue The League", "League"));
		assertEquals(0, StringMethods.distance("bb", "b"));
		
	}
	
	@Test
	void testPalindrome() {
		assertTrue(StringMethods.palindrome("ABA"));
		assertTrue(StringMethods.palindrome("ABBA"));
		assertTrue(StringMethods.palindrome("racecar"));
		assertTrue(StringMethods.palindrome("Was it a cat I saw?"));
		assertTrue(StringMethods.palindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal – Panama"));
		assertTrue(StringMethods.palindrome("Doc, Note: I Dissent. A Fast Never Prevents A Fatness. I Diet On Cod."));
		assertFalse(StringMethods.palindrome("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(StringMethods.palindrome("This is not a palendrome"));
		assertFalse(StringMethods.palindrome("This is close but not quite right etiuq ton tub esolc si sihT"));
	}
	
}
