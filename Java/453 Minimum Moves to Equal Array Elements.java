
// 453. Minimum Moves to Equal Array Elements

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-11 13:51:49
 * @url:https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 */

public class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return sum - min * len;
    }
}

/**
 let's define sum as the sum of all the numbers, before any moves;
 minNum as the min number int the list; n is the length of the list;

 After, say m moves, we get all the numbers as x , and we will get the following equation

 sum + m * (n - 1) = x * n
 and actually,

 x = minNum + m
 and finally, we will get

 sum - minNum * n = m
 So, it is clear and easy now.
 */