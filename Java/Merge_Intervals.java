
// Merge Intervals

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日17:51:50
 * @url:https://leetcode.com/problems/merge-intervals/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null) {
            return intervals;
        }
        int size = intervals.size();
        if (size == 0 || size == 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }

        });
        ArrayList<Interval> list = new ArrayList<Interval>();
        Interval interval = intervals.get(0);
        int start = interval.start;
        int end = interval.end;
        for (int i = 1; i < size; i++) {
            Interval intval = intervals.get(i);
            if (intval.start <= end) {
                int tempSize = list.size();
                if (tempSize > 0) {
                    list.remove(tempSize - 1);
                }
                start = Math.min(start, intval.start);
                end = Math.max(end, intval.end);
            } else {
                if (i == 1) {
                    list.add(new Interval(start, end));
                }
                start = intval.start;
                end = intval.end;
            }
            list.add(new Interval(start, end));
        }
        return list;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

