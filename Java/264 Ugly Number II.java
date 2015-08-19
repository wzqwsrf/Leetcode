
// Ugly Number II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-19 16:21:52
 * @url:https://leetcode.com/problems/ugly-number-ii/
 */

public class Solution {
    public int nthUglyNumber(int n) {
        int array[] = new int[n];
        array[0] = 1;
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (index < n) {
            int num1 = array[index2] * 2;
            int num2 = array[index3] * 3;
            int num3 = array[index5] * 5;
            int min = Math.min(Math.min(num1, num2), num3);
            array[index] = min;
            while (array[index2] * 2 <= min) {
                index2++;
            }
            while (array[index3] * 3 <= min) {
                index3++;
            }
            while (array[index5] * 5 <= min) {
                index5++;
            }
            index++;
        }
        return array[n - 1];
    }
}