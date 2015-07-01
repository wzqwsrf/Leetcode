
// Longest Substring Without Repeating Characters

import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月07日15:12:29
 * @url:https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 每次查找记录字符是否出现。切忌暴力搜索
 * 具体参考http://blog.csdn.net/u013027996/article/details/43603377
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int array[] = new int[256];
        Arrays.fill(array, -1);
        int start = 0;
        int maxLen = 0;
        array[(int) (s.charAt(0))] = 0;
        for (int i = 1; i < len; i++) {
            int num = (int) (s.charAt(i));
            if (array[num] != -1) {
                int tempLen = i - start;
                maxLen = maxLen > tempLen ? maxLen : tempLen;
                start = array[num] + 1;
                i = start;
                Arrays.fill(array, -1);
                array[(int) (s.charAt(start))] = start;
            } else {
                array[num] = i;
            }
        }
        int tempLen = len - start;
        maxLen = maxLen > tempLen ? maxLen : tempLen;
        return maxLen;
    }
}
