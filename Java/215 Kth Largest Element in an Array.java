
// Kth Largest Element in an Array

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:15:03
 * @url:https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            int num = 1;
            if (map.containsKey(nums[i])) {
                num += map.get(nums[i]);
            }
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
            map.put(nums[i], num);
        }
        Collections.sort(list);
        int allNum = 0;
        int result = 0;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            int num = list.get(i);
            int tempNum = map.get(num);
            if (allNum < k && tempNum + allNum >= k) {
                result = num;
                break;
            }
            allNum += tempNum;
        }
        return result;
    }
}

//use maxHeap to solve the problem
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        buildMaxHeap(nums);
        int i = len - 1;
        for (; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            k--;
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapify(nums, 0, i);
        }
        return nums[i + 1];
    }

    public void buildMaxHeap(int[] nums) {
        int len = nums.length;
        int index = len / 2 - 1;
        for (int i = index; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    private void maxHeapify(int[] nums, int index, int len) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < len && nums[max] < nums[left]) {
            max = left;
        }
        if (right < len && nums[max] < nums[right]) {
            max = right;
        }
        if (max != index) {
            int temp = nums[index];
            nums[index] = nums[max];
            nums[max] = temp;
            maxHeapify(nums, max, len);
        }
    }
}