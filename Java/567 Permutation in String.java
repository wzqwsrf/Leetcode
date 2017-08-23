
// 567. Permutation in String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-23 21:02:25
 * @url:https://leetcode.com/problems/permutation-in-string/description/
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int array[] = new int[26];
        for (int i = 0; i < len1; i++) {
            array[s1.charAt(i) - 'a']++;
            array[s2.charAt(i) - 'a']--;
        }
        if (isZero(array)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            array[s2.charAt(i) - 'a']--;
            array[s2.charAt(i - len1) - 'a']++;
            if (isZero(array)) {
                return true;
            }
        }
        return false;
    }

    private boolean isZero(int[] array) {
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}