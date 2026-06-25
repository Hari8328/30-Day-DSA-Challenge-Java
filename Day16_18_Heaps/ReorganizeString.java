import java.util.*;

public class ReorganizeString {

    public static String reorganizeString(String s) {

        Map<Character, Integer> count =
                new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c,
                    count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                count.get(b) - count.get(a)
                );

        maxHeap.addAll(count.keySet());

        StringBuilder result =
                new StringBuilder();

        while (!maxHeap.isEmpty()) {

            char first =
                    maxHeap.poll();

            if (result.length() == 0 ||
                    result.charAt(result.length() - 1) != first) {

                result.append(first);

                count.put(first,
                        count.get(first) - 1);

                if (count.get(first) > 0) {
                    maxHeap.offer(first);
                }

            } else {

                if (maxHeap.isEmpty()) {
                    return "";
                }

                char second =
                        maxHeap.poll();

                result.append(second);

                count.put(second,
                        count.get(second) - 1);

                if (count.get(second) > 0) {
                    maxHeap.offer(second);
                }

                maxHeap.offer(first);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(
                reorganizeString("aab")
        );

        System.out.println(
                reorganizeString("aaab")
        );

        System.out.println(
                reorganizeString("aabbcc")
        );
    }
}
