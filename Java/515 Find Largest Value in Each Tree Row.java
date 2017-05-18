
// 515. Find Largest Value in Each Tree Row

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-18 18:04:59
 * @url:https://leetcode.com/problems/find-largest-value-in-each-tree-row/#/description
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.val > maxVal) {
                    maxVal = node.val;
                }
            }
            list.add(maxVal);
        }
        return list;
    }
}