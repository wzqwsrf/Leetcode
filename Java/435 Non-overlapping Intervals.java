
// 435. Non-overlapping Intervals

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-19 21:04:27
 * @url:https://leetcode.com/problems/non-overlapping-intervals/description/
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
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int count = 0;
        int len = intervals.length;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
            } else {
                count++;
            }
        }
        return count;
    }
}