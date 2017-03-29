package weeklyAssignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Selection {
	
	public static void million() throws FileNotFoundException{
		long startTimeMillion = System.nanoTime();
		//Open file for reading
		Scanner scanMillion = new Scanner(new File("random1million.txt"));
		//Create ArrayList for all values
		ArrayList<Integer> numsMillion = new ArrayList<Integer>();
		//Read until end of file is reached
		while(scanMillion.hasNextInt()){
			//Add each value found to the ArrayList
			numsMillion.add(scanMillion.nextInt());
		}
		long endReadFileMillion = System.nanoTime();
		//Sort all values in the ArrayList in descending order
		Collections.sort(numsMillion);
		//Loop and print through each value in the ArrayList
		for(int n : numsMillion){
		System.out.println(n);
		}
		long endProgramMillion = System.nanoTime();
		int sizeMillion = numsMillion.size();
		//Print size of array (N)
		System.out.println("\nN = " + sizeMillion);
		//Print k (k = N/2)
		System.out.println("k = N/2\nk = " + sizeMillion/2);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFileMillion-startTimeMillion)/Math.pow(10,9))));
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgramMillion-startTimeMillion)/Math.pow(10,9))));
		//Close the scanner
		scanMillion.close();
	}
	
	public static void thousand() throws FileNotFoundException{
		long startTimeThousand = System.nanoTime();
		Scanner scanThousand = new Scanner(new File("random1000.txt"));
		ArrayList<Integer> numsThousand = new ArrayList<Integer>();
		while(scanThousand.hasNextInt()){
			numsThousand.add(scanThousand.nextInt());
		}
		long endReadFileThousand = System.nanoTime();
		Collections.sort(numsThousand);
		for(int n : numsThousand){
		System.out.println(n);
		}
		long endProgramThousand = System.nanoTime();
		int sizeThousand = numsThousand.size();
		System.out.println("\nN = " + sizeThousand);
		System.out.println("k = N/2\nk = " + sizeThousand/2);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFileThousand-startTimeThousand)/Math.pow(10,9))));
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgramThousand-startTimeThousand)/Math.pow(10,9))));
		scanThousand.close();
	}
	
	public static void hundred() throws FileNotFoundException{
		long startTimeHundred = System.nanoTime();
		Scanner scanHundred = new Scanner(new File("random100.txt"));
		ArrayList<Integer> numsHundred = new ArrayList<Integer>();
		while(scanHundred.hasNextInt()){
			numsHundred.add(scanHundred.nextInt());
		}
		long endReadFileHundred = System.nanoTime();
		Collections.sort(numsHundred);
		for(int n : numsHundred){
		System.out.println(n);
		}
		long endProgramHundred = System.nanoTime();
		int sizeHundred = numsHundred.size();
		System.out.println("\nN = " + sizeHundred);
		System.out.println("k = N/2\nk = " + sizeHundred/2);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFileHundred-startTimeHundred)/Math.pow(10,9))));
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgramHundred-startTimeHundred)/Math.pow(10,9))));
		scanHundred.close();
	}
	
	public static void ten() throws FileNotFoundException{
		long startTimeTen = System.nanoTime();
		Scanner scanTen = new Scanner(new File("random10.txt"));
		ArrayList<Integer> numsTen = new ArrayList<Integer>();
		while(scanTen.hasNextInt()){
			numsTen.add(scanTen.nextInt());
		}
		long endReadFileTen = System.nanoTime();
		Collections.sort(numsTen);
		for(int n : numsTen){
		System.out.println(n);
		}
		long endProgramTen = System.nanoTime();
		int sizeTen = numsTen.size();
		System.out.println("\nN = " + sizeTen);
		System.out.println("k = N/2\nk = " + sizeTen/2);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFileTen-startTimeTen)/Math.pow(10,9))));
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgramTen-startTimeTen)/Math.pow(10,9))));
		scanTen.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		million();
		thousand();
		hundred();
		ten();
	}
}
