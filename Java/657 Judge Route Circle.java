
// 657. Judge Route Circle

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-14 23:34:47
 * @url:https://leetcode.com/problems/judge-route-circle/description/
 */

public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || "".equals(moves)) {
            return true;
        }
        int len = moves.length();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < len; i++) {
            if (moves.charAt(i) == 'U') {
                num1 += 1;
            } else if (moves.charAt(i) == 'D') {
                num1 -= 1;
            } else if (moves.charAt(i) == 'R') {
                num2 += 1;
            } else if (moves.charAt(i) == 'L') {
                num2 -= 1;
            }
        }
        return num1 == num2 && num1 == 0;
    }
}