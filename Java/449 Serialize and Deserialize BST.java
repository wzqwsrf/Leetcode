
// 449. Serialize and Deserialize BST

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-11 21:54:03
 * @url:https://leetcode.com/problems/serialize-and-deserialize-bst/description/
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String data = sb.toString();
        int len = data.length();
        return data.substring(0, len - 1);
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(String.valueOf(root.val));
        sb.append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String array[] = data.split(",");
        return constructTree(array, 0, array.length);
    }

    private TreeNode constructTree(String array[], int l, int r) {
        if (l >= r) {
            return null;
        }
        int val = Integer.parseInt(array[l]);
        TreeNode root = new TreeNode(val);
        int k = l + 1;
        while (k < r && Integer.parseInt(array[k]) < val) {
            k++;
        }
        root.left = constructTree(array, l + 1, k);
        root.right = constructTree(array, k, r);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));