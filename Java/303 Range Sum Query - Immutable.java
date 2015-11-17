
// Range Sum Query - Immutable

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-17 17:56:12
 * @url:https://leetcode.com/problems/range-sum-query-immutable/
 */

public class NumArray {

    private int sums[];

    public NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);