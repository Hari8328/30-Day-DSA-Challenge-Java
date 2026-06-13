import java.util.*;
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLists {

    public static Node merge(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node curr = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null)
            curr.next = l1;
        else
            curr.next = l2;

        return dummy.next;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node result = merge(l1, l2);

        print(result);
    }
}
