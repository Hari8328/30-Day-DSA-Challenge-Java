import java.util.*;

public class WordBreak {

    public static boolean wordBreak(
            String s,
            List<String> wordDict) {

        Set<String> dict =
                new HashSet<>(wordDict);

        boolean[] dp =
                new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j]
                        && dict.contains(
                        s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        System.out.println(
                wordBreak(
                        "leetcode",
                        Arrays.asList(
                                "leet",
                                "code"
                        )
                )
        );

        System.out.println(
                wordBreak(
                        "catsandog",
                        Arrays.asList(
                                "cat",
                                "cats",
                                "and",
                                "sand",
                                "dog"
                        )
                )
        );
    }
}
