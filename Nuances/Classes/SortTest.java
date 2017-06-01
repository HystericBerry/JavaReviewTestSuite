package Classes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import Math.Sort;

public class SortTest
{
	private static Integer[] UNSORTED = new Integer[] { 81, 99, 66, 3, 31, 95, 30, 7, 28, 50 };
	private static List<Integer> SORTED;
	public SortTest()
	{
		Integer[] unsorted = new Integer[] { 81, 99, 66, 3, 31, 95, 30, 7, 28, 50 };
		SORTED = new ArrayList<Integer>( Arrays.asList(unsorted) );
		Collections.sort(SORTED);
	}
	
	@Test
	public void testInsertionSort()
	{
		List<Integer> unsorted = new ArrayList<Integer>( Arrays.asList(UNSORTED) );
		
		Sort.insertionSort(unsorted);
		
		for( int i = 0; i < SORTED.size(); ++i )
			assertEquals( SORTED.get(i), unsorted.get(i) );
	}
	
	@Test
	public void testSelectionSort()
	{
		List<Integer> unsorted = new ArrayList<Integer>( Arrays.asList(UNSORTED) );
		
		Sort.selectionSort(unsorted);
		
		for( int i = 0; i < SORTED.size(); ++i )
			assertEquals( SORTED.get(i), unsorted.get(i) );
	}
	
	@Test
	public void testBubbleSort()
	{
		List<Integer> unsorted = new ArrayList<Integer>( Arrays.asList(UNSORTED) );
		
		Sort.bubbleSort(unsorted);
		
		for( int i = 0; i < SORTED.size(); ++i )
			assertEquals( SORTED.get(i), unsorted.get(i) );
	}
}
