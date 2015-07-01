
// Majority Element II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月01日16:13:15
 * @url:https://leetcode.com/problems/majority-element-ii/
 */

public class Solution {

    //解法一
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int len = nums.length;
        int thirdLen = len / 3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int num = 0;
            if (map.containsKey(nums[i])) {
                num = map.get(nums[i]);
            }
            num += 1;
            map.put(nums[i], num);
            if (num > thirdLen && !list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    //解法二
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int len = nums.length;
        int thirdLen = len / 3;
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < len; i++) {
            if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != num1) {
                num2 = nums[i];
                count2++;
            } else {
                if (nums[i] == num1) {
                    count1++;
                } else if (nums[i] == num2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                size1++;
            }
            if (nums[i] == num2) {
                size2++;
            }
        }
        if (size1 > thirdLen) {
            list.add(num1);
        }
        if (size2 > thirdLen && !list.contains(num2)) {
            list.add(num2);
        }
        return list;
    }
}
