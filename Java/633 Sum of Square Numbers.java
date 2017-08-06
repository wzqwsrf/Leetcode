
// 633. Sum of Square Numbers

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-06 11:36:16
 * @url:https://leetcode.com/problems/sum-of-square-numbers/description/
 */

public class Solution {
    public boolean judgeSquareSum(int c) {
        int mid = (int) Math.sqrt(c);
        for (int i = 0; i <= mid; i++) {
            int num = c - i * i;
            if (num < 0) {
                return false;
            }
            int second = (int) Math.sqrt(num);
            if (second * second == num) {
                return true;
            }
        }
        return false;
    }
}