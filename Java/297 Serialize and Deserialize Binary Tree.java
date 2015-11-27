
// Serialize and Deserialize Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-18 14:26:25
 * @url:https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
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
public class Codec {

    private final String split = ",";
    private final String leaf = "L";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTreeToData(root, sb);
        return sb.toString();
    }

    private void buildTreeToData(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(leaf).append(split);
            return;
        }
        sb.append(root.val).append(split);
        buildTreeToData(root.left, sb);
        buildTreeToData(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(split)));
        return buildDataToTree(queue);
    }

    private TreeNode buildDataToTree(Queue<String> queue) {
        if (queue.size() == 0) {
            return null;
        }
        String node = queue.poll();
        if (node.equals("L")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildDataToTree(queue);
        root.right = buildDataToTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));