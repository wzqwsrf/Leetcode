
// Container With Most Water


/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:22:00
 * @url:https://leetcode.com/problems/container-with-most-water/
 */

public class Solution {

    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            max = Math.max(area, max);
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}

