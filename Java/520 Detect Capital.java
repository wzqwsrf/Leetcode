
// 520. Detect Capital

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-26 18:19:43
 * @url:https://leetcode.com/problems/detect-capital/#/description
 */

public class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int len1 = 0;
        int len2 = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                len1++;
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                len2++;
            }
        }
        if (len1 == len || len2 == len) {
            return true;
        }
        if (len2 == 1 && len > 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        }
        return false;
    }
}


public class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[a-z]+|[A-Z]+|[A-Z][a-z]+");
    }
}