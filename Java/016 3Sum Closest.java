
// 3Sum Closest

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:06:17
 * @url:https://leetcode.com/problems/3sum-closest/
 */

import java.util.Arrays;

public class Solution {

    public int closet;

    public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        Arrays.sort(num);
        closet = num[0] + num[1] + num[2];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            getTargetNum(num, i, i + 1, len - 1, len, target);
        }
        return closet;
    }

    public void getTargetNum(int[] num, int first,
                             int low, int high, int len, int target) {
        int tempValue = 0;
        while (low < high) {
            tempValue = num[first] + num[low] + num[high];
            if (Math.abs(tempValue - target) < Math.abs(closet - target)) {
                closet = tempValue;
            }
            if (tempValue > target) {
                int tempHigh = high;
                high--;
                while (high >= 0 && num[high] == num[tempHigh]) {
                    high--;
                }
            } else if (tempValue < target) {
                int tempLow = low;
                low++;
                while (low < len && num[low] == num[tempLow]) {
                    low++;
                }
            } else {
                return;
            }
        }
    }
}