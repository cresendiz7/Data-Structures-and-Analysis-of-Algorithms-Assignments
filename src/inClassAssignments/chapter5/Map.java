package inClassAssignments.chapter5;


public class Map<KeyType, ValueType> {
	public Map(){
		//initialize map
	}
	public void put(KeyType key, ValueType val){
		//add entry to items
	}
	public ValueType get(KeyType key){
		return null;
		//get entry from items (need to add a get method to QuadraticProbingHashTable
	}
	public boolean isEmpty(){
		return false;
		//check if items empty
	}
	public void makeEmpty(){
		//make items empty
	}
	
	private QuadraticProbingHashTable<Entry<KeyType,ValueType>> items;
	
	private static class Entry<KeyType, ValueType>
	{
		KeyType key;
		ValueType value;
		//Appropriate Constructors, hashCode, equals, etc
	}
}
