
// 662. Maximum Width of Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-20 17:33:50
 * @url:https://leetcode.com/problems/maximum-width-of-binary-tree/description/
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        while (!queue.isEmpty()) {
            maxWidth = Math.max(maxWidth,
                    list.get(list.size() - 1) - list.get(0) + 1);
            int size = queue.size();
            List<Integer> idList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    idList.add(list.get(i) * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    idList.add(list.get(i) * 2 + 1);
                }
            }
            list = idList;
        }
        return maxWidth;
    }
}