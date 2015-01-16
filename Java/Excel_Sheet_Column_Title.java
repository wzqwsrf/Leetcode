
// Excel Sheet Column Title 168ms

/**
 * Given a positive integer, return its corresponding column title as
 * appear in an Excel sheet.
 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 Credits:
 Special thanks to @ifanchu for adding this problem and creating all test cases.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:33:31
 * @url:https://oj.leetcode.com/problems/excel-sheet-column-title/
 * 数字转为26进制，注意，当低位为0时，需要从高位借1
 * 具体参考：
 */

public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int last = 0;
        while (n != 0) {
            int temp = n % 26;
            n /= 26;
            temp += last;
            if (n == 0 && temp == 0) {
                break;
            }
            char seq;
            if (temp <= 0) {
                seq = (char) (temp + 25 + 'A');
                last = -1;
            } else {
                seq = (char) (temp - 1 + 'A');
                last = 0;
            }
            sb.append(seq);
        }
        return sb.reverse().toString();
    }
}