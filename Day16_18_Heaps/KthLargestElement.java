import java.util.*;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        for (int num : nums) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1, 5, 6, 4};

        System.out.println(
                findKthLargest(nums1, 2)
        ); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(
                findKthLargest(nums2, 4)
        ); // 4
    }
}
