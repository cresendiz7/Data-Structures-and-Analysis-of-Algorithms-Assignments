import java.util.*;
public class TreeMapNames {
	public static String name;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeMap<String, Integer> nameMap = new TreeMap<String, Integer>();
		System.out.println("Please enter the names you would like to process. To stop enter 'Exit'.");
		do{
			System.out.print("Enter a name: ");
			name = scan.nextLine();
			if(name.equalsIgnoreCase("exit"))
				break;
			int vowels = 0;
			for (int i = 0; i < name.length(); i++)
			{
				char ch = name.charAt(i);
				if(ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u')
					vowels++;
				nameMap.put(name, vowels);
			}
		}while(!(name.equalsIgnoreCase("exit")));
		System.out.println("\nNames-");
		for(String s : nameMap.keySet())
		{
			System.out.println("Name:" + s + " " + "Vowels:" + nameMap.get(s));
		}
		scan.close();
	}
}
