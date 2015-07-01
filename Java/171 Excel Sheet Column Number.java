
// Excel Sheet Column Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:33:31
 * @url:https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 将字符转为数字，就是26进制数字转换
 * 具体参考：
 */

public class Solution {

    public int titleToNumber(String s) {
        int len = s.length();
        int n = 0;
        for (int i = 0; i < len; i++) {
            n += Math.pow(26, len - 1 - i) * (s.charAt(i) - 'A' + 1);
        }
        return n;
    }
}
