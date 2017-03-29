package inClassAssignments.chapter3;

public class TestBrackets {

	public static void main(String[] args) {
		
		String code = "main(String[] args) {}";
		System.out.println("Code is " + ((checkCode(code))?"Correct":"Not Correct"));
		
		code = "main(String[) args) {}";
		System.out.println("Code is " + ((checkCode(code))?"Correct":"Not Correct"));

	}
	public static boolean checkCode(String code)
	{
		MyStack<Character> symbols = new MyStack<>();
		boolean correct = true;
		for(int i = 0; i < code.length(); i++)
		{
			switch(code.charAt(i))
			{
			case '(':
			case '[':
			case '{':
			case '<':
				symbols.push(code.charAt(i));
				break;
			case ')':
				if(!symbols.pop().equals('('))
					correct = false;
				break;
			case ']':
				if(!symbols.pop().equals('['))
					correct = false;
				break;
			case '}':
				if(!symbols.pop().equals('{'))
					correct = false;
				break;
			case '>':
				if(!symbols.pop().equals('<'))
					correct = false;
				break;
			}
			if(!correct)
				break;
		}
		return correct;
	}

}
