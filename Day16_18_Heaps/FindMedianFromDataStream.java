import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b - a
                );

        minHeap =
                new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeap.offer(num);

        minHeap.offer(
                maxHeap.poll()
        );

        if (minHeap.size() >
                maxHeap.size()) {

            maxHeap.offer(
                    minHeap.poll()
            );
        }
    }

    public double findMedian() {

        if (maxHeap.size() >
                minHeap.size()) {

            return maxHeap.peek();
        }

        return (
                maxHeap.peek()
                        +
                        minHeap.peek()
        ) / 2.0;
    }
}

public class FindMedianFromDataStream {

    public static void main(String[] args) {

        MedianFinder mf =
                new MedianFinder();

        mf.addNum(1);
        System.out.println(
                mf.findMedian()
        );

        mf.addNum(2);
        System.out.println(
                mf.findMedian()
        );

        mf.addNum(3);
        System.out.println(
                mf.findMedian()
        );
    }
}
