/*public class BinaryTreeLevelTraverse{
	public void printLevelOrder(){
		for (int i = 0 ; i < height(root); i++)
			printLevel(root, i);
	}
	public void printLevel(Node root,int level){
		if (root == null)
	        return;
		else if (level == 1)
	        System.out.print(root.value + ", ");
	    else if (level > 1){
	        printLevel(root.left, level - 1);
	        printLevel(root.right, level - 1);
	    }
	}
	public int height(Node root){
		int leftH = height(root.left);
		int rightH = height(root.right);
		if (root == null)
			return 0;
		else{
			if (leftH > rightH)
				return(leftH + 1);
			else 
				return(rightH + 1);
		}
	}
}
*/
//Time Complexity - O(N) where N is the number of nodes in the binary tree