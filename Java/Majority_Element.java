
//Majority Element 244ms

/**
 * Majority Element
 * Total Accepted: 13126 Total Submissions: 38490 My Submissions Question Solution
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月19日12:22:20
 * @url:https://oj.leetcode.com/problems/majority-element/ 方案很多，这里采取的是排序返回中位数
 */

public class Majority_Element {

    //解法一
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        int len = num.length;
        return num[len / 2];
    }

    //解法二
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int maxNum = nums[0];
        int count = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] == maxNum){
                count++;
            }else if(count == 0){
                maxNum = nums[i];
                count = 1;
            }else{
                count--;
            }
        }
        return maxNum;
    }
}
