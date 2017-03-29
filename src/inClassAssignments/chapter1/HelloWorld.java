package inClassAssignments.chapter1;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner scan = new Scanner(System.in);
		System.out.print("What is your name:");
		String name = scan.nextLine();
		System.out.println("Hello " + name);
	}

}
