package inClassAssignments.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Sorting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeSort(new Integer[]{1,5,7,2,4,9,1});
	}

	public static void mergeSort(Comparable[] arr)
	{
		//call mergeSort(arr, temp[], 0, length-1)
		mergeSort(arr, new Comparable[arr.length], 0, arr.length-1);
	}
	public static void mergeSort(Comparable[] arr, Comparable[] temp, int left, int right)
	{

		//if left < right
		if(left < right)
		{
			//System.out.println(left + ":" + right);
			//find center
			int center = (left+right)/2;
			//call mergeSort on left half (left,center)
			mergeSort(arr, temp, left, center);
			//call mergeSort on right half (center+1,right)
			mergeSort(arr, temp, center+1, right);
			//call merge over left/right halves
			merge(arr, temp, left, center+1, right);
		}
	}
	public static void merge(Comparable[] arr, Comparable[] temp, int leftStart, int rightStart, int rightEnd)
	{
		//determine leftEnd
		int leftEnd = rightStart - 1;
		//set temp array position (same as left start)
		int pos = leftStart;
		//determine number of elements (end - start + 1)
		int count = rightEnd - leftStart + 1;
		//while items left in both lists
		while(leftStart <= leftEnd && rightStart <= rightEnd)
		{
			//put smaller into temp array, move pointers forward
			if(arr[leftStart].compareTo(arr[rightStart]) <= 0)
			{
				temp[pos] = arr[leftStart];
				pos++;
				leftStart++;
			}
			else
			{
				temp[pos] = arr[rightStart];
				pos++;
				rightStart++;
			}
		}
		//while items left in either list
		while(leftStart <= leftEnd)
		{
			//add left over items to end of temp array
			temp[pos] = arr[leftStart];
			pos++;
			leftStart++;
		}
		while(rightStart <= rightEnd)
		{
			//add left over items to end of temp array
			temp[pos] = arr[rightStart];
			pos++;
			rightStart++;
		}
		//merge temp data to original using number of items and rightEnd
		for(;count > 0; count--)
		{
			arr[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}
	public static void quicksort(List<Comparable> lst)
	{
		//if list has more than 1 item
		if(lst.size() > 20)
		{
			//create 3 lists (smaller, same, larger)
			List<Comparable> smaller = new ArrayList<Comparable>();
			List<Comparable> same = new ArrayList<Comparable>();
			List<Comparable> larger = new ArrayList<Comparable>();

			//pick item for middle
			//Comparable middle = lst.get(0);//get first item//not efficient
			Comparable first = lst.get(0);
			Comparable last = lst.get(lst.size()-1);
			Comparable middle = lst.get(lst.size()/2);
			if(first.compareTo(last) > 0 && first.compareTo(middle) > 0)
			{
				if(last.compareTo(middle) > 0)
					middle = last;
			}
			else if(first.compareTo(last) < 0 && first.compareTo(middle) < 0)
			{
				if(last.compareTo(middle) < 0)
					middle = last;
			}
			else
				middle = first;
			//loop through list putting items into correct containers
			for(Comparable i : lst)
			{
				if(middle.compareTo(i) < 0)
					smaller.add(i);
				else if(middle.compareTo(i) > 0)
					larger.add(i);
				else
					same.add(i);
			}
			//recursively sort smaller/larger
			quicksort(smaller);
			quicksort(larger);
			//put all items into original list [.clear(), .addAll()]
			lst.clear();
			lst.addAll(smaller);
			lst.addAll(same);
			lst.addAll(larger);
		}
		else if(lst.size() > 1)
			insertionSort();//improve efficiency on small lists
	}

	private static void insertionSort() {
		// TODO Auto-generated method stub
		
	}

}
