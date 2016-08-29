
// 389. Find the Difference

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-08-29 23:01:40
 * @url:https://leetcode.com/problems/find-the-difference/
 */

public class Solution {
    public char findTheDifference(String s, String t) {
        int len1 = s.length();
        int array[] = new int[26];
        for (int i = 0; i < len1; i++) {
            array[s.charAt(i) - 'a']++;
        }
        int len2 = t.length();
        for (int i = 0; i < len2; i++) {
            if (array[t.charAt(i) - 'a']-- == -1) {
                return t.charAt(i);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] == -1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}