
// 384. Shuffle an Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 19:54:32
 * @url:https://leetcode.com/problems/shuffle-an-array/description/
 */

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = nums.length;
        int[] array = new int[len];
        System.arraycopy(nums, 0, array, 0, len);
        for (int i = 1; i < len; i++) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */