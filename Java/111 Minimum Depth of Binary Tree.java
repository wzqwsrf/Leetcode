
// Minimum Depth of Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:07:32
 * @url:https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDeep;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDeep = Integer.MAX_VALUE;
        dfs(root, 1);
        return minDeep;
    }

    public void dfs(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            minDeep = Math.min(minDeep, deep);
            return;
        }
        if (root.left != null) {
            dfs(root.left, deep + 1);
        }
        if (root.right != null) {
            dfs(root.right, deep + 1);
        }
    }
}