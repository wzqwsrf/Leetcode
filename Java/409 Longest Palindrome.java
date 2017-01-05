
// 409. Longest Palindrome

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-5 20:51:30
 * @url:https://leetcode.com/problems/longest-palindrome/
 */

public class Solution {
    public int longestPalindrome(String s) {
        char array[] = s.toCharArray();
        int len = array.length;
        List<Character> list = new ArrayList<Character>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (list.contains(array[i])) {
                list.remove((Character) array[i]);
                count++;
            } else {
                list.add(array[i]);
            }
        }
        if (!list.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }
}