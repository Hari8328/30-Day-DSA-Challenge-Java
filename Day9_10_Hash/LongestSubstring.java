import java.util.*;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(
            String s) {

        HashMap<Character, Integer> map =
                new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            char c = s.charAt(right);

            if (map.containsKey(c)
                    && map.get(c) >= left) {

                left =
                        map.get(c) + 1;
            }

            map.put(c, right);

            maxLength =
                    Math.max(
                            maxLength,
                            right - left + 1
                    );
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(
                lengthOfLongestSubstring(
                        "abcabcbb"
                )
        );

        System.out.println(
                lengthOfLongestSubstring(
                        "bbbbb"
                )
        );

        System.out.println(
                lengthOfLongestSubstring(
                        "pwwkew"
                )
        );
    }
}
