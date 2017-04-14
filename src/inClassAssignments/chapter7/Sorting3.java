package inClassAssignments.chapter7;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting3 {

	public static void main(String[] args) {
		String[] strarr = new String[]{"Word","word","WORD","wOrD"};
		System.out.println(Arrays.toString(strarr));
		radixSortStrings(strarr, 4);
		System.out.println(Arrays.toString(strarr));
	}
	public static void radixSortStrings(String[] arr, int stringLen)
	{
		//number of buckets = 256 (characters in the character set)
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size
		int buckets = 256;

		//Buckets need to be lists instead of counters
		ArrayList<String>[] bucket = new ArrayList[buckets];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets; i++)
		{
			bucket[i] = new ArrayList<>();
		}

		//pointer for position in original list
		int index = 0;
		//loop from end of string to beginning
		for(int i = stringLen-1; i >= 0; i--)
		{
			//loop through each string
			for(int j = 0; j < arr.length; j++)
			{
				//add to appropriate bucket
				bucket[(int)arr[j].charAt(i)].add(arr[j]);
			}
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
