
// Range Sum Query - Mutable

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-12-07 18:37:23
 * @url:https://leetcode.com/problems/range-sum-query-mutable/
 */

public class NumArray {

    private int segTree[];
    private int len;

    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        len = nums.length;
        segTree = new int[len * 4 + 1];
        buildSegTree(nums, 0, len - 1, 0);
    }

    private void buildSegTree(int[] nums, int left, int right, int index) {
        if (left == right) {
            segTree[index] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        int lIndex = (index + 1) * 2 - 1;
        int rIndex = lIndex + 1;
        buildSegTree(nums, left, mid, lIndex);
        buildSegTree(nums, mid + 1, right, rIndex);
        segTree[index] = segTree[lIndex] + segTree[rIndex];
    }


    void update(int i, int val) {
        updateValue(0, 0, len - 1, i, val);
    }

    private void updateValue(int index, int left, int right, int i, int val) {
        if (left == right) {
            segTree[index] = val;
            return;
        }
        int mid = (left + right) / 2;
        int lIndex = (index + 1) * 2 - 1;
        int rIndex = lIndex + 1;
        if (i <= mid) {
            updateValue(lIndex, left, mid, i, val);
        } else {
            updateValue(rIndex, mid + 1, right, i, val);
        }
        segTree[index] = segTree[lIndex] + segTree[rIndex];
    }

    public int sumRange(int i, int j) {
        return query(0, i, j, 0, len - 1);
    }

    private int query(int index, int i, int j, int left, int right) {
        if (i <= left && j >= right) {
            return segTree[index];
        }
        if (i > right || j < left) {
            return 0;
        }
        int lIndex = (index + 1) * 2 - 1;
        int rIndex = lIndex + 1;
        int mid = (left + right) / 2;
        int lValue = query(lIndex, i, j, left, mid);
        int rValue = query(rIndex, i, j, mid + 1, right);
        return lValue + rValue;
    }

}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);