
// 436. Find Right Interval

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-19 23:30:08
 * @url:https://leetcode.com/problems/find-right-interval/description/
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int array[] = new int[len];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i].start, i);
            list.add(intervals[i].start);
        }
        Collections.sort(list);
        for (int i = 0; i < len; i++) {
            int key = getBinarySearch(list, intervals[i].end);
            if (key < intervals[i].end) {
                array[i] = -1;
            } else {
                array[i] = map.get(key);
            }
        }
        return array;
    }

    private int getBinarySearch(List<Integer> list, int val) {
        int size = list.size();
        int l = 0;
        int r = size - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) == val) {
                return val;
            }
            if (list.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.get(l);
    }
}