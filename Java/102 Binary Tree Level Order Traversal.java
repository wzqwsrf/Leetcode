
// Binary Tree Level Order Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:02:03
 * @url:https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return list;
        }
        bfs(root, list);
        return list;
    }

    public void bfs(TreeNode root, ArrayList<ArrayList<Integer>> list) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode point = queue.peek();
                queue.poll();
                tempList.add(point.val);
                if (point.left != null) {
                    queue.offer(point.left);
                }
                if (point.right != null) {
                    queue.offer(point.right);
                }
            }
            list.add(tempList);
        }
    }
}