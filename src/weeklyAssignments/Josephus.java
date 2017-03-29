package weeklyAssignments;
import java.util.Scanner;

public class Josephus
   {
	class Link
	{
		public int data;
		public Link next;
		
		public Link(int d, Link n)
		{
			data = d;
			next = n;
		}
		public Link(int d)
		{
			this(d, null);
		}
	}
	
	int players, passes;
	Link first = null;
	Link last  = null;
	int length = 0;
	
	public void inputs()
	{
		Scanner s = new Scanner(System.in);
		System.out.print( "# of players: ");
		players = s.nextInt();
		System.out.print( "# of passes: ");
		passes = s.nextInt();
        first = last = null;
        int k = 1;
        while (k <= players)
        {
        	if (first == null){
        		first = last = new Link(k, null);
        	}
            else{
            	last.next = new Link(k, null);
            	last = last.next;
            }
        	k++;
        }
        last.next = first;
        s.close();
    }
	
	public void printList(Link last)
	{
		Link current = last;
		while (current != null){
			System.out.printf("%d", current.data);
			current = current.next;
			if (current != null){
				System.out.printf( ", " );
			}
		}
		System.out.printf( "\n" );
    }
	
	public void playGame()
	{
		for (int j = 1; j < players; j++){
			for (int k = 0; k < passes; k++){
				first = first.next;
				last = last.next;
	         }
			System.out.println("Player " + first.data + " is eliminated!");
			last.next = first.next;
			first = last.next;
		}
		System.out.println("Player " + first.data + " is the winner!");
	}
	
	public Josephus()
	{
		inputs();
		playGame();
	}
	
	public static void main(String [] args)
    {
		new Josephus();
    }
   }