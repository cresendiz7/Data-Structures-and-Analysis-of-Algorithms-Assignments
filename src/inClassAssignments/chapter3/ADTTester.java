package inClassAssignments.chapter3;

public class ADTTester {

	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList();
		mal.add(5);
		mal.insert(10, 0);
		System.out.println(mal.printList());
		mal.remove(5);
		System.out.println(mal.printList());

		MyLinkedList mll = new MyLinkedList();
		mll.add(5);
		mll.insert(10, 0);
		System.out.println(mll.printList());
		mll.remove(5);
		System.out.println(mll.printList());

	}

}
