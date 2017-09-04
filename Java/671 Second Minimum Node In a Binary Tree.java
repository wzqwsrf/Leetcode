
// 671. Second Minimum Node In a Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-4 15:20:04
 * @url:https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
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
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            if (list.size() >= 2) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!list.contains(node.val)) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int size = list.size();
        if (size < 2) {
            return -1;
        }
        Collections.sort(list);
        return list.get(1);
    }
}