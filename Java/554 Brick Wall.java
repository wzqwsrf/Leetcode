
// 554. Brick Wall

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 21:21:42
 * @url:https://leetcode.com/problems/brick-wall/description/
 */

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxWidth = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                sum += list.get(i);
                Integer count = map.get(sum);
                if (count == null) {
                    count = 1;
                } else {
                    count += 1;
                }
                map.put(sum, count);
                maxWidth = maxWidth > count ? maxWidth : count;
            }
        }
        return height - maxWidth;
    }
}