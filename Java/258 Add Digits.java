
// Add Digits

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-08-17 16:20:20
 * @url:https://leetcode.com/problems/add-digits/
 */

public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int tempNum1 = 0;
            while (num != 0) {
                int tempNum2 = num % 10;
                num /= 10;
                tempNum1 += tempNum2;
            }
            num = tempNum1;
        }
        return num;
    }
}

// 解法二
//public class Solution {
//    public int addDigits(int num) {
//        return (num - 1) % 9 + 1;
//    }
//}