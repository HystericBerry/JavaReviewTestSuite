package Threading;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import Solutions.PrimeThread;

public class PrimealityTest
{
	private static AtomicInteger sharedCounter;
	private static int NUMTHREADS = 10;
	
	@Test
	public void testPrimeality()
	{
		
		ConcurrentLinkedQueue<Integer> primes = new ConcurrentLinkedQueue<Integer>();
		for( int i = 1 ; i < PrimeThread.UPPERBOUND; ++i )
			if( isPrime(i) )
				primes.add( i );
		
		
		ConcurrentLinkedQueue<Integer> threadPrimes = new ConcurrentLinkedQueue<Integer>();
		sharedCounter = new AtomicInteger();
		ExecutorService executor = Executors.newCachedThreadPool();
		for( int i = 0; i < NUMTHREADS; ++i )
			executor.execute( new PrimeThread( threadPrimes, sharedCounter, i ) );
		
		executor.shutdown();
		
		try {
			executor.awaitTermination( Long.MAX_VALUE, TimeUnit.NANOSECONDS );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals( primes.size(), threadPrimes.size() );
	}
	
	private boolean isPrime( int n )
	{
		for( int i = 2; i < n; ++i )
		{
			if( n%i == 0 )
				return false;
		}
		
		return true;
	}
}
