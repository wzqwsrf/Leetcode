
// 337. House Robber III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-12 15:23:00
 * @url:https://leetcode.com/problems/house-robber-iii/
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
    public int rob(TreeNode root) {
        int res[] = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        int res[] = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}