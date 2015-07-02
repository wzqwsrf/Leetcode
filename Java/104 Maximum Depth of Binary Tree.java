
// Maximum Depth of Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:02:51
 * @url:https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDeep;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDeep = 0;
        dfs(root, 1);
        return maxDeep;
    }

    public void dfs(TreeNode root, int deep) {
        if (root.left != null) {
            dfs(root.left, deep + 1);
        }
        if (root.right != null) {
            dfs(root.right, deep + 1);
        }
        maxDeep = Math.max(maxDeep, deep);
    }
}