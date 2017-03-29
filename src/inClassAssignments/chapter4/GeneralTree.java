package inClassAssignments.chapter4;

public class GeneralTree<E> {
	private Node<E> root;
	public GeneralTree()
	{
		root = null;
	}
	public void insert(E parent, E item)
	{
		Node<E> newItem = new Node<E>(item);
		if(root == null)//empty list
		{
			root = newItem;
		}
		else
		{
			Node<E> current = findNode(parent, false);
			if(current != null)//found parent
			{
				if(current.firstChild == null)//no children yet
				{
					current.firstChild = newItem;
				}
				else//has at least one child, find end of child list
				{
					current = current.firstChild;
					while(current.nextSibling != null)//work to last sibling in list
					{
						current = current.nextSibling;
					}
					current.nextSibling = newItem;
				}
			}
			//you could an else statement here to allow siblings of the root node
		}
	}
	public String find(E item)//used to test the findNode method
	{
		String output = "Search for:"+item.toString()+"\n";
		Node<E> current = findNode(item, true);
		if(current == null)
			output += "NOT FOUND";
		else
		{
			output += "Node:"+current.toString();
			if(current.nextSibling != null)
				output += "\nSibling:"+current.nextSibling;
			if(current.firstChild != null)
				output += "\nChild:"+current.firstChild;
		}
		return output+"\n";
	}
	private Node<E> findNode(E item, boolean print)
	{
		return findHelper(item, root, print);//recursive search for item
	}
	private Node<E> findHelper(E item, Node<E> current, boolean print)
	{
		Node<E> temp = null;
		if(current.value.equals(item))//check if current node is the item being looked for
		{
			temp = current;
		}
		else
		{
			if(temp == null && current.nextSibling != null)//check sibling for item
			{
				temp = findHelper(item, current.nextSibling, print);//check siblings/children of this node
			}
			if(temp == null && current.firstChild != null)//check child for item
			{
				temp = findHelper(item, current.firstChild, print);//check siblings/children of this node
			}
		}
		return temp;
	}

	public void print()
	{
		if(root != null)
		{
			printSiblings(root);//recursive print method
		}
	}
	private void printSiblings(Node<E> curr)
	{
		System.out.print("Siblings of "+curr.value+":");
		Node<E> cursor = curr.nextSibling;
		while(cursor != null)//print all siblings
		{
			System.out.print(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		printChildren(curr);//call print children on this node
		cursor = curr.nextSibling;
		while(cursor != null)//print children of all siblings
		{
			printChildren(cursor);
			cursor = cursor.nextSibling;
		}
	}
	private void printChildren(Node<E> curr)
	{
		System.out.print("Children of "+curr.value+":");
		Node<E> cursor = curr.firstChild;
		while(cursor != null)//print all children
		{
			System.out.print(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		if(curr.firstChild != null)//print siblings of child
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
			//commented out sections can be used for an unstructured recursive print of this node and all siblings/children
			String output = "";
			//output += "Node Value:";
			output += value;
			/*
			if(nextSibling != null)
				output += "\nSibling:"+nextSibling;
			if(firstChild != null)
				output += "\nChild:"+firstChild;
			*/
			return output;
		}
	}
}
