package inClassAssignments.chapter1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		//Random Numbers: http://textmechanic.com/text-tools/numeration-tools/generate-list-numbers/
		long startTime = System.nanoTime();
		//Open file for reading
		Scanner s = new Scanner(new File("random100.txt"));
		//Create ArrayList for all values
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//Read until end of file is reached
		while(s.hasNextInt())
		{
			//Add each value found to the ArrayList
			nums.add(s.nextInt());
		}
		long endReadFile = System.nanoTime();
		//Loop through each value in the ArrayList
		for(int n : nums)
		{
			System.out.println(n);
		}
		long endProgram = System.nanoTime();
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFile-startTime)/Math.pow(10,9))));
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgram-startTime)/Math.pow(10,9))));
	}
}