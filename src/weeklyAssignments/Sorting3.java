package weeklyAssignments;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting3 {

	public static void main(String[] args) {
		String[] strarr = new String[]{"Words","wor","WOrDs","wOrDS","WORDS","WorD","wordS","TwoWords", "ab", "ABCDEF"};
		System.out.println("Unsorted : " + Arrays.toString(strarr));
		radixSortStrings(strarr);
		System.out.println("Sorted   : " + Arrays.toString(strarr));
	}
	
	@SuppressWarnings("unchecked")
	public static void radixSortStrings(String[] arr)
	{
		//number of buckets = 256 (characters in the character set)
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size
		int buckets = 256;
		int stringLen = 0;
		
		for ( int i = 0; i < arr.length; i ++ )
		{
			if( stringLen <= arr[i].length() )
				stringLen = arr[i].length();
		}
		
		String[][] wordLengthArr = new String[stringLen + 1][stringLen + 1];
		//Buckets need to be lists instead of counters
		ArrayList<String>[] bucket = new ArrayList[buckets];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets; i++)
		{
			bucket[i] = new ArrayList<>();
		}
		
		for ( String word : arr )
		{
			int i = 0;
			while ( wordLengthArr[word.length()][i] != null )
			{
				i++;
			}
			wordLengthArr[word.length()][i] = word;
		}
		//pointer for position in original list
		int index = 0;
		for ( int i = 0; i < wordLengthArr.length; i++ )
		{
			for ( int j = 0; j < wordLengthArr[i].length; j++)
			{
				if ( wordLengthArr[i][j] != null)
					arr[index++] = wordLengthArr[i][j];
			}
		}
		
		//loop from end of string to beginning
		int startIndex = arr.length;
		for(int i = stringLen-1; i >= 0; i--)
		{
			int temp = 0;
			for ( int j = 0; j < wordLengthArr[i + 1].length; j++)
			{
				if ( wordLengthArr[i + 1][j] != null)
					temp++;
			}
			startIndex -= temp;
			
			//loop through each string
			for(int j = startIndex; j < arr.length; j++)
			{
				//add to appropriate bucket
				bucket[(int)arr[j].charAt(i)].add(arr[j]);
			}
			index = startIndex;
			
			//loop through buckets
			for(int k = 0; k < buckets; k++)
			{
				//add each string back to original array in new order
				for(String s : bucket[k])
				{
					arr[index] = s;
					index++;
				}
				//clear the bucket
				bucket[k].clear();
			}
			index = 0;
		}
	}
}
