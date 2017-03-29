package inClassAssignments.chapter5;

public class SeparateChainingTester2 {

	public static void main(String[] args) {
		SeparateChainingHashTable<String> hashTable = new SeparateChainingHashTable<>();
		System.out.println(hashTable);
		hashTable.insert("Bill");
		hashTable.insert("Ted");
		hashTable.insert("Susan");
		hashTable.insert("Jill");
		System.out.println(hashTable);
	//	System.out.println(hashTable.getSize());
	//	hashTable.rehashTable();
		System.out.println(hashTable);
	//	System.out.println(hashTable.getSize());

	}

}
