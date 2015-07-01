
// Integer to Roman

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:24:35
 * @url:https://leetcode.com/problems/integer-to-roman/
 */

public class Solution {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] nums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }
}

