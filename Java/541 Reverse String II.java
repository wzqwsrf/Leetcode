
// 541. Reverse String II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:58:03
 * @url:https://leetcode.com/problems/reverse-string-ii/#/description
 */

public class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char array[] = s.toCharArray();
        int start = 0;
        while (start < len) {
            int end = Math.min(start + k, len) - 1;
            swap(array, start, end);
            start += 2 * k;
        }
        return String.valueOf(array);
    }

    private void swap(char array[], int start, int end) {
        while (start < end) {
            char temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            end--;
            start++;
        }
    }
}

public class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int start = 0;
        while (start < len) {
            int end = Math.min(start + 2 * k, len);
            sb.append(reverseSubStr(s.substring(start, end), k));
            start += 2 * k;
        }
        return sb.toString();
    }

    private String reverseSubStr(String s, int k) {
        int len = s.length();
        if (len <= k) {
            return new StringBuffer(s).reverse().toString();
        }
        StringBuffer sb = new StringBuffer(s.substring(0, k)).reverse();
        sb.append(s.substring(k));
        return sb.toString();
    }
}