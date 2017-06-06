
// 543. Diameter of Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:59:32
 * @url:https://leetcode.com/problems/diameter-of-binary-tree/#/description
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxLen;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lnum = dfs(root.left);
        int rnum = dfs(root.right);
        if (lnum + rnum > maxLen) {
            maxLen = lnum + rnum;
        }
        return Math.max(lnum, rnum) + 1;
    }
}