package inClassAssignments.chapter3;

public class MyStack<E> {
	private MyLinkedListNode<E> top;
	private int size;
	public MyStack()
	{
		top = null;
		size = 0;
	}
	public int getSize()
	{
		return size;
	}
	public void push(E val)
	{
		MyLinkedListNode<E> newItem = new MyLinkedListNode<E>(val);
		newItem.next = top;
		top = newItem;
		size++;
	}
	public E pop()
	{
		if(top != null)
		{
			E data = top.value;
			top = top.next;
			size--;
			return data;
		}
		else
			return null;
	}
	public E top()
	{
		if(top != null)
			return top.value;
		else
			return null;
	}
	public E peek()
	{
		return top();
	}

	public class MyLinkedListNode<E>{
		public MyLinkedListNode next;
		public E value;
		public MyLinkedListNode(E v)
		{
			value = v;
			next = null;
		}
	}
}
