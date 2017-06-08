
// 491. Increasing Subsequences

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-8 18:50:13
 * @url:https://leetcode.com/problems/increasing-subsequences/#/description
 */

public class Solution {
    private List<List<Integer>> resList;
    private int len;

    public List<List<Integer>> findSubsequences(int[] nums) {
        len = nums.length;
        resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(list, nums, 0);
        return resList;
    }

    private void dfs(List<Integer> list, int[] nums, int pos) {
        Set<Integer> used = new HashSet<>();
        int size = list.size();
        if (size >= 2) {
            resList.add(new ArrayList<>(list));
        }

        for (int i = pos; i < len; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if ((size == 0 || list.get(size - 1) <= nums[i])) {
                list.add(nums[i]);
                used.add(nums[i]);
                dfs(list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}