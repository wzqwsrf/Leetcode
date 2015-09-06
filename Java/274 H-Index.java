
// H-Index

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-06 14:58:07
 * @url:https://leetcode.com/problems/h-index/
 * 这个计算方式不太理解
 */

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int array[] = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                array[len]++;
            } else {
                array[citations[i]]++;
            }
        }
        int count = 0;
        for (int i = len; i >= 0; i--) {
            count += array[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
