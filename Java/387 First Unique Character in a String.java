
// 387. First Unique Character in a String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-08-22 18:16:55
 * @url:https://leetcode.com/problems/first-unique-character-in-a-string/
 */

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        int array[] = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - 'a';
            array[num]++;
        }
        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - 'a';
            if (array[num] == 1) {
                return i;
            }
        }
        return -1;
    }
}