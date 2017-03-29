package inClassAssignments.chapter3;

public class MyArrayList {

	private int[] arr;
	private int size;
	public MyArrayList()
	{
		arr = new int[10];
		size = 0;
	}
	public MyArrayList(int value)
	{
		arr = new int[10];
		arr[0] = value;
		size = 1;
	}
	public MyArrayList(int[] values)
	{
		arr = values;
		size = arr.length;
	}
	private void growArray()
	{
		int[] temp = new int[arr.length * 2];
		for(int i = 0; i < size; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public String printList()//O(N)
	{
		String output = "";
		for(int i = 0; i < size; i++)
		{
			if(i != 0)
				output += ", ";
			output += arr[i];
		}
		return output;
	}
	public void insert(int val, int index)//O(N) to O(1)
	{
		if(size == arr.length)
			growArray();
		if(index >= size || index < 0)//constant time
		{
			arr[size] = val;
		}
		else
		{
			for(int i = size; i > index; i--)//index time (up to N time)
			{
				arr[i] = arr[i-1];
			}
			arr[index] = val;
		}
		size++;
	}
	public void add(int val)//O(1)
	{
		insert(val, size);
	}
	public int find(int val)//O(N)
	{
		int index = -1;
		for(int i = 0; i < size; i++)
		{
			if(arr[i] == val)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	public void remove(int val)//O(N+N) = O(N)
	{
		int index = find(val);//O(N)
		if(index >= 0)
			delete(index);//O(N)
	}
	public void delete(int index)//O(N)
	{
		if(index >= 0 && index < size)
		{
			for(int i = index; i < size-1; i++)//index time (up to N time)
			{
				arr[i] = arr[i+1];
			}
			size--;
		}
	}
	public int get(int index)//O(1)
	{
		if(index >= 0 && index < size)
			return arr[index];
		else
			return Integer.MIN_VALUE;
	}
}
