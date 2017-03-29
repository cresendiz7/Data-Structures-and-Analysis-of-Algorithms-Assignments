package weeklyAssignments;
//Christian Resendiz

public class MyLinkedList {
	private node start;
	private int size;
	public MyLinkedList()
	{
		start = null;
		size = 0;
	}
	
	node head; 
	public void swapNodes(int x, int y)
    {
		node head = null;
        if(x == y){
        	return;
        }
 
        node previousX = null, currentX = head;
        while(currentX != null && currentX.data != x)
        {
            previousX = currentX;
            currentX = currentX.next;
        }
 
        node previousY = null, currentY = head;
        while(currentY != null && currentY.data != y)
        {
        	previousY = currentY;
        	currentY = currentY.next;
        }
 
        if(currentX == null || currentY == null){
        	return;
        }
        
        if(previousX != null){
            previousX.next = currentY;
        }else{
            head = currentY;
        }
 
        if(previousY != null){
            previousY.next = currentX;
        }else{
            head = currentX;
        }
        
        node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
    }
	
	public String printList()//O(N)
	{
		String output = "";
		node current = start;
		boolean first = true;
		while(current != null)
		{
			if(!first)
				output += ", ";
			output += current.value;
			current = current.next;
			first = false;
		}
		return output;
	}
	public void insert(int val, int index)//O(N) to O(1)
	{
		if(index > size || index < 0)
			index = size;
		node newItem = new node(val);
		if(index == 0)
		{
			newItem.next = start;
			start = newItem;
		}
		else
		{
			node current = start;
			for(int i = 1; i < index; i++)
			{
				current = current.next;
			}
			//current, new, current.next
			newItem.next = current.next;
			current.next = newItem;
		}
		size++;
	}
	public void add(int val)//O(N)
	{
		insert(val, size);
	}
	public int find(int val)//O(N)
	{
		node current = start;
		int index = -1;
		for(int i = 0; i < size; i++)
		{
			if(current.value == val)
			{
				index = i;
				break;
			}
			current = current.next;
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
		if(index == 0 && size > 0)
		{
			start = start.next;
			size--;
		}
		else if(index > 0 && index < size)
		{
			node current = start;
			for(int i = 0; i < index-1; i++)
			{
				current = current.next;
			}
			//current, remove, after
			current.next = current.next.next;
			size--;
		}
	}
	public int get(int index)//O(N)
	{
		if(index >= 0 && index < size)
		{
			node current = start;
			for(int i = 0; i < index; i++)
				current = current.next;
			return current.value;
		}
		else
			return Integer.MIN_VALUE;
	}

	public class node{
		public node next;
		public int value;
		public int data;
		public node(int v)
		{
			value = v;
			next = null;
		}
	}
}
