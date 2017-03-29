package inClassAssignments.chapter3;

public class TestDoublyLinked {

	public static void main(String[] args) {
		MyDoublyLinkedListGeneric<Integer> nums = new MyDoublyLinkedListGeneric<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		System.out.println(nums.printList());
		System.out.println(nums.printListRev());
		nums.insert(10, 0);
		nums.insert(11, 2);
		nums.insert(12, 5);
		nums.insert(13, 20);
		nums.insert(14, -1);
		System.out.println(nums.printList());
		System.out.println(nums.printListRev());
		nums.remove(1);
		nums.remove(13);
		System.out.println(nums.printList());
		System.out.println(nums.printListRev());
		System.out.println(nums.get(1));
		System.out.println(nums.get(6));
	}

}
