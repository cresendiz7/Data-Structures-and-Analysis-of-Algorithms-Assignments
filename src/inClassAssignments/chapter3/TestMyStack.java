package inClassAssignments.chapter3;

public class TestMyStack {

	public static void main(String[] args) {
		MyStack<String> names = new MyStack<>();
		names.push("JET");
		names.push("Billy");
		System.out.println(names.peek());
		names.push("Bob");
		System.out.println("\nAll Names:");
		while(names.getSize() > 0)
		{
			System.out.println(names.pop());
		}

	}

}
