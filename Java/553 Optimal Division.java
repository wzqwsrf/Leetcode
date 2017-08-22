
// 553. Optimal Division

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 17:10:13
 * @url:https://leetcode.com/problems/optimal-division/description/
 */

class Solution {
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int len = nums.length;
        if (len == 1) {
            return String.valueOf(nums[0]);
        }
        if (len == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < len; i++) {
            sb.append("/" + nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}