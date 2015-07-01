
// String to Integer (atoi)

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:14:05
 * @url:https://leetcode.com/problems/string-to-integer-atoi/
 */

public class Solution {

    public int myAtoi(String str) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        int len = str.length();
        int flag = 1;

        long num = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && str.charAt(0) == '+') {
                flag = 1;
                continue;
            } else if (i == 0 && str.charAt(0) == '-') {
                flag = -1;
                continue;
            }
            if (num > Integer.MAX_VALUE){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = num * 10 + str.charAt(i) - '0';
            } else {
                break;
            }
        }
        if (num > Integer.MAX_VALUE){
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        num = num * flag;
        return (int) num;
    }
}
