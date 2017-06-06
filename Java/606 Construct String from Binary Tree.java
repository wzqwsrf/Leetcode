
// 606. Construct String from Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:45:48
 * @url:https://leetcode.com/problems/construct-string-from-binary-tree/#/description
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
    public String tree2str(TreeNode t) {
        String res = "";
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if ("".equals(left) && !"".equals(right)) {
            return t.val + "()" + "(" + right + ")";
        } else if (!"".equals(left) && "".equals(right)) {
            return t.val + "(" + left + ")";
        } else if ("".equals(left) && "".equals(right)) {
            return t.val + "";
        }
        return t.val +
                "(" + left + ")" +
                "(" + right + ")";
    }
}