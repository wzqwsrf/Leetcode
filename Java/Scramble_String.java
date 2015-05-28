
//Scramble String

import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:17:02
 * @url:https://leetcode.com/problems/scramble-string/
 */

public class Scramble_String {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char arrayA[] = s1.toCharArray();
        char arrayB[] = s2.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        if (!new String(arrayA).equals(new String(arrayB))) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 1) {
            return s1.equals(s2);
        }
        for (int i = 1; i < len1; i++) {
            String news1 = s1.substring(0, i);
            String news2 = s1.substring(i);
            String news3 = s2.substring(0, i);
            String news4 = s2.substring(i);
            if (isScramble(news1, news3) && isScramble(news2, news4)) {
                return true;
            }
            news3 = s2.substring(0, len1 - i);
            news4 = s2.substring(len1 - i);
            if (isScramble(news1, news4) && isScramble(news2, news3)) {
                return true;
            }
        }
        return false;
    }
}