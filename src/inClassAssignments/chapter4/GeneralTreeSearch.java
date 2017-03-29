package inClassAssignments.chapter4;

/*
 * We will set some rules for this GeneralTreeSearch to make inserting/finding a little more efficient
 * 1. Items smaller than a given node become children
 * 2. Items larger than a given node become siblings
 * 3. Root is allowed to have siblings
 * 
 * Without these rules, we would need to develop a way for the programmer using this class to chose where an item goes
 * This could be done by asking for what the parent would be
 */
public class GeneralTreeSearch<E extends Comparable<E>> {
	private Node<E> root;
	public GeneralTreeSearch()
	{
		root = null;
	}
	public void insert(E item)
	{
		Node<E> newItem = new Node<E>(item);
		if(root == null)//empty list
		{
			root = newItem;
		}
		else
		{
			Node<E> current = root;
			boolean inserted = false;
			while(!inserted)
			{
				//note, if we don't want to allow duplicates, we need to check for == 0 on compareTo
				if(item.compareTo(current.value) < 0)//new item is less than current node
				{
					if(current.firstChild == null)
					{
						current.firstChild = newItem;
						inserted = true;
					}
					else
					{
						current = current.firstChild;
					}
				}
				else//new item is greater/equal to current node
				{
					if(current.nextSibling == null)
					{
						current.nextSibling = newItem;
						inserted = true;
					}
					else
					{
						current = current.nextSibling;
					}
				}
			}
		}
	}
	public boolean find(E item)
	{
		boolean found = false;
		if(root != null)
		{
			Node<E> current = root;
			boolean end = false;
			while(!end)
			{
				if(item.compareTo(current.value) == 0)//found item
				{
					found = true;
					end = true;
				}
				else if(item.compareTo(current.value) < 0)//check if should be a child
				{
					if(current.firstChild == null)
					{
						end = true;//did not find
					}
					else
					{
						current = current.firstChild;
					}
				}
				else//check if should be a sibling
				{
					if(current.nextSibling == null)
					{
						end = true;//did not find
					}
					else
					{
						current = current.nextSibling;
					}
				}
			}
		}
		return found;
	}
	public void print()
	{
		if(root != null)
		{
			printSiblings(root);
		}
	}
	private void printSiblings(Node<E> curr)
	{
		System.out.print("Siblings of "+curr.value+":");
		Node<E> cursor = curr.nextSibling;
		while(cursor != null)
		{
			System.out.print(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		printChildren(curr);
		cursor = curr.nextSibling;
		while(cursor != null)
		{
			printChildren(cursor);
			cursor = cursor.nextSibling;
		}
	}
	private void printChildren(Node<E> curr)
	{
		System.out.print("Children of "+curr.value+":");
		Node<E> cursor = curr.firstChild;
		while(cursor != null)
		{
			System.out.print(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		if(curr.firstChild != null)
		{
			printSiblings(curr.firstChild);
		}
	}
	public class Node<E>{
		public E value;
		public Node<E> firstChild;
		public Node<E> nextSibling;
		public Node(E v)
		{
			value = v;
			firstChild = null;
			nextSibling = null;
		}
		public String toString()
		{
			return value.toString();
		}
	}
}
