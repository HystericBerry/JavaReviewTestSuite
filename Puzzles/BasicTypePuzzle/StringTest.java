package BasicTypePuzzle;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import Solutions.StringAlgos;

public class StringTest
{
	private static String[] notPalin = new String[] { null, "ABCXYZ", "cjalsi09342", "lkjhgasdfgh", "abcCBA" };
	private static String[] palin = new String[] { "abuttuba", "amanaplanacanalpanama", "asantaatnasa", "avid diva" };
	
	@Test
	public void testPermutationIter()
	{
		String input1 = "abc", input2 = "abcd", input3 = "abcdef", input4 = "abcdefgh";
		Set<String> expected1 = StringAlgos.permutationSoln(input1);
		Set<String> expected2 = StringAlgos.permutationSoln(input2);
		Set<String> expected3 = StringAlgos.permutationSoln(input3);
		Set<String> expected4 = StringAlgos.permutationSoln(input4);
		
		Set<String> actual1 = StringAlgos.permutation(input1);
		Set<String> actual2 = StringAlgos.permutation(input2);
		Set<String> actual3 = StringAlgos.permutation(input3);
		Set<String> actual4 = StringAlgos.permutation(input4);
		
		
		assertEquals( expected1.size(), actual1.size() );
		assertEquals( expected2.size(), actual2.size() );
		assertEquals( expected3.size(), actual3.size() );
		assertEquals( expected4.size(), actual4.size() );
		
		for(String expectedVal : expected1)
			assertTrue( actual1.contains(expectedVal) );
		for(String expectedVal : expected2)
			assertTrue( actual2.contains(expectedVal) );
		for(String expectedVal : expected3)
			assertTrue( actual3.contains(expectedVal) );
		for(String expectedVal : expected4)
			assertTrue( actual4.contains(expectedVal) );
	}
	
	@Test
	public void testPalindromeIter()
	{
		for( String s : notPalin )
			assertFalse( StringAlgos.isPalinIter(s) );
		
		for( String s : palin )
			assertTrue( StringAlgos.isPalinIter(s) );
	}
	
	public void testPalindromeRecurse()
	{
		for( String s : notPalin )
			assertFalse( StringAlgos.isPalinRecurse(s) );
		
		for( String s : palin )
			assertTrue( StringAlgos.isPalinRecurse(s) );
	}
}
