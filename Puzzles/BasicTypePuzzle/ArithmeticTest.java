package BasicTypePuzzle;

import static org.junit.Assert.*;

import org.junit.Test;

import Collections.Entry;
import Collections.MutableEntry;
import Solutions.BlackWhiteTiles;

public class ArithmeticTest
{
	@Test
	public void testMystery()
	{
		int mystery = 1;
		mystery = 1 - 2 * mystery;
		mystery = mystery + 1;
		
		assertEquals(0, mystery);
	}
	
	/**
	 * <p>
	 * Given the TOTAL WITDH and the TILE WIDTH, determine how many black and 
	 * white tiles can fit within the TOTAL WIDTH such that the sequence of tiles 
	 * start <strong>AND</strong> end with black tiles.
	 * </p>
	 * 
	 * <p>
	 * Example: <br>| B W B W B |
	 * </p>
	 */
	@Test
	public void testBlackWhiteTiles()
	{
		int TOTAL_WIDTH = 100, TILE_WIDTH = 5;
		Entry[] expectedVal = new Entry[] { new MutableEntry(10, 9), new MutableEntry(0, 0), new MutableEntry(1, 0) };
		// "naive" Implementation
		for( int i = 0; i < 3; ++i )
		{
			Entry blackWhite = null;
			
			int currTileWidth;
			for( int j = 0; j < 3; ++j )
			{
				if( j == 0 )
					currTileWidth = TILE_WIDTH;
				else if( j == 1 )
					currTileWidth = TOTAL_WIDTH+1;
				else
					currTileWidth = TOTAL_WIDTH-1;
				
				if( i == 0)
					blackWhite = BlackWhiteTiles.naiveImpl( TOTAL_WIDTH, currTileWidth );
				else if( i == 1 )
					blackWhite = BlackWhiteTiles.iterativeImpl( TOTAL_WIDTH, currTileWidth );
				else
					blackWhite = BlackWhiteTiles.recursiveImpl( TOTAL_WIDTH, currTileWidth );
				
				assertEquals(expectedVal[j].getKey().intValue(), blackWhite.getKey().intValue() );
				assertEquals(expectedVal[j].getValue().intValue(), blackWhite.getValue().intValue() );
			}
		}
	}
}