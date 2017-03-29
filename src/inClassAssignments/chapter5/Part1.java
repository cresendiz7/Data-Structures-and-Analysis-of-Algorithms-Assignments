//*********************************
// Part1.java
// Author: Angel Rodriguez
// Date Created: 3/1/2017
// This program promts the user for grade information then calculates and states their GPA based off the grades.
//*********************************

package inClassAssignments.chapter5;

import java.util.Scanner;

public class Part1
{
 public static void main(String[] args)
 { 
   String name1, name2;
   String major;
   String course1, course2, course3;
   Float credits1, credits2, credits3;
  
   Scanner scan = new Scanner(System.in);
   
  System.out.println("Hello, welcome user to the UNG GPA Calculator!");
  
  System.out.println("Please enter your first name.");
  name1 = scan.nextLine();
  
  System.out.println("Please enter your last name.");
  name2 = scan.nextLine();
  
  System.out.println("Please enter your major.");
  major = scan.nextLine();
   
  System.out.println("Please enter your first course number. Example CSCI-1301");
  course1 = scan.nextLine();
  
  System.out.println("Please enter your third course number. Example CSCI-1301");
  credits1 = scan.nextFloat();
   
  System.out.println("Please enter your second course number. Example CSCI-1301");
  course2 = scan.nextLine();
  scan.nextLine();
  
  System.out.println("Please enter your third course number. Example CSCI-1301");
  credits2 = scan.nextFloat();
  
  System.out.println("Please enter your third course number. Example CSCI-1301");
  course3 = scan.nextLine();
  scan.nextLine();
  
  System.out.println("Please enter your third course number. Example CSCI-1301");
  credits3 = scan.nextFloat();
  
  
  
  
  
  
  
  
  
  
  
  
  scan.close();
 }
}