import java.util.*;

public class TaskSchedulerReview {

    public static int leastInterval(
            char[] tasks,
            int n) {

        Map<Character, Integer> count =
                new HashMap<>();

        for (char task : tasks) {

            count.put(
                    task,
                    count.getOrDefault(task, 0) + 1
            );
        }

        int maxFreq = 0;

        for (int freq : count.values()) {

            maxFreq =
                    Math.max(maxFreq, freq);
        }

        int maxCount = 0;

        for (int freq : count.values()) {

            if (freq == maxFreq) {
                maxCount++;
            }
        }

        int result =
                (maxFreq - 1) * (n + 1)
                        + maxCount;

        return Math.max(
                result,
                tasks.length
        );
    }

    public static void main(String[] args) {

        char[] tasks1 =
                {'A','A','A','B','B','B'};

        System.out.println(
                leastInterval(tasks1, 2)
        );

        char[] tasks2 =
                {'A','A','A','B','B','B'};

        System.out.println(
                leastInterval(tasks2, 0)
        );
    }
}
