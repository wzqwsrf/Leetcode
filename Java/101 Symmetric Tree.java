
// Symmetric Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:01:06
 * @url:https://leetcode.com/problems/symmetric-tree/
 */

public class Solution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root);
    }

    public boolean bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> numList = new ArrayList<Integer>();
            while (size > 0) {
                size--;
                TreeNode node = queue.peek();
                queue.poll();
                if (node.left != null) {
                    numList.add(node.left.val);
                    queue.offer(node.left);
                } else {
                    numList.add(-1);
                }
                if (node.right != null) {
                    numList.add(node.right.val);
                    queue.offer(node.right);
                } else {
                    numList.add(-1);
                }
            }
            boolean flag = isSymmetric(numList);
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric(List<Integer> numList) {
        int size = numList.size();
        int low = 0;
        int high = size - 1;
        while (low < high) {
            if (numList.get(low) != numList.get(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}