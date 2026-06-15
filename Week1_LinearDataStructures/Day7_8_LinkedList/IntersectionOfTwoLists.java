import java.util.*;
class ListNodeIntersection {

    int val;
    ListNodeIntersection next;

    ListNodeIntersection(int val) {
        this.val = val;
    }
}

public class IntersectionOfTwoLists {

    public static ListNodeIntersection getIntersectionNode(
            ListNodeIntersection headA,
            ListNodeIntersection headB) {

        if (headA == null || headB == null)
            return null;

        ListNodeIntersection a = headA;
        ListNodeIntersection b = headB;

        while (a != b) {

            if (a == null)
                a = headB;
            else
                a = a.next;

            if (b == null)
                b = headA;
            else
                b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {

        ListNodeIntersection common =
                new ListNodeIntersection(8);

        common.next = new ListNodeIntersection(4);
        common.next.next = new ListNodeIntersection(5);

        ListNodeIntersection headA =
                new ListNodeIntersection(4);

        headA.next = new ListNodeIntersection(1);
        headA.next.next = common;

        ListNodeIntersection headB =
                new ListNodeIntersection(5);

        headB.next = new ListNodeIntersection(6);
        headB.next.next = new ListNodeIntersection(1);
        headB.next.next.next = common;

        ListNodeIntersection result =
                getIntersectionNode(headA, headB);

        System.out.println(result.val);
    }
}
