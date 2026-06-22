import java.util.*;

public class AlienDictionary {

    public static String alienOrder(
            String[] words) {

        Map<Character,
                Set<Character>> graph =
                new HashMap<>();

        Map<Character,
                Integer> indegree =
                new HashMap<>();

        for (String word : words) {

            for (char c :
                    word.toCharArray()) {

                graph.putIfAbsent(
                        c,
                        new HashSet<>());

                indegree.putIfAbsent(
                        c,
                        0);
            }
        }

        for (int i = 0;
             i < words.length - 1;
             i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int len =
                    Math.min(
                            w1.length(),
                            w2.length()
                    );

            for (int j = 0;
                 j < len;
                 j++) {

                if (w1.charAt(j)
                        !=
                        w2.charAt(j)) {

                    char from =
                            w1.charAt(j);

                    char to =
                            w2.charAt(j);

                    if (graph.get(from)
                            .add(to)) {

                        indegree.put(
                                to,
                                indegree.get(to) + 1
                        );
                    }

                    break;
                }
            }
        }

        Queue<Character> queue =
                new LinkedList<>();

        for (char c :
                indegree.keySet()) {

            if (indegree.get(c)
                    == 0) {

                queue.offer(c);
            }
        }

        StringBuilder result =
                new StringBuilder();

        while (!queue.isEmpty()) {

            char c =
                    queue.poll();

            result.append(c);

            for (char next :
                    graph.get(c)) {

                indegree.put(
                        next,
                        indegree.get(next) - 1
                );

                if (indegree.get(next)
                        == 0) {

                    queue.offer(next);
                }
            }
        }

        return result.length()
                ==
                indegree.size()
                ? result.toString()
                : "";
    }

    public static void main(String[] args) {

        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(
                alienOrder(words)
        );
    }
}
