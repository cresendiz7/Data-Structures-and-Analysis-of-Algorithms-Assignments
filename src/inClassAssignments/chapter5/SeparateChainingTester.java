package inClassAssignments.chapter5;

public class SeparateChainingTester {

	public static void main(String[] args) {
		Student s1 = new Student("JET", "CS", 2007);
		Student s2 = new Student("Bob", "CS", 2007);
		Student s3 = new Student("Bill", "CS", 2007);
		Student s4 = new Student("Ted", "CS", 2007);
		//System.out.println(s1.hashCode());
		SeparateChainingHashTable hashTable = new SeparateChainingHashTable();
		System.out.println(hashTable);
		hashTable.insert(s1);
		hashTable.insert(s2);
		hashTable.insert(s3);
		hashTable.insert(s4);
		System.out.println(hashTable);
	}

}
