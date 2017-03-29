package weeklyAssignments;
//Christian Resendiz

import java.util.*;

public class InfixPostfixConverter {

	private static String keyword;
	private static String infix = "Infix";
	private static String postfix = "Postfix";
	private static String infixFormula, postfixFormula;
	private static String postfixFormulaResult;
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void input(){
		System.out.println("Enter the keyword (Infix/Postfix) of the expression you would like to convert.");
		keyword = scan.nextLine();
		while(!(keyword.equalsIgnoreCase(infix) || keyword.equalsIgnoreCase(postfix))){
			System.out.println("Please enter a valid keyword.");
			keyword = scan.nextLine();
		}
		if(keyword.equalsIgnoreCase(infix)){
			System.out.println("Please enter your Infix expression.");
			infixFormula = scan.nextLine();
		}else if(keyword.equalsIgnoreCase(postfix)){
			System.out.println("Please enter your Postfix expression.");
			postfixFormula = scan.nextLine();
		}
	}
	
	private static boolean isOperator(char ch)
	{
		if(ch == '+' || ch == '-' || ch == '*' || ch =='/' || ch == '^' || ch == '%')
			return true;
		return false;
	}
	
	private boolean isOperand(char ch)
	{
		if(!(ch == '+' || ch == '-' || ch == '*' || ch =='/' || ch == '^' || ch == '%'))
			return true;
		return false;
	}
	
	private boolean checkPrecedence(char ch1, char ch2)
	{
		if((ch2 == '+' || ch2 == '-') && (ch1 == '+' || ch1 == '-'))
			return true;
		else if((ch2 == '*' || ch2 == '/' || ch2 == '%') && (ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/' || ch1 == '%'))
			return true;
		else if((ch2 == '^') && (ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/' || ch1 == '%'))
			return true;
		else
			return false;
	}
	
	public String convertInfix(String infix){
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		stack.push('#');  //symbol to denote end of stack
		 
		for(int i = 0; i < infix.length(); i++)
		{
			char ch = infix.charAt(i);
			if(isOperator(ch))
			{
				while(checkPrecedence(ch, stack.peek()))
					postfix += stack.pop();
				stack.push(ch);
			}else if(ch == '(')
				stack.push(ch);
			else if(ch == ')')
			{
				while(stack.peek() != '(') 
					postfix += stack.pop();
				stack.pop();
			}else
				postfix += ch;
		}
		//any elements of stack left are popped
		while(stack.peek() != '#')
		{
			postfix += stack.pop();
		}
		return postfix;
	}
	
	public String convertPostfix(String postfix){
		String infix = "";
		Stack<String> stack = new Stack<>();
		   
		  for(int i = 0; i < postfix.length(); i++)
		  {
			  char inputSymbol = postfix.charAt(i);
			  if(isOperand(inputSymbol))
				  stack.push(""+inputSymbol);
			  else if(isOperator(inputSymbol))
			  {
				  String secondElement = stack.pop();
				  String firstElement = stack.pop();
				  stack.push("("+firstElement+inputSymbol+secondElement+")");
			  }
		 }
		  infix = stack.pop();
		  return infix;
	}
	
	public static double postfixEvaluation(String postfix){
		double result = 0.0;
		int n = postfix.length();
		MyStack<Double> stack = new MyStack<Double>();
		for(int i = 0; i < n; i++)
		{
			char ch = postfix.charAt(i);
			if(ch >= '0' && ch <= '9')
				stack.push((double)(ch-'0'));
			else
			{
				double x = (double) stack.pop();
				double y = (double) stack.pop();
				switch(ch)
				{
					case '+':result=x+y;
						break;
					case '-':result=y-x;
						break;
					case '*':result=x*y;
						break;
					case '/':result=y/x;
						break;
					case '^':result=Math.pow(y, x);
						break;
					case '%':result=x%y;
						break;
					default:result=0;
				}
				stack.push(result);
			}
		}
		result = (double) stack.pop();
		return(result);
	}
	
	public static void main(String[] args) {
		input();
		InfixPostfixConverter convert = new InfixPostfixConverter();
		if(keyword.equalsIgnoreCase(infix))
		{
			String yn;
			postfixFormulaResult = convert.convertInfix(infixFormula);
			System.out.println("Infix : "+ infixFormula);
			System.out.println("Postfix : "+ postfixFormulaResult);
			System.out.println("Would you like to evaluate this Postfix expression? (Y/N)");
			yn = scan.nextLine();
			if(yn.equalsIgnoreCase("y"))
				System.out.println("Postfix Evaluation : " + postfixEvaluation(postfixFormulaResult));
			else if(yn.equalsIgnoreCase("n"))
				return;
			else{
				while(!(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n"))){
					System.out.println("You must enter either Y or N.");
					yn = scan.nextLine();
				}
			}
		}else{
			System.out.println("Postfix : "+ postfixFormula);
			System.out.println("Infix : "+convert.convertPostfix(postfixFormula));
		}
	}
}