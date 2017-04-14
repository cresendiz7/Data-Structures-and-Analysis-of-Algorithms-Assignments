package inClassAssignments.chapter5;


public class HopscotchHashTable<AnyType> {
	
	//add constructor, put/insert, get, contains, remove, etc
	
	
	/*
	 * General process:
	 * 1. Find where item should go
	 * 2. If that position is filled, check the "hop" variable to see what positions it could potentially go to (zeros)
	 * 3. Check each zero position to see if any of them are null, if so insert there, if not continue
	 * 4. Check each zero position to see if the item present can be moved further away in the array to make room for this item
	 * - note, you can start with the first or the last zero, but usually starting with the last will provide better results
	 */

	private class Entry<AnyType>
	{
		AnyType value;
		String hop;//this will be a binary String; size of string sets maximum look ahead
	}
}
