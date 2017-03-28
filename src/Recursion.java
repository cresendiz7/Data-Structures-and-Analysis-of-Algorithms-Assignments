import java.util.Scanner;

public class Recursion{ 
		  public static int countOnes(int n){
			  int ones ;
			  if (n == 0){
				  ones = 0 ;
				  return ones;
				  }
			  // n is even
			  else if (n % 2 == 0){
				   // call countOnes(n/2)
				   ones = countOnes(n / 2) ; 
				   return ones;
				   }
			  // n is odd
			  else{
				  // call countOnes( (n-1)/2) then plus 1.
				  ones = 1 + countOnes((n - 1) / 2) ; 
				  return ones;
			  }
		  }
		  
		  public static void main(String[] args){
			  int n ;
			  Scanner scan = new Scanner(System.in);
			  System.out.print("Please enter a number: ");
			  n = scan.nextInt();
			  int ones = countOnes(n) ;
			  System.out.println("# of ones: " + ones) ;
			  
			  //Close the scanner
			  scan.close();
		 }		
}