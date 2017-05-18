
// 513. Find Bottom Left Tree Value

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-18 17:57:40
 * @url:https://leetcode.com/problems/find-bottom-left-tree-value/#/description
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int num = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == 0) {
                    num = node.val;
                }
            }
        }
        return num;
    }
}