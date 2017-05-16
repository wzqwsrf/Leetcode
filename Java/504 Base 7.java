
// 504. Base 7

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-16 14:33:39
 * @url:https://leetcode.com/problems/base-7
 */

public class Solution {
    public class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean flag = true;
            if (num < 0) {
                flag = false;
                num = -num;
            }
            String result = "";
            while (num > 0) {
                result = num % 7 + result;
                num /= 7;
            }
            result = flag ? result : "-" + result;
            return result;
        }
    }
}