package BasicTypePuzzle;

import static org.junit.Assert.*;

import org.junit.Test;

import Solutions.Palindrome;

public class StringTest
{
	private static String[] notPalin = new String[] { null, "ABCXYZ", "cjalsi09342", "lkjhgasdfgh", "abcCBA" };
	private static String[] palin = new String[] { "abuttuba", "amanaplanacanalpanama", "asantaatnasa", "avid diva" };
	
	@Test
	public void testPalindromeIter()
	{
		for( String s : notPalin )
			assertFalse( Palindrome.isPalinIter(s) );
		
		for( String s : palin )
			assertTrue( Palindrome.isPalinIter(s) );
	}
	
	public void testPalindromeRecurse()
	{
		for( String s : notPalin )
			assertFalse( Palindrome.isPalinRecurse(s) );
		
		for( String s : palin )
			assertTrue( Palindrome.isPalinRecurse(s) );
	}
}
