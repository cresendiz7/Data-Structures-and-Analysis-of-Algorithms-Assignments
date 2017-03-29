package inClassAssignments.chapter5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class SeparateChainingHashTable<E> {
	private BigInteger bi = BigInteger.ZERO;
	private int size = 101;
	private LinkedList<E>[] hashTable;
	private int itemCount = 0;

	public SeparateChainingHashTable() {
		super();
		//this.size = size;
		makeEmpty();
	}
	public SeparateChainingHashTable(int size) {
		super();
		this.size = nextPrime(size);
		makeEmpty();
	}
	private int nextPrime(int num)
	{
		BigInteger b = BigInteger.valueOf(num);
		return b.nextProbablePrime().intValue();
	}
	private void makeEmpty()
	{
		hashTable = new LinkedList[this.size];
		for(int i = 0; i < hashTable.length; i++)
			hashTable[i] = new LinkedList<E>();
		itemCount = 0;
	}
	private int myHash(E obj)
	{
		return Math.abs(obj.hashCode()) % size;
	}
	public void insert(E obj)
	{
		LinkedList<E> row = hashTable[myHash(obj)];
		if(!row.contains(obj))
		{
			row.add(obj);
			itemCount++;
		}
	}
	public void remove(E obj)
	{
		LinkedList<E> row = hashTable[myHash(obj)];
		if(!row.contains(obj))
		{
			row.remove(obj);
			itemCount--;
		}
	}
	public boolean contains(E obj)
	{
		LinkedList<E> row = hashTable[myHash(obj)];
		return row.contains(obj);
	}
	public int getItemCount()
	{
		return itemCount;
	}
	@Override
	public String toString() {
		String output = "";
		int pos = 0;
		for(LinkedList<E> l : hashTable)
		{
			if(l.size() > 0)
			{
				output += pos + ":" + l + "\n";
			}
			pos++;
		}
		return output;
	}
}
