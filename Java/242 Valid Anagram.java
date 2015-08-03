
// Valid Anagram

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-03 10:39:42
 * @url:https://leetcode.com/problems/valid-anagram/
 * 具体参考csdn:http://blog.csdn.net/u013027996/article/details/47252891
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        int k = 0;
        while (k < sLen) {
            if (sArray[k] != tArray[k]) {
                return false;
            }
            k++;
        }
        return true;
    }
}