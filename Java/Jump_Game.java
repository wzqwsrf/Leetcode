
//Jump Game 408ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年08月27日15:11:42
 * @url:https://oj.leetcode.com/problems/jump-game/
 * 题目比较拗口，多读几遍，加强理解，求是否可达
 * 具体参考http://blog.csdn.net/u013027996/article/details/38870915
 */

public class Jump_Game {
    public boolean canJump(int[] A) {
        int n = A.length;
        if (n == 0) {
            return false;
        }
        int maxReach = 0;
        int i = 0;
        while (i < n && i <= maxReach) {
            maxReach = Math.max(i + A[i], maxReach);
            i++;
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
