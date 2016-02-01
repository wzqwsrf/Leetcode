
// Maximum Product of Word Lengths

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-02-02 03:32:00
 * @url:https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int array[] = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wlen = word.length();
            for (int j = 0; j < wlen; j++) {
                array[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((array[i] & array[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}