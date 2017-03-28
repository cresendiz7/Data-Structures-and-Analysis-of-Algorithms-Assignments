public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
	private static class BinaryNode<AnyType>{
	@SuppressWarnings("unused")
	// Constructors
		BinaryNode( AnyType theElement )
		{ this( theElement, null, null ); }
		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
		{ element = theElement; left = lt; right = rt; deleted = false;}
		AnyType element; // The data in the node
		BinaryNode<AnyType> left; // Left child
		BinaryNode<AnyType> right; // Right child
		boolean deleted;
	}
	private BinaryNode<AnyType> root;
	private int size;
	private int deleteCount;
	
	public BinarySearchTree( )
	{ root = null; }

	public void makeEmpty( )
	{ root = null; }
	
	public boolean isEmpty( )
	{ return root == null; }

	public boolean contains( AnyType x )
	{ return contains( x, root ); }
	
	public void insert( AnyType x )
	{ root = insert( x, root ); }
	
	public void remove( AnyType x ){ 
		root = remove( x, root );
		if(size < deleteCount)
			root = removeNode(x, root);
	}
	
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}
	
	public AnyType findMin() {
		if (isEmpty() == true) {
			return null;
		}
		return findMin(root).element;
	}
	
	public AnyType findMax() {
		if (isEmpty() == true) {
			return null;
		}
		return findMax(root).element;
	}
	
	/**
	* Internal method to find an item in a subtree.
	* @param x is item to search for.
	* @param t the node that roots the subtree.
	* @return node containing the matched item.
	*/
	private boolean contains( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return false;
		
		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return contains( x, t.left );
		else if( compareResult > 0 )
			return contains( x, t.right );
		else
			return !t.deleted;
	}

	/**
	* Internal method to find the smallest item in a subtree.
	* @param t the node that roots the subtree.
	* @return node containing the smallest item.
	*/
	@SuppressWarnings("unchecked")
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
	{
		if( t == null )
			return null;
		BinaryNode<AnyType> lMin = findMin(t.left);
		if(lMin != null)
			return lMin;
		if (!t.deleted)
			return (BinaryNode<AnyType>) t.element;
		return findMin(t.right);
	}
	
	/**
	* Internal method to find the largest item in a subtree.
	* @param t the node that roots the subtree.
	* @return node containing the largest item.
	*/
	@SuppressWarnings("unchecked")
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
	{
		if (t == null)
			return null;
		BinaryNode<AnyType> rMax = findMax(t.right);
		if(rMax != null)
			return rMax;
		if (!t.deleted)
			return (BinaryNode<AnyType>) t.element;
		return findMax(t.right);
	}
	
	/**
	* Internal method to insert into a subtree.
	* @param x the item to insert.
	* @param t the node that roots the subtree.
	* @return the new root of the subtree.
	*/
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null ){
			size++;
			return new BinaryNode<AnyType>( x, null, null );
		}
		
		int compareResult = x.compareTo( t.element );
		
		if( compareResult < 0 )
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
			t.right = insert( x, t.right );
		else if (t.deleted){
			t.deleted = false;
			size++;
			deleteCount--;
		}
		return t;
	}

	/**
	* Internal method to remove from a subtree.
	* @param x the item to remove.
	* @param t the node that roots the subtree.
	* @return the new root of the subtree.
	*/
	private BinaryNode<AnyType> removeNode( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return t; // Item not found; do nothing

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = removeNode( x, t.left );
		else if( compareResult > 0 )
			t.right = removeNode( x, t.right );
		if(t.deleted){
			if( t.left != null && t.right != null ){ 
				BinaryNode<AnyType> rMinNode = t.right;
				BinaryNode<AnyType> rMNParent = t;
				while(rMinNode.left != null){
					rMNParent = rMinNode;
					rMinNode = rMinNode.left;
				}
				t.element = rMinNode.element;
				t.deleted = false;
				if(rMNParent == t)
					rMNParent.right = null;
				rMNParent.left = rMinNode.right;
			}else
				t = ( t.left == null ) ? t.left : t.right;
		}
		return t;
	}
	
	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return t; // Item not found; do nothing

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = removeNode( x, t.left );
		else if( compareResult > 0 )
			t.right = removeNode( x, t.right );
		else if( !t.deleted){
			t.deleted = true;
			size--;
			deleteCount++;
		}
		return t;
	}
	
	/**
	* Internal method to print a subtree in sorted order.
	* @param t the node that roots the subtree.
	*/
	private void printTree( BinaryNode<AnyType> t )
	{
		if( t != null )
		{
			printTree( t.left );
			System.out.println( t.element );
			printTree( t.right );
		}
	}
}
