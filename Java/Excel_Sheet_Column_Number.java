
// Excel Sheet Column Number 219ms

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 For example:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:33:31
 * @url:https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 将字符转为数字，就是26进制数字转换
 * 具体参考：
 */

public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int len = s.length();
        int n = 0;
        for (int i = 0; i < len; i++) {
            n += Math.pow(26, len - 1 - i) * (s.charAt(i) - 'A' + 1);
        }
        return n;
    }
}
