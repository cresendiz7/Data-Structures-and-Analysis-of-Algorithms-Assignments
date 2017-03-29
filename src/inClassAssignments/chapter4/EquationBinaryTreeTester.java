package inClassAssignments.chapter4;

public class EquationBinaryTreeTester {

	public static void main(String[] args) {
		String infix = "a+b";
		EquationBinaryTree ebt = new EquationBinaryTree();
		ebt.populateFromInfix(infix);
		System.out.println(ebt.printInfix());
		System.out.println(ebt.printPostfix());
		System.out.println(ebt.printPrefix());
	}
}
