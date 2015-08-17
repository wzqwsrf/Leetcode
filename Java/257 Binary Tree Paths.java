
// Binary Tree Paths

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-17 16:21:28
 * @url:https://leetcode.com/problems/binary-tree-paths/
 * DFS
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root != null) {
            dfs(list, root, root.val + "");
        }
        return list;
    }

    private void dfs(List<String> list, TreeNode root, String curVal) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(curVal);
            return;
        }
        if (root.left != null) {
            dfs(list, root.left, curVal + "->" + root.left.val);
        }

        if (root.right != null) {
            dfs(list, root.right, curVal + "->" + root.right.val);
        }
    }
}