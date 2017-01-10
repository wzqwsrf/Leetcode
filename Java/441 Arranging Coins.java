
// 441. Arranging Coins

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-10 20:27:46
 * @url:https://leetcode.com/problems/arranging-coins/
 */

public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }
}