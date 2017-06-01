package Lists;

import static org.junit.Assert.*;

import org.junit.Test;

import Collections.SingleyList;

public class SingleyListTest
{
	@Test
	public void testSingley_Add()
	{
		SingleyList<Integer> lst = new SingleyList<Integer>();
		for( int i = 0; i < 10; ++i )
			lst.add( i );
		
		int size = lst.getSize();
		assertEquals( 10, size );
		
		for( int i = 0; i < 10; ++i )
			assertEquals( Integer.valueOf(i), lst.get(i) );
	}
	
	@Test
	public void testSingley_Remove()
	{
		SingleyList<Integer> lst = new SingleyList<Integer>();
		for( int i = 0; i <= 10; ++i )
			lst.add( i );
		
		lst.remove( 9 );
		
		assertEquals( 10, lst.getSize() );
		for( int i = 0; i < lst.getSize(); ++i )
		{
			if( i == lst.getSize()-1 )
				assertEquals( Integer.valueOf(10), lst.get(i) );
			else
				assertEquals( Integer.valueOf(i), lst.get(i) );
		}
		
		lst.remove( 0 );
		assertEquals( 9, lst.getSize() );
		for( int i = 0; i < lst.getSize(); ++i )
		{
			if( i == lst.getSize()-1 )
				assertEquals( Integer.valueOf(10), lst.get(i) );
			else
				assertEquals( Integer.valueOf(i+1), lst.get(i) );
		}
	}
	
	@Test
	public void testSingley_RemoveInvalid()
	{
		SingleyList<Integer> lst = new SingleyList<Integer>();
		for( int i = 0; i < 10; ++i )
			lst.add( i );
		
		assertEquals( 10, lst.getSize() );
		assertFalse( lst.remove( 9000 ) );
	}
}
