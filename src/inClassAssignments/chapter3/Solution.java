package inClassAssignments.chapter3;

public class Solution {
    public static void main(String... args) {
        {
            SinglyLinkedNode head = new SinglyLinkedNode("a");
            SinglyLinkedNode node = head;
            node.next = new SinglyLinkedNode("b");
            node = node.next;
            node.next = new SinglyLinkedNode("c");
            node = node.next;
            node.next = new SinglyLinkedNode("d");
            node = node.next;
            node.next = new SinglyLinkedNode("e");
            node = node.next;
            print(head);
            print(swapAdjacentNodes(head));
        }
        /*{
            DoublyLinkedNode head = new DoublyLinkedNode("a");
            DoublyLinkedNode node1 = head, node2;
            node1.next = new DoublyLinkedNode("b");
            node2 = node1.next;
            node2.prev = node1;
            node1 = node2;
            node1.next = new DoublyLinkedNode("c");
            node2 = node1.next;
            node2.prev = node1;
            node1 = node2;
            node1.next = new DoublyLinkedNode("d");
            node2 = node1.next;
            node2.prev = node1;
            node1 = node2;
            node1.next = new DoublyLinkedNode("e");
            node2 = node1.next;
            node2.prev = node1;
            print(head);
            print(swapAdjacentNodes(head));
        }*/
    }

    /*private static void print(DoublyLinkedNode head) {
        while (head != null) {
            if (head.prev != null)
                System.out.print("<-");
            System.out.print(head);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }*/

    private static void print(SinglyLinkedNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head + "->");
            else
                System.out.print(head);
            head = head.next;
        }
        System.out.println();
    }

    public static SinglyLinkedNode swapAdjacentNodes(SinglyLinkedNode head) {
        if (head == null || head.next == null) return head;
        SinglyLinkedNode dummy = new SinglyLinkedNode("");
        SinglyLinkedNode cur = head;
        dummy.next = cur;
        SinglyLinkedNode before = dummy, after;
        while (cur != null && cur.next != null) {
            after = cur.next.next;
            before.next = cur.next;
            cur.next.next = cur;
            cur.next = after;
            before = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    /*public static DoublyLinkedNode swapAdjacentNodes(DoublyLinkedNode head) {
        if (head == null || head.next == null) return head;
        DoublyLinkedNode dummy = new DoublyLinkedNode("");
        DoublyLinkedNode cur = head;
        dummy.next = cur;
        cur.prev = dummy;
        DoublyLinkedNode before, first, second, after;
        while (cur != null && cur.next != null) {
            after = cur.next.next;
            first = cur;
            second = cur.next;
            before = cur.prev;
            if (before != null)
                before.next = second;
            second.prev = before;
            second.next = first;
            first.prev = second;
            first.next = after;
            if (after != null)
                after.prev = first;
            cur = after;
        }
        dummy.next.prev = null;
        return dummy.next;
    }*/

    static class SinglyLinkedNode {
        String data;
        SinglyLinkedNode next;

        SinglyLinkedNode(String data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data;
        }
    }

    /*static class DoublyLinkedNode {
        String data;
        DoublyLinkedNode prev, next;

        DoublyLinkedNode(String data) {
            this.data = data;
            this.prev = this.next = null;
        }

        @Override
        public String toString() {
            return data;
        }
    }*/
}