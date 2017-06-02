
// 593. Valid Square

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 22:47:57
 * @url:https://leetcode.com/problems/valid-square/#/description
 */

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>(Arrays.asList(getDistance(p1, p2),
                getDistance(p1, p3), getDistance(p1, p4), getDistance(p2, p3),
                getDistance(p2, p4), getDistance(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}