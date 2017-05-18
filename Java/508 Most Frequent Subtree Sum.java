
// 508. Most Frequent Subtree Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-18 17:09:25
 * @url:https://leetcode.com/problems/most-frequent-subtree-sum/#/description
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
    public Map<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        findSubtreeSum(root);
        List<Integer> list = new ArrayList<Integer>();
        int num = 0;
        Set<Integer> set = map.keySet();
        for (Integer sum : set) {
            int currentNum = map.get(sum);
            if (currentNum > num) {
                list.clear();
                list.add(sum);
                num = currentNum;
            } else if (currentNum == num) {
                list.add(sum);
            }
        }
        int size = list.size();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public int findSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + findSubtreeSum(root.left)
                + findSubtreeSum(root.right);
        int num = map.get(sum) == null ? 1 : map.get(sum) + 1;
        map.put(sum, num);
        return sum;
    }
}