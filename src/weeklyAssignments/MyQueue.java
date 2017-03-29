package weeklyAssignments;
//Christian Resendiz

public class MyQueue<E>{
	private Node<E> front, rear; 
	private int size;   
	
	public MyQueue()
	{
    	 front = null;
	     rear  = null;
	     size = 0;
    }
	
	public boolean isEmpty() 
    {
        return front == null;
    }
	
    public int getSize() 
    {
        return size;     
    }
    
    public void insert(E data)
    {
        Node<E> node = new Node<E>(data, null);
        if (rear == null)
        {
            front = node;
            rear = node;
        }
        else
        {
            rear.setLink(node);
            rear = rear.getLink();
        }
        size++ ;
    }
    
    public E remove()
    {
        if (isEmpty() )
            return null;
        Node<E> ptr = front;
        front = ptr.getLink();
        if (front == null)
            rear = null;
        size-- ;
        return (E) ptr.getData();
    } 

	public E peek()
	{
		if(isEmpty())
			return null;
		return front.data;
	}
	
	public void printQueue()
    {
        System.out.print("\nQueue = ");
        if(isEmpty())
        {
            System.out.print("Empty\n");
            return ;
        }
        Node<E> ptr = front;
        while (ptr != rear.getLink() )
        {
            System.out.print(ptr.getData()+", ");
            ptr = ptr.getLink();
        }
    }
	
	public class Node<E>{
    	public E data;
    	public Node<E> link;
    	
    	public Node(E d)
    	{
    		link = null;
    		data = d;
    	}
    	
    	public Node(E d,Node<E> n)
    	{
    		data = d;
    		link = n;
    	}
    	
    	public void setLink(Node<E> n)
        {
            link = n;
        }   
    	
        public void setData(E d)
        {
            data = d;
        }    
        
        public Node<E> getLink()
        {
            return link;
        }    
        
        public E getData()
        {
            return data;
        }
    }
}
