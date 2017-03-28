//Christian Resendiz

public class TestMyQueue {
	public static void main(String[] args) {
		MyQueue<String> testNumbers = new MyQueue<>();
		testNumbers.insert("1");
		testNumbers.insert("2");
		testNumbers.insert("3");
		testNumbers.insert("4");
		testNumbers.insert("5");
		testNumbers.printQueue();
		testNumbers.remove();
		testNumbers.printQueue();
		testNumbers.remove();
		testNumbers.printQueue();
		System.out.println("First Node = " + testNumbers.peek());
		System.out.println("Size = " + testNumbers.getSize());
	}
}
