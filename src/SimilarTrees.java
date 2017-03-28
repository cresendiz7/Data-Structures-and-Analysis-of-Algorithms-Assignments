public class SimilarTrees{
	Node root1, root2;
	//Compares two binary trees based on structure
	public boolean similarTrees(Node root1, Node root2) 
	{
		//both empty -> true
		if (root1 == null && root2 == null)
			return true;
		//both non-empty -> compare them
		if (root1 != null && root2 != null) 
			return (similarTrees(root1.left, root2.left) && similarTrees(root1.right, root2.right));
		//one empty, one not -> false
		return false;
	}
	//Test the method
	public static void main(String[] args){
		SimilarTrees tree = new SimilarTrees();
		
		tree.root1 = new Node();
		tree.root1.left = new Node();
		tree.root1.right = new Node();
		tree.root1.right.right = new Node();
	  
		tree.root2 = new Node();
		tree.root2.left = new Node();
		tree.root2.right = new Node();
		tree.root2.right.right = new Node();
		double startTime = System.nanoTime();
		if (tree.similarTrees(tree.root1, tree.root2))
			System.out.println("Both binary trees are similar.");
		else
			System.out.println("Trees are not similar.");
		double endTime = System.nanoTime();
		System.out.println("Running Time: "+ ((endTime - startTime) / 1000000) + " milliseconds");
	}
	
	//Binary Tree Node
	private static class Node{
		Node left, right;
		Node(){
			left = null;
			right = null;
		}
	}
}
