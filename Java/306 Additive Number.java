
// Additive Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-27 18:29:52
 * @url:https://leetcode.com/problems/additive-number/
 */

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int len = num.length();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);
                if (num1.charAt(0) == '0' && num1.length() > 1) {
                    continue;
                }
                if (num2.charAt(0) == '0' && num2.length() > 1) {
                    continue;
                }
                boolean flag = dfs(num.substring(j),
                        Long.parseLong(num1), Long.parseLong(num2));
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String num, long num1, long num2) {
        String num3 = num1 + num2 + "";
        int len = num3.length();
        if (num.length() < len) {
            return false;
        }
        if (num3.equals(num)) {
            return true;
        }
        if (num.substring(0, len).equals(num3)) {
            return dfs(num.substring(len), num2, Long.parseLong(num3));
        }
        return false;
    }
}