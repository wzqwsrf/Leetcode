
// 655. Print Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-10 12:34:52
 * @url:https://leetcode.com/problems/print-binary-tree/description/
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
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int width = (int) Math.pow(2, depth) - 1;
        List<List<String>> list = new ArrayList<List<String>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int row = 1;
        int col = width;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> rowList = new ArrayList<String>(width);
            for (int i = 0; i < width; i++) {
                rowList.add("");
            }
            int index = col / 2;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (row < depth) {
                    if (node == null) {
                        queue.offer(null);
                        queue.offer(null);
                    } else {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
                if (node != null) {
                    rowList.set(index, String.valueOf(node.val));
                }
                index += col + 1;
            }
            row += 1;
            col /= 2;
            list.add(rowList);
        }
        return list;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}