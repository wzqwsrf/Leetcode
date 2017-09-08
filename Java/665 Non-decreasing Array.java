
// 665. Non-decreasing Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-8 17:21:10
 * @url:https://leetcode.com/problems/non-decreasing-array/description/
 */

class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i = 1; i < len; i++){
            if(count >= 2){
                return false;
            }
            if(nums[i - 1] > nums[i]){
                count++;
                if(i < 2 || nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}