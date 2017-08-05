
// 652. Find Duplicate Subtrees

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-05 16:17:52
 * @url:https://leetcode.com/problems/find-duplicate-subtrees/description/
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        dfs(root, map, list);
        return list;
    }

    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "null";
        }
        String key = String.valueOf(root.val) + "," +
                dfs(root.left, map, list) + "," + dfs(root.right, map, list);
        Integer num = map.get(key);
        if (num != null) {
            if (num == 1) {
                list.add(root);
            }
            num += 1;
        } else {
            num = 1;
        }
        map.put(key, num);
        return key;
    }
}