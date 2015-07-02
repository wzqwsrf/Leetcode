
// Convert Sorted Array to Binary Search Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:05:25
 * @url:https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class Solution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        int len = num.length;
        return createBSTree(num, 0, len - 1);
    }

    private TreeNode createBSTree(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(num[low]);
        }
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = createBSTree(num, low, mid - 1);
        root.right = createBSTree(num, mid + 1, high);
        return root;
    }
}