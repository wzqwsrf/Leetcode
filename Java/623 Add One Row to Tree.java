
// 623. Add One Row to Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-20 16:49:54
 * @url:https://leetcode.com/problems/add-one-row-to-tree/#/description
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        dfs(root, v, d);
        return root;
    }

    private void dfs(TreeNode root, int v, int d) {
        if (root == null) {
            return;
        }
        if (d == 2) {
            TreeNode left = root.left;
            root.left = new TreeNode(v);
            TreeNode right = root.right;
            root.right = new TreeNode(v);
            if (left != null) {
                root.left.left = left;
            }
            if (right != null) {
                root.right.right = right;
            }
        } else {
            d -= 1;
            dfs(root.left, v, d);
            dfs(root.right, v, d);
        }
    }
}