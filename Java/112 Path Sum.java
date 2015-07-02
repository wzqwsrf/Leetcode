
// Path Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:08:23
 * @url:https://leetcode.com/problems/path-sum/
 */

//BFS
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return (bfs(root, sum));
    }

    public boolean bfs(TreeNode root, int sum) {
        Queue<NodeSum> nodeQueue = new LinkedList<NodeSum>();
        nodeQueue.offer(new NodeSum(root, root.val));
        while (!nodeQueue.isEmpty()) {
            NodeSum node = nodeQueue.peek();
            nodeQueue.poll();
            if (node.node.left == null && node.node.right == null && node.sum == sum) {
                return true;
            }
            TreeNode point = node.node;
            int newSum = node.sum;
            if (point.left != null) {
                point = point.left;
                nodeQueue.offer(new NodeSum(point, (newSum + point.val)));
            }
            point = node.node;
            if (point.right != null) {
                point = point.right;
                nodeQueue.offer(new NodeSum(point, (newSum + point.val)));
            }
        }
        return false;
    }

    public class NodeSum {
        int sum;
        TreeNode node;

        NodeSum(TreeNode root, int sum) {
            super();
            this.node = root;
            this.sum = sum;
        }
    }
}

//DFS
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return (dfs(root, sum, root.val));
    }

    public boolean dfs(TreeNode root, int sum, int allSum) {
        if (root.left == null && root.right == null) {
            if (allSum == sum) {
                return true;
            }
        }
        TreeNode point = root;
        if (point.left != null) {
            point = point.left;
            if (dfs(point, sum, allSum + point.val)) {
                return true;
            }
        }
        point = root;
        if (point.right != null) {
            point = point.right;
            if (dfs(point, sum, allSum + point.val)) {
                return true;
            }
        }
        return false;
    }

    public class NodeSum {
        int sum;
        TreeNode node;

        NodeSum(TreeNode root, int sum) {
            super();
            this.node = root;
            this.sum = sum;
        }
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */