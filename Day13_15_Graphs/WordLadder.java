import java.util.*;

public class WordLadder {

    public static int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> set =
                new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word =
                        queue.poll();

                if (word.equals(endWord))
                    return level;

                char[] chars =
                        word.toCharArray();

                for (int j = 0;
                     j < chars.length;
                     j++) {

                    char old = chars[j];

                    for (char c = 'a';
                         c <= 'z';
                         c++) {

                        chars[j] = c;

                        String next =
                                new String(chars);

                        if (set.contains(next)
                                &&
                                !visited.contains(next)) {

                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    chars[j] = old;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        List<String> words =
                Arrays.asList(
                        "hot",
                        "dot",
                        "dog",
                        "lot",
                        "log",
                        "cog"
                );

        System.out.println(
                ladderLength(
                        "hit",
                        "cog",
                        words
                )
        );
    }
}
