package Classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectTypesTest
{
	@Test
	public void testInvalidLocalVariable()
	{
		int expectedValue = 1234;
		InvalidLocalVar invalidObject = new InvalidLocalVar( expectedValue );
		
		int actualValue = invalidObject.invalid;
		
		assertNotEquals( expectedValue, actualValue );
	}
	
	/**
	 * This Class demonstrates the fact that the Java Language applies greater 
	 * precedence to local variables over member variables that have the same name.
	 * 
	 * @author pkim7
	 */
	private class InvalidLocalVar
	{
		@SuppressWarnings("all")
		public InvalidLocalVar( int invalid )
		{
			invalid = invalid;
		}
		
		public int invalid;
	}
}