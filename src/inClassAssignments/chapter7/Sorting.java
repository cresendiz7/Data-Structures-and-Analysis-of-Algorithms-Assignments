package inClassAssignments.chapter7;
import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] a2 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		System.out.println("Unsorted:         " + Arrays.toString(a1) + "\n\n");
		insertSort(a1);
		System.out.println("Insertion Sorted: " + Arrays.toString(a1) + "\n\n");
		shellSort(a2);
		System.out.println("Shell Sorted:     " + Arrays.toString(a2) + "\n\n");
		Integer[] a3 = new Integer[]{1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16};
		Integer[] a4 = new Integer[]{1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16};
		System.out.println("Unsorted:         " + Arrays.toString(a3) + "\n\n");
		insertSort(a3);
		System.out.println("Insertion Sorted: " + Arrays.toString(a3) + "\n\n");
		shellSort(a4);
		System.out.println("Shell Sorted:     " + Arrays.toString(a4) + "\n\n");
		Integer[] a5 = new Integer[]{34, 8, 64, 51, 32, 31};
		Integer[] a6 = new Integer[]{34, 8, 64, 51, 32, 31};
		System.out.println("Unsorted:         " + Arrays.toString(a5) + "\n\n");
		insertSort(a5);
		System.out.println("Insertion Sorted: " + Arrays.toString(a5) + "\n\n");
		shellSort(a6);
		System.out.println("Shell Sorted:     " + Arrays.toString(a6) + "\n\n");
	}
	public static void insertSort(Integer[] arr)
	{
		int moveCount = 0;
		int hole;
		for(int position = 1; position < arr.length; position++)
		{
			Integer temp = arr[position];//hold on to number we are sorting into list
			for(hole = position; hole > 0 && temp.compareTo(arr[hole-1]) < 0;hole--)
			{
				arr[hole] = arr[hole-1];//move number one space over
				//hole is now located one space to the left
				moveCount++;
			}
			arr[hole] = temp;
		}
		System.out.println("Insert Sort Move Operations: " + moveCount);
	}
	public static void shellSort(Integer[] arr)
	{
		int moveCount = 0;
		int hole;
		//sequence or shell
		for(int sequence = arr.length/2; sequence > 0; sequence /= 2)
		{
			//deal with one shell at a time
			for(int i = sequence; i < arr.length; i++)
			{
				Integer temp = arr[i];
				for(hole = i; hole >= sequence &&
						temp.compareTo(arr[hole-sequence]) < 0; hole -= sequence)
				{
					arr[hole] = arr[hole-sequence];
					moveCount++;
				}
				arr[hole] = temp;
			}
		}
		System.out.println("Shell Sort Move Operations: " + moveCount);
	}
}
