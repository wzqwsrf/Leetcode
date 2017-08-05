
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
    private List<TreeNode> list;
    private Map<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        list = new ArrayList<TreeNode>();
        map = new HashMap<String, Integer>();
        dfs(root);
        return list;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String key = String.valueOf(root.val) + "," +
                dfs(root.left) + "," + dfs(root.right);
        Integer num = map.getOrDefault(key, 0);
        if (num == 1) {
            list.add(root);
        }
        num += 1;
        map.put(key, num);
        return key;
    }
}