
// 390. Elimination Game

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-24 11:45:04
 * @url:https://leetcode.com/problems/elimination-game/description/
 */

public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}

public class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}