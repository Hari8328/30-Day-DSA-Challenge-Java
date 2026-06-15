import java.util.*;
class ListNodePalindrome {

    int val;
    ListNodePalindrome next;

    ListNodePalindrome(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNodePalindrome head) {

        if (head == null || head.next == null)
            return true;

        ListNodePalindrome slow = head;
        ListNodePalindrome fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNodePalindrome prev = null;
        ListNodePalindrome curr = slow;

        while (curr != null) {

            ListNodePalindrome next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        ListNodePalindrome first = head;
        ListNodePalindrome second = prev;

        while (second != null) {

            if (first.val != second.val)
                return false;

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNodePalindrome head =
                new ListNodePalindrome(1);

        head.next = new ListNodePalindrome(2);
        head.next.next = new ListNodePalindrome(2);
        head.next.next.next = new ListNodePalindrome(1);

        System.out.println(isPalindrome(head));
    }
}
