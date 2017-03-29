package inClassAssignments.chapter1;

public class Example {

	public static void main(String[] args) {
		Interfaces i1 = new Interfaces("Test");
		Interfaces i2 = new Interfaces("test");

		System.out.println(i1.compareTo(i2));

	}
	
	public static <genericType> void myMethod(genericType n)
	{
		
	}

}
