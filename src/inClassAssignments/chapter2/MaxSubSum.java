package inClassAssignments.chapter2;

import java.util.Random;
public class MaxSubSum
{
	static private int seqStart = 0;
    static private int seqEnd = -1;

	public static void main( String [ ] args )
	{
		for(int size = 50; size < 100000000; size*=10)
		{
			long start = System.nanoTime();
			int a[] = new int[size];
			Random rand = new Random();
			for( int j = 0; j < size; j++ )
				a[j] = rand.nextInt(100) - 50;
			long end = System.nanoTime();
			System.out.println("Create:" + size + "\t Runtime: " + String.format( "%12.6f",((end-start)/Math.pow(10,9))));

			if(size < 50000)
			{
				start = System.nanoTime();
				System.out.print("    N^3: " + maxSubSum1(a));
				end = System.nanoTime();
				System.out.println("\t Runtime: " + String.format( "%12.6f",((end-start)/Math.pow(10,9))));
			}
			else
				System.out.println("    N^3: \t Runtime: N/A");

			if(size < 500000)
			{
				start = System.nanoTime();
				System.out.print("    N^2: " + maxSubSum2(a));
				end = System.nanoTime();
				System.out.println("\t Runtime: " + String.format( "%12.6f",((end-start)/Math.pow(10,9))));
			}
			else
				System.out.println("    N^2: \t Runtime: N/A");

			if(size < 500000000)
			{
				start = System.nanoTime();
				System.out.print("N Log N: " + maxSubSum3(a));
				end = System.nanoTime();
				System.out.println("\t Runtime: " + String.format( "%12.6f",((end-start)/Math.pow(10,9))));
			}
			else
				System.out.println("N Log N: \t Runtime: N/A");
			start = System.nanoTime();
			System.out.print("      N: " + maxSubSum4(a));
			end = System.nanoTime();
			System.out.println("\t Runtime: " + String.format( "%12.6f",((end-start)/Math.pow(10,9))));
			System.out.println();
		}
	}

	/**
	* Cubic maximum contiguous subsequence sum algorithm.
	* seqStart and seqEnd represent the actual best sequence.
	*/
	public static int maxSubSum1( int [ ] a )
	{
		int maxSum = 0;
		for( int i = 0; i < a.length; i++ )//O(N^3)
		{
			for( int j = i; j < a.length; j++ )//O(N^2)
			{
				int thisSum = 0;
				for( int k = i; k <= j; k++ )//O(N)
					thisSum += a[ k ];
				if( thisSum > maxSum )
				{
					maxSum   = thisSum;
					seqStart = i;
					seqEnd   = j;
				}
			}
		}
		return maxSum;
	}
	/**
	* Quadratic maximum contiguous subsequence sum algorithm.
	* seqStart and seqEnd represent the actual best sequence.
	*/
	public static int maxSubSum2( int [ ] a )
	{
		int maxSum = 0;
		for( int i = 0; i < a.length; i++ )//O(N^2)
		{
			int thisSum = 0;
			for( int j = i; j < a.length; j++ )//O(N)
			{
				thisSum += a[ j ];
				if( thisSum > maxSum )
				{
					maxSum = thisSum;
					seqStart = i;
					seqEnd   = j;
				}
			}
		}
		return maxSum;
	}
	/**
	* Driver for divide-and-conquer maximum contiguous
	* subsequence sum algorithm.
	*/
	public static int maxSubSum3( int [ ] a )
	{
		return a.length > 0 ? maxSumRec( a, 0, a.length - 1 ) : 0;
	}
	/**
	* Recursive maximum contiguous subsequence sum algorithm.
	* Finds maximum sum in subarray spanning a[left..right].
	* Does not attempt to maintain actual best sequence.
	*/
	private static int maxSumRec( int [ ] a, int left, int right )
	{
		int maxLeftBorderSum = 0, maxRightBorderSum = 0;
		int leftBorderSum = 0, rightBorderSum = 0;
		int center = ( left + right ) / 2;
		if( left == right )  // Base case
			return a[ left ] > 0 ? a[ left ] : 0;
		int maxLeftSum  = maxSumRec( a, left, center );
		int maxRightSum = maxSumRec( a, center + 1, right );
		for( int i = center; i >= left; i-- )
		{
			leftBorderSum += a[ i ];
			if( leftBorderSum > maxLeftBorderSum )
				maxLeftBorderSum = leftBorderSum;
		}
		for( int i = center + 1; i <= right; i++ )
		{
			rightBorderSum += a[ i ];
			if( rightBorderSum > maxRightBorderSum )
				maxRightBorderSum = rightBorderSum;
		}
		return max3( maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum );
	}
	/**
	* Return maximum of three integers.
	*/
	private static int max3( int a, int b, int c )
	{
		return a > b ? a > c ? a : c : b > c ? b : c;
	}
	/**
	* Linear-time maximum contiguous subsequence sum algorithm.
	* seqStart and seqEnd represent the actual best sequence.
	*/
	public static int maxSubSum4( int [ ] a )
	{
		int maxSum = 0;
		int thisSum = 0;
		for( int i = 0, j = 0; j < a.length; j++ )
		{
			thisSum += a[ j ];
			if( thisSum > maxSum )
			{
				maxSum = thisSum;
				seqStart = i;
				seqEnd   = j;
			}
			else if( thisSum < 0 )
			{
				i = j + 1;
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
