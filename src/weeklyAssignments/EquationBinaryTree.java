package weeklyAssignments;
import java.util.*;

public class EquationBinaryTree {
	private EquationTreeNode root;
	private String keyword;
	private String infix = "Infix";
	private String postfix = "Postfix";
	private String prefix = "Prefix";
	private String infixFormula, postfixFormula, prefixFormula;
	private Scanner scan = new Scanner(System.in);
	
	public EquationBinaryTree()
	{
		root = null;
	}
	//populating tree from infix
	private class EquationTreeNode{
		String value;
		EquationTreeNode left;
		EquationTreeNode right;
		public EquationTreeNode(String v)
		{
			value = v;
			left = null;
			right = null;
		}
		public String toString()
		{
			return value.toString();
		}
	}

	public void populateFromInfix(String inf)
	{
		root = populateInfixHelper(inf);
	}
	
	//recursive helper to break down infix formula
	private EquationTreeNode populateInfixHelper(String inf)
	{
		EquationTreeNode node;
		if(inf.length() == 1)
		{
			node = new EquationTreeNode(inf);
		}
		else
		{
			//break down infix into 3 parts, begin, end, middle
			String[] parts = infixBreakdownHelper(inf);
			node = new EquationTreeNode(parts[2]);
			if(!parts[0].equals(""))
				node.left = populateInfixHelper(parts[0]);
			if(!parts[1].equals(""))
				node.right = populateInfixHelper(parts[1]);
		}
		return node;
	}
	//breakdown infix into 3 parts
	private String[] infixBreakdownHelper(String inf)
	{
		String[] parts = new String[3];
		//remove leading/trailing parens
		inf = inf.substring(1, inf.length()-1);//(a+(b*c))+(((d*e)+f)*g)
		int parenCount = 0;
		int i = 0;
		for(i = 0; i < inf.length(); i++)
		{
			if(inf.charAt(i) == '(')
				parenCount++;
			else if(inf.charAt(i) == ')')
				parenCount--;
			if(parenCount == 0)
				break;
		}
		parts[0] = inf.substring(0, i+1);//(a+(b*c))
		parts[1] = inf.substring(i+2);//(((d*e)+f)*g)
		parts[2] = ""+inf.charAt(i+1);//+
		return parts;
	}

	//print tree as infix
	public String printInfix()
	{
		String output = "";
		output += printInfixHelper(root);
		return output;
	}
	private String printInfixHelper(EquationTreeNode node)
	{
		String output = "";
		if(node.left != null)
		{
			output += "(";
			output += printInfixHelper(node.left);
		}
		output += node;
		if(node.right != null)
		{
			output += printInfixHelper(node.right);
			output += ")";
		}
		return output;
	}

	//print tree as postfix
	public String printPostfix()
	{
		String output = "";
		output += printPostfixHelper(root);
		return output;
	}
	private String printPostfixHelper(EquationTreeNode node)
	{
		String output = "";
		if(node.left != null)
		{
			output += printPostfixHelper(node.left);
		}
		if(node.right != null)
		{
			output += printPostfixHelper(node.right);
		}
		output += node;
		return output;
	}
	//print tree as prefix
	public String printPrefix()
	{
		String output = "";
		output += printPrefixHelper(root);
		return output;
	}
	private String printPrefixHelper(EquationTreeNode node)
	{
		String output = "";
		output += node;
		if(node.left != null)
		{
			output += printPrefixHelper(node.left);
		}
		if(node.right != null)
		{
			output += printPrefixHelper(node.right);
		}
		return output;
	}
	
	private boolean isOperator(char ch)
	{
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%')
			return true;
		return false;
	}
	
	//populating tree from postfix
	public void populateFromPostfix(String postfix)
	{
		root = populatePostfixHelper(postfix);
	}
	
	private EquationTreeNode populatePostfixHelper(String postfix){
		Stack<EquationTreeNode> treeStack = new Stack<>();
		EquationTreeNode node;
		
		char[] charArray = postfix.toCharArray();
		for(int i = 0; i < charArray.length; i++){
			//if Operand, push into stack
			if(!isOperator(charArray[i])){
				String value = String.valueOf(charArray[i]);
				node = new EquationTreeNode(value);
				treeStack.push(node);
			}else//Operator
				{
				String value = String.valueOf(charArray[i]);
				node = new EquationTreeNode(value);
				node.right = treeStack.pop();
				node.left = treeStack.pop();
				treeStack.push(node);
			}
		}
		node = treeStack.pop();
		return node;
	}
	
	//populating tree from prefix
	public void populateFromPrefix(String prefix)
	{
		root = populatePrefixHelper(prefix);
	}
	
	private EquationTreeNode populatePrefixHelper(String prefix){
		Stack<EquationTreeNode> treeStack = new Stack<>();
		EquationTreeNode node, node1, node2;
		
		char[] charArray = prefix.toCharArray();
		for(int i = charArray.length -1; i != -1; i--){
			//if Operand, push into stack
			if(!isOperator(charArray[i])){
				String value = String.valueOf(charArray[i]);
				node = new EquationTreeNode(value);
				treeStack.push(node);
			}else//Operator
				{
				node1 = treeStack.pop();
				node2 = treeStack.pop();
				String value = String.valueOf(charArray[i]);
				node = new EquationTreeNode(value);
				node.left = node1;
				node.right = node2;
				treeStack.push(node);
			}
		}
		node = treeStack.pop();
		return node;
	}
	
	//gets keyword from user to determine which expression to accept and then prints all three expressions based on input
	public void input(){
		System.out.println("Enter the keyword (Infix/Postfix/Prefix) of the expression you would like to convert:");
		keyword = scan.nextLine();
		while(!(keyword.equalsIgnoreCase(infix) || keyword.equalsIgnoreCase(postfix) || keyword.equalsIgnoreCase(prefix))){
			System.out.println("Please enter a valid keyword.");
			keyword = scan.nextLine();
		}
		if(keyword.equalsIgnoreCase(infix)){
			System.out.println("Please enter your Infix Expression: (Must include parentheses)");
			infixFormula = scan.nextLine();
			populateFromInfix(infixFormula);
			printAll();
		}else if(keyword.equalsIgnoreCase(postfix)){
			System.out.println("Please enter your Postfix Expression:");
			postfixFormula = scan.nextLine();
			populateFromPostfix(postfixFormula);
			printAll();
		}else if(keyword.equalsIgnoreCase(prefix)){
			System.out.println("Please enter your Prefix Expression:");
			prefixFormula = scan.nextLine();
			populateFromPrefix(prefixFormula);
			printAll();
		}
	}
	
	//prints all the expressions
	public void printAll(){
		System.out.println("Infix   : " + printInfix());
		System.out.println("Postfix : " + printPostfix());
		System.out.println("Prefix  : " + printPrefix());
	}
	
	public static void main(String[] args) {
		EquationBinaryTree ebt = new EquationBinaryTree();
		ebt.input();
	}
}