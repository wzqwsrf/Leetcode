
// 447. Number of Boomerangs

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-15 20:32:02
 * @url:https://leetcode.com/problems/number-of-boomerangs/#/description
 */

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int m = points.length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < m; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = x * x + y * y;
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int val : map.values()) {
                count += val * (val - 1);
            }
        }
        return count;
    }
}