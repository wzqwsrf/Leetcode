
// Binary Tree Zigzag Level Order Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:02:12
 * @url:https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
        int k = 0;
        while (!queue.isEmpty()) {
            k++;
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
            if (k % 2 == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode point = queue.peek();
                    queue.poll();
                    tempList.add(point.val);
                    if (point.left != null) {
                        nodeList.add(point.left);
                    }
                    if (point.right != null) {
                        nodeList.add(point.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode point = queue.peek();
                    queue.poll();
                    tempList.add(point.val);
                    if (point.right != null) {
                        nodeList.add(point.right);
                    }
                    if (point.left != null) {
                        nodeList.add(point.left);
                    }
                }
            }
            int listSize = nodeList.size();
            for (int i = listSize - 1; i >= 0; i--) {
                queue.offer(nodeList.get(i));
            }
            list.add(tempList);
        }
    }
}