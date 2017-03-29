package inClassAssignments.chapter1;

public class Runtime {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		//run code here
		long endTime = System.nanoTime();
		System.out.println("Runtime:" + 
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));

	}

}
