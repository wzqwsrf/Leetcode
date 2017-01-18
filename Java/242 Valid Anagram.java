
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
        int array[] = new int[26];
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        for (int i = 0; i < sLen; i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < tLen; i++) {
            array[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}