package Classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.awt.Rectangle;

import org.junit.Test;

import Math.MathUtils;
import Classes.CallbackExample.IntegerMeasurer;
import Classes.CallbackExample.RectMeasurer;
import Structs.DuplicateStruct.Child;
import Structs.DuplicateStruct.Parent;
import Structs.InvalidLocalVar;

public class ObjectTypesTest
{
	private static double epsilon = 1e-6;
	@Test
	public void testInvalidLocalVariable()
	{
		int expectedValue = 1234;
		InvalidLocalVar invalidObject = new InvalidLocalVar( expectedValue );
		
		int actualValue = invalidObject.invalid;
		
		assertNotEquals( expectedValue, actualValue );
	}
	
	@Test
	public void testInheritDuplicateFields()
	{
		String expectedObj = "Hello World";
		Parent parent = new Parent(expectedObj);
		Child child = new Child(expectedObj);
		Parent childInst = (Parent) child;
		
		assertEquals( expectedObj, parent.toString() );
		assertNull( child.toString() );
		assertNull( childInst.toString() );
	}
	
	@Test
	public void testCallback()
	{
		RectMeasurer rectMeas = new RectMeasurer();
		Object[] arr = new Rectangle[] {
				new Rectangle(5, 10, 20, 30),
				new Rectangle(10, 20, 30, 40),
				new Rectangle(20, 30, 5, 15)
		};
		
		double expectedVal = 625;
		double actualVal = MathUtils.average(arr, rectMeas);
		assertEquals( expectedVal, actualVal, epsilon );
		
		
		IntegerMeasurer intMeas = new IntegerMeasurer();
		arr = new Integer[] { new Integer(1), new Integer(2),
				new Integer(3), new Integer(4) };
		
		expectedVal = 10.0 / 4.0;
		actualVal = MathUtils.average(arr, intMeas);
		assertEquals( expectedVal, actualVal, epsilon );
	}
}