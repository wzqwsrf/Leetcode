
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
 * @url:https://oj.leetcode.com/problems/majority-element/
 * 方案很多，这里采取的是排序返回中位数
 * 具体参考
 */

public class Majority_Element {
    public class Solution {
        public int majorityElement(int[] num) {
            Arrays.sort(num);
            int len = num.length;
            return num[len/2];
        }
    }
}
