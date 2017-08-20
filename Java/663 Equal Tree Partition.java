
// 663. Equal Tree Partition

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-20 17:58:58
 * @url:https://leetcode.com/problems/equal-tree-partition/description/
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
    private Map<Integer, Integer> map;

    public boolean checkEqualTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        map = new HashMap<Integer, Integer>();
        int sum = getTreeSum(root);
        if (sum == 0) {
            return map.getOrDefault(sum, 0) > 1;
        }
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }

    private int getTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + getTreeSum(root.left)
                + getTreeSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}