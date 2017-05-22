package BasicTypes;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicTypeProblems
{
	@Test
	public void testMystery()
	{
		int mystery = 1;
		mystery = 1 - 2 * mystery;
		mystery = mystery + 1;
		
		assertEquals(0, mystery);
	}
}