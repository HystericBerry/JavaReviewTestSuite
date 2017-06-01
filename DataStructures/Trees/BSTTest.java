package Trees;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import Collections.BST;
import Collections.SingleyList;

public class BSTTest
{
	private static Integer[] ARRAY = new Integer[] { 30, 15, 46, 82, 9 };
	
	@Test
	public void testBST_Add()
	{
		BST<Integer> tree = new BST<Integer>();
		for( int i = 0; i < ARRAY.length; ++i )
			tree.add( ARRAY[i] );
		
		for( int i = 0; i < ARRAY.length; ++i  )
			assertTrue( tree.contains(ARRAY[i]) );
	}
	
	@Test
	public void testBST_Remove()
	{
		BST<Integer> tree = new BST<Integer>();
		for( int i = 0; i < ARRAY.length; ++i )
			tree.add( ARRAY[i] );
	}
	
	@Test
	public void testBST_Inorder()
	{
		BST<Integer> tree = new BST<Integer>();
		for( int i = 0; i < ARRAY.length; ++i )
			tree.add( ARRAY[i] );
		
		SingleyList<Integer> lst = new SingleyList<Integer>();
		tree.inorder(lst, tree);
		
		Integer[] iArr = Arrays.copyOf(ARRAY, ARRAY.length);
		Arrays.sort( iArr );
		for( int i = 0; i < lst.getSize(); ++i )
			assertEquals( iArr[i], lst.get(i) );
	}
}
