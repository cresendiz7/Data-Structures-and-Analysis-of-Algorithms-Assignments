package inClassAssignments.chapter3;

public class MyArrayListGeneric<E> {
	private E[] arr;
	private int size;
	public MyArrayListGeneric(E[] arr) {
		super();
		this.arr = arr;
		this.size = arr.length;
	}
	public MyArrayListGeneric() {
		super();
		arr = (E[])new Object[10];
		size = 0;
	}
	public MyArrayListGeneric(int size) {
		super();
		this.size = 0;
		arr = (E[])new Object[size];
	}
	public void ensureCapacity(int size)
	{
		if(arr.length < size)
			growArray(size);
	}
	private void growArray(int size)
	{
		if(size <= arr.length)
			size = arr.length*2;
		E[] temp = (E[])new Object[size];
		for(int i = 0; i < size; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}
	private void growArray()
	{
		growArray(0);
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
	public void insert(E val, int index)//O(N) to O(1)
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
	public void add(E val)//O(1)
	{
		insert(val, size);
	}
	public int find(E val)//O(N)
	{
		int index = -1;
		for(int i = 0; i < size; i++)
		{
			if(arr[i].equals(val))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	public void remove(E val)//O(N+N) = O(N)
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
	public E get(int index)//O(1)
	{
		if(index >= 0 && index < size)
			return arr[index];
		else
			return null;
	}
	
}
