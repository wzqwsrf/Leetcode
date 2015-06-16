
//Invert Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月16日14:49:50
 * @url:https://leetcode.com/problems/invert-binary-tree/
 */

public class Invert_Binary_Tree {
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
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                root.left = invertTree(right);
                root.right = invertTree(left);
            }
            return root;
        }
    }
}