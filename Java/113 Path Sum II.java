
// Path Sum II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:09:20
 * @url:https://leetcode.com/problems/path-sum-ii/
 */

//BFS
public class Solution {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        return bfs(root, sum);
    }

    public ArrayList<ArrayList<Integer>> bfs(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<NodeSum> nodeQueue = new LinkedList<NodeSum>();
        StringBuffer sb = new StringBuffer(root.val + " ");
        nodeQueue.offer(new NodeSum(root, root.val, sb));
        while (!nodeQueue.isEmpty()) {
            NodeSum node = nodeQueue.peek();
            nodeQueue.poll();
            if (node.node.left == null && node.node.right == null && node.sum == sum) {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                String msg[] = node.sb.toString().trim().split(" ");
                int len = msg.length;
                for (int i = 0; i < len; i++) {
                    tempList.add(Integer.parseInt(msg[i]));
                }
                list.add(tempList);
            }
            TreeNode point = node.node;
            StringBuffer newsb = new StringBuffer(node.sb);
            int newSum = node.sum;
            if (point.left != null) {
                point = point.left;
                newsb.append(point.val + " ");
                nodeQueue.offer(new NodeSum(point, (newSum + point.val), newsb));
            }
            newsb = new StringBuffer(node.sb);
            point = node.node;
            if (point.right != null) {
                point = point.right;
                newsb.append(point.val + " ");
                nodeQueue.offer(new NodeSum(point, (newSum + point.val), newsb));
            }
        }
        return list;
    }

    public class NodeSum {
        int sum;
        TreeNode node;
        StringBuffer sb;

        NodeSum(TreeNode root, int sum, StringBuffer sb) {
            super();
            this.node = root;
            this.sum = sum;
            this.sb = sb;
        }
    }
}

//DFS
public class Solution {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        List<String> numList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(root, numList, sb, 0, sum);
        int size = numList.size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            String msg[] = numList.get(i).split(" ");
            for (int j = 0; j < msg.length; j++) {
                tempList.add(Integer.parseInt(msg[j]));
            }
            list.add(tempList);
        }
        return list;
    }

    public void dfs(TreeNode point, List<String> numList, StringBuffer sb, int allsum, int sum) {
        if (point == null) {
            return;
        }
        if (point.left == null && point.right == null) {
            sb.append(point.val + " ");
            if (allsum + point.val == sum) {
                String tempStr = sb.toString().trim();
                numList.add(tempStr);
            }
        }
        StringBuffer newsb = new StringBuffer(sb);
        sb.append(point.val + " ");
        dfs(point.left, numList, sb, allsum + point.val, sum);
        newsb.append(point.val + " ");
        dfs(point.right, numList, newsb, allsum + point.val, sum);
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