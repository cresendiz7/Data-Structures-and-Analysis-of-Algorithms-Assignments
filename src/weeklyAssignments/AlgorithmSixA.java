package weeklyAssignments;
import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmSixA {
	
	private static boolean isInteger(String i)
	{
		return i.matches("^-?\\d+$");
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String entry = "";
		ArrayList<Integer> integers = new ArrayList<Integer>();

		System.out.println("Enter integers to parse into heap. Type \"done\" to quit entering integers and find the lowest value.\n");
		int i = 1;
		while(!entry.equalsIgnoreCase("done"))
		{
			System.out.print("Integer #" + i + ": ");
			entry = s.nextLine();
			if(!entry.equalsIgnoreCase("done"))
			{
				if(isInteger(entry))
				{
					if(!integers.contains(Integer.parseInt(entry)))
					{
						integers.add(Integer.parseInt(entry));
						i++;
					} else
						System.out.println("Error: Duplicate entry.");
				} else 
					System.out.println("Error: Non-integer entered.");
			}
		}
		
		//Add all integers to the heap
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<Integer>();
		for(int thisInt : integers)
			binaryHeap.insert(thisInt);

		//Display result
		System.out.println("The lowest value is: " + binaryHeap.findMin());
	}
}