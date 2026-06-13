import java.util.*;
class ListNodeCycle {
    int val;
    ListNodeCycle next;

    ListNodeCycle(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNodeCycle head) {

        ListNodeCycle slow = head;
        ListNodeCycle fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ListNodeCycle n1 = new ListNodeCycle(1);
        ListNodeCycle n2 = new ListNodeCycle(2);
        ListNodeCycle n3 = new ListNodeCycle(3);
        ListNodeCycle n4 = new ListNodeCycle(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n4.next = n2; // cycle

        System.out.println(hasCycle(n1));
    }
}
