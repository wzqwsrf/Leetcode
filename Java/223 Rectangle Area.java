
// Rectangle Area

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月11日13:24:20
 * @url:https://leetcode.com/problems/rectangle-area/
 */

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int together = 0;
        if (E >= C || A >= G || B >= H || F >= D) {
            together = 0;
        } else {
            int x = Math.min(C, G) - Math.max(A, E);
            int y = Math.min(D, H) - Math.max(B, F);
            together = x * y;
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - together;
    }
}