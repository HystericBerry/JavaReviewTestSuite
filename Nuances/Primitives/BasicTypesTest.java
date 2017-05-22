package Primitives;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicTypesTest
{
	private static double epsilon = 0.000001;
	
	@Test
	public void testPrimitiveAssign()
	{
		boolean b = false;
		int i = 10;
		float f = 1.23f;
		double d = 3.14;
		
		assertEquals(false, b);
		assertEquals(10, i);
		assertEquals(1.23f, f, epsilon);
		assertEquals(3.14, d, epsilon);
	}
	
	/**
	 * Mixed Type Expression
	 */
	@Test
	public void testImplicitConversion()
	{
		int i = 10;
		float f = 1.23f;
		double d = 3.14;
		
		int actualInt = i + (int) f;
		assertEquals(11, actualInt);
		
		float actualFloat =  f + (float)d;
		assertEquals(4.37f, actualFloat, epsilon);
	}
	
	@Test
	public void testStringConcat()
	{
		int a = 3, b = 7;
		String msg = "a + b = ";
		
		String actualExpress = msg + (a + b);
		
		assertEquals("a + b = 10", actualExpress);
	}
	
	@Test
	public void testStringConcat_NotEqual()
	{
		int a = 3, b = 7;
		String msg = "a + b = ";
		
		String actualExpress = msg + a + b;
		
		assertNotEquals("a + b = 10", actualExpress);
	}
}