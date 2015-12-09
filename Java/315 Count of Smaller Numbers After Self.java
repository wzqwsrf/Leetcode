
// Count of Smaller Numbers After Self

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-12-09 10:26:45
 * @url:https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        List<Integer> sortList = new ArrayList<Integer>();
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            int index = findIndex(sortList, nums[i]);
            list.add(index);
            sortList.add(index, nums[i]);
        }
        Collections.reverse(list);
        return list;
    }

    private int findIndex(List<Integer> sortList, int num) {
        int size = sortList.size();
        if (size == 0) {
            return 0;
        }
        if (sortList.get(0) >= num) {
            return 0;
        }
        if (sortList.get(size - 1) < num) {
            return size;
        }
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int curNum = sortList.get(mid);
            if (curNum < num) {
                left = mid + 1;
            } else if (curNum >= num) {
                right = mid;
            }
        }
        return left;
    }
}