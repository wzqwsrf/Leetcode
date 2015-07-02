
// Binary Tree Maximum Path Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:15:24
 * @url:https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        int tempVal = root.val;
        if (leftVal > 0) {
            tempVal += leftVal;
        }
        if (rightVal > 0) {
            tempVal += rightVal;
        }
        maxSum = maxSum > tempVal ? maxSum : tempVal;
        return root.val + Math.max(Math.max(0, leftVal), rightVal);
    }
}